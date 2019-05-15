package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.ExcepcionAsientoNoDisponible;

public class Aerolinea {
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	//claseAsiento:
	final static double asientoTurista = 250;
	final static double asientoEjecutivo = 500;
	final static double asientoPrimeraClase = 1000;
	//ubicacionAsiento:
	final static double asientoPasillo = 200;
	final static double asientoCentro = 100;
	final static double asientoVentanilla = 300;
	//impuesto:
	final static double impuesto = 0.15;
	//recargo a usuarios no estandar:
	final static double recargoAUsuarioNoEstandar = 20;
	
	AerolineaLanchita aerolinea;
	
	
	public ArrayList<ArrayList<Asiento>> asientosDisponibles
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		
		//Parsear los vuelos que nos mande aerolineas lanchita.
		//Para armar los vuelos y asientos
		
		//ArrayList<ArrayList<String>> respuestaAero = aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida, destino, fechaLlegada, horaLlegada);
		//Pido los asientos disponibles a la AerolineaLanchita por medio de la interfaz
		
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList(origen, destino, fechaSalida,	fechaLlegada, horaSalida, horaLlegada));
		
		List<ArrayList<Asiento>> listaAsientos = vuelos.stream()
				  .filter(vuelo -> vuelo.cumpleAlgunCriterio(criterios))
				  .map(vuelo -> vuelo.obtenerAsientos())
				  .filter(asiento -> asiento.size()>0)
				  .collect(Collectors.toList());
		
		
		return (ArrayList<ArrayList<Asiento>>) listaAsientos;
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}


	public void comprar(String codigoAsiento) {
		this.comprar(codigoAsiento, false);
	}
	
	public void comprar(String codigoAsiento, boolean aceptaOfertas) {
		try {
			String codigoVuelo = codigoAsiento.split("-")[0];
			ArrayList<Asiento> asientoAComprar = null;
			for(Vuelo v:vuelos){
				if(v.getCodDeVuelo().equalsIgnoreCase(codigoVuelo)){
					if(aceptaOfertas){
						asientoAComprar = (ArrayList<Asiento>) v.obtenerAsientos().stream()
								.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.collect(Collectors.toList());
						if(asientoAComprar.size() == 1) {
							asientoAComprar.get(0).setEstadoAsiento("R");
						}else {
							throw new ExcepcionAsientoNoDisponible();
						}
					}else{
						asientoAComprar = (ArrayList<Asiento>) v.obtenerAsientos().stream()
							.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
							.filter(vueloAsiento -> vueloAsiento.esSuperOferta() == false)
							.collect(Collectors.toList());
						if(asientoAComprar.size() == 1) {
							asientoAComprar.get(0).setEstadoAsiento("R");
						}else {
							throw new ExcepcionAsientoNoDisponible();
						}
					}
				}
			}
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public void agregarVuelo(Vuelo vuelo) {
		vuelos.add(vuelo);

	}
	
}
