package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aerolinea implements AerolineaLanchita {
	// vuelos va a tener el codigo de vuelo, relacionando ese vuelo con el asiento;
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	@Override
	public ArrayList<ArrayList<String>> asientosDisponibles
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		ArrayList<String> criterios = 
				new ArrayList<>(Arrays.asList(origen, destino, fechaSalida,
						fechaLlegada, horaSalida, horaLlegada));
		//Si alguien sabe como pasar esto a ArrayList<ArrayList<String>> estaria muy bien porque funcionaria toda la busqueda...
		List<Object> streamloco = vuelos.stream()
					  .filter(vuelo -> hayAlgunoQueCumple(criterios,vuelo))
					  .map(vuelo -> vuelo.obtenerAsientos())
					  .collect(Collectors.toList());
		return null;
		
		/*ArrayList<Vuelo> vuelosfiltrados = vuelos.stream()
			  .filter(vuelo -> hayAlgunoQueCumple(criterios,vuelo))
			  .collect(Collectors.toCollection(ArrayList<Vuelo> :: new));
		ArrayList<Vuelo> vuelosSinNull = vuelosfiltrados.stream()
				.filter(vuelo -> vuelo.equals(null))
				.collect(Collectors.toCollection(ArrayList<Vuelo> :: new));
		List<String> asientos = vuelosSinNull.stream()
				.map(vuelo -> vuelo.obtenerAsientos())
				.map(object -> object.toString())
				.collect(Collectors.toList());
		new ArrayList<ArrayList<String>>(asientos);
		*/
		
			  
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public void comprar(String codigoAsiento) {
		// TODO Auto-generated method stub

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
