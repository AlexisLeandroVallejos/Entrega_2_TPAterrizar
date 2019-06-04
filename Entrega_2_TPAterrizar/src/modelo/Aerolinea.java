package modelo;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.ExcepcionAsientoNoDisponible;

public class Aerolinea {
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	//claseAsiento
	final static double asientoTurista = 250;
	final static double asientoEjecutivo = 500;
	final static double asientoPrimeraClase = 1000;
	//ubicacionAsiento:
	final static double asientoPasillo = 200;
	final static double asientoCentro = 100;
	final static double asientoVentana = 300;
	//impuesto:
	final static double impuesto = 0.15;
	//recargo a usuarios no estandar:
	final static double recargoAUsuarioNoEstandar = 20;
	private ArrayList<Asiento> asientosSobreReservados = new ArrayList<Asiento>();
	AerolineaLanchita aerolinea;
	
	public ArrayList<ArrayList<Asiento>> asientosDisponibles
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		try
		{
			//Parsear los vuelos que nos mande aerolineas lanchita.
			//Para armar los vuelos y asientos
			
			//ArrayList<ArrayList<String>> respuestaAero = aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida, destino, fechaLlegada, horaLlegada);
			//Pido los asientos disponibles a la AerolineaLanchita por medio de la interfaz
			String deLanchitaJson = "[['EC0344-42','565.60','P','P','D'], ['EC0344-66','365.60','T','E','D']]";
			
			JSONArray j = (JSONArray) this.parsearJsonAerolinea(deLanchitaJson);
			
			ArrayList<String> criterios = new ArrayList<>(
					Arrays.asList(origen, destino, fechaSalida,	fechaLlegada, horaSalida, horaLlegada));
			
			List<ArrayList<Asiento>> listaAsientos = vuelos.stream()
					  .filter(vuelo -> vuelo.cumpleAlgunCriterio(criterios))
					  .map(vuelo -> vuelo.obtenerAsientosDisponibles())
					  .filter(asiento -> asiento.size()>0)
					  .collect(Collectors.toList());
			
			
			return (ArrayList<ArrayList<Asiento>>) listaAsientos;
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private ArrayList<Vuelo> parsearJsonAerolinea(String deLanchitaJson) throws ParseException {

		try {
			JSONArray j = new JSONArray();
			org.json.simple.parser.JSONParser js = new org.json.simple.parser.JSONParser();
			j = (JSONArray)js.parse(deLanchitaJson.replace('\'', '\"').toString() ) ;
			ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
			//paso cada item a una lista de string, proximamente a asientos.
			for (int i=0; i<j.size(); i++) {
				ArrayList<String> listAsientos = new ArrayList<String>();
				for(int k=0; k< ((JSONArray)j.get(i)).size(); k ++)
				{
					listAsientos.add(((JSONArray)j.get(i)).get(k).toString());
					
				}
			    list.add( listAsientos );
			}
			int r = 0;
			r= 2;
		} catch (ParseException e) {
			throw e;
		}
		return null;
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
						asientoAComprar = (ArrayList<Asiento>) v.obtenerAsientosDisponibles().stream()
								.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.collect(Collectors.toList());
						if(asientoAComprar.size() == 1) {
							asientoAComprar.get(0).setEstadoAsiento(Estado.RESERVADO);
						}else {
							throw new ExcepcionAsientoNoDisponible();
						}
					}else{
						asientoAComprar = (ArrayList<Asiento>) v.obtenerAsientosDisponibles().stream()
							.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
							.filter(vueloAsiento -> vueloAsiento.esSuperOferta() == false)
							.collect(Collectors.toList());
						if(asientoAComprar.size() == 1) {
							asientoAComprar.get(0).setEstadoAsiento(Estado.RESERVADO);
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

	public void reservar(String codigoAsiento, boolean aceptaOfertas) {
		try {
			String codigoVuelo = codigoAsiento.split("-")[0];
			ArrayList<Asiento> asientoAReservar = null;
			for(Vuelo v:vuelos){
				if(v.getCodDeVuelo().equalsIgnoreCase(codigoVuelo)){
					if(aceptaOfertas){
						asientoAReservar = (ArrayList<Asiento>) v.obtenerTodosLosAsientos().stream()
								.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.collect(Collectors.toList());
						if(asientoAReservar.size() == 1 && asientoAReservar.get(0).getEstadoAsiento().esReservado()){
							sobreReservar(asientoAReservar.get(0));
						}
						if(asientoAReservar.size() == 1 && asientoAReservar.get(0).getEstadoAsiento().esDisponible()) {
							asientoAReservar.get(0).setEstadoAsiento(Estado.RESERVADO);
						}
						else {
							throw new ExcepcionAsientoNoDisponible();
						}
					}else{
						asientoAReservar = (ArrayList<Asiento>) v.obtenerAsientosDisponibles().stream()
								.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.filter(vueloAsiento -> vueloAsiento.esSuperOferta() == false)
								.collect(Collectors.toList());
						if(asientoAReservar.size() == 1) {
							asientoAReservar.get(0).setEstadoAsiento(Estado.RESERVADO);
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
//el asiento se agrega a la lista, dentro tiene la informacion del usuario que lo sobrereservo
	private void sobreReservar(Asiento asiento) {
		asientosSobreReservados.add(asiento);
	}
}
