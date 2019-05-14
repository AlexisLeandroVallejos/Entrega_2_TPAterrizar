package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.ExcepcionAsientoReservado;

public class Aerolinea implements AerolineaLanchita {
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	@Override
	public ArrayList<ArrayList<Asiento>> asientosDisponibles
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList(origen, destino, fechaSalida,	fechaLlegada, horaSalida, horaLlegada));
		
		List<ArrayList<Asiento>> listaAsientos = vuelos.stream()
				  .filter(vuelo -> hayAlgunoQueCumple(criterios,vuelo))
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


	@Override
	public void comprar(String codigoAsiento) {
		this.comprar(codigoAsiento, false);
	}
	
	public void comprar(String codigoAsiento, boolean aceptaOfertas) {
		try {
			String codigoVuelo = codigoAsiento.split("-")[0];
			Asiento asientoAComprar = null;
			for(Vuelo v:vuelos){
				if(v.getCodDeVuelo().equalsIgnoreCase(codigoVuelo)){
					if(aceptaOfertas)
					{
						asientoAComprar = (Asiento) v.obtenerAsientos().stream()
								.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.toArray()[0];
							asientoAComprar.setEstadoAsiento("R");
						
					}else
					{

						asientoAComprar = (Asiento) v.obtenerAsientos().stream()
							.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
							.filter(vueloAsiento -> vueloAsiento.esSuperOferta() == false)
							.toArray()[0];
						asientoAComprar.setEstadoAsiento("R");
					}
					
					//break;
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

	public boolean hayAlgunoQueCumple(ArrayList<String> criterios, Vuelo vuelo) {
		return criterios.stream()
				.anyMatch(criterio -> vuelo.cumpleAlgunCriterio(criterio));
	}
	
}
