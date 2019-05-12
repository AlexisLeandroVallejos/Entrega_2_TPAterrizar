package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import excepciones.ExcepcionAsientoReservado;

public class Aerolinea implements AerolineaLanchita {
	// vuelos va a tener el codigo de vuelo, relacionando ese vuelo con el asiento;
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
				  .filter(as -> as.size()>0)
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
		try {
			String CodigoVuelo = codigoAsiento.split("-")[0];
			Asiento asi = null;
			for(Vuelo v:vuelos)
			{
				if(v.getCodDeVuelo().equalsIgnoreCase(CodigoVuelo))
				{

					asi = (Asiento) v.obtenerAsientos().stream()
						.filter(vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
						.toArray()[0];
					asi.setEstadoAsiento("R");
					//break;
				}
			}
		}
		catch(Exception ex)
		{
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
	

	// dado un codDeVuelo obtiene los asientos que coincidan con ese codDeVuelo (que
	// esta en el codDeAsiento antes del "-")

}
