package modelo;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OceanicBusquedaCompraYReserva{
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Busqueda en oceanic
	public static List<Asiento> asientosDisponiblesParaOrigen(OceanicCriterioDeBusqueda criterioBusqueda) {
		 List<Vuelo> listaDeVuelos = vuelosParaOrigen(criterioBusqueda).collect(Collectors.toList());
		 return asientosDisponibles(modificarCiudades(listaDeVuelos));
	}
	public static List<Asiento> asientosDisponiblesParaOrigenYDestino(OceanicCriterioDeBusqueda criterioBusqueda) {
		 List<Vuelo> listaDeVuelos = vuelosParaOrigen(criterioBusqueda)
				 .filter(vuelo -> vuelo.getDestino().equalsIgnoreCase(criterioBusqueda.getCodigoDestinoOceanic()))
			     .collect(Collectors.toList());
		 return asientosDisponibles(modificarCiudades(listaDeVuelos));
	}

	public static boolean estaReservado(OceanicCriterioDeReserva criterioReserva) {
		return Aerolinea.getAsientosSobreReservados().stream()
				.filter(reserva -> reserva.getAsiento().getCodigoDeVuelo() == criterioReserva.getCodigoDeVuelo())
				.filter(reserva -> reserva.getAsiento().getNumeroDeAsiento() == criterioReserva.getNumeroDeAsiento())
				.count() > 0; //no se si esto es correcto, necesito reservas y no puedo mandar usuario.
	}
	
	//Compra en oceanic
	public static boolean comprarSiHayDisponibilidad(OceanicCriterioDeCompra criterioCompra) {
		return false; //falta llenar esto.
	}
	
	//Reserva en oceanic
	public static boolean reservar(OceanicCriterioDeReserva criterioReserva) {
		return false; //falta llenar esto.
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static List<Vuelo> modificarCiudades(List<Vuelo> listaDeVuelos) {
		for(Vuelo vuelo : listaDeVuelos) {
			vuelo.setCiudades(vuelo.modificarCiudad());
		}
		return listaDeVuelos;
		
	}
	
	public static Stream<Vuelo> vuelosParaOrigen(OceanicCriterioDeBusqueda criterioBusqueda) {
		return Aerolinea.getVuelos().stream()
				.filter(vuelo -> vuelo.getOrigen().equalsIgnoreCase(criterioBusqueda.getCodigoOrigenOceanic()) 
						      && vuelo.getFechaSalida().equalsIgnoreCase(criterioBusqueda.getFechaSalida()));
	}
	
	public static List<Asiento> asientosDisponibles(List<Vuelo> vuelosModificados){
		return vuelosModificados.stream()
				.map(vuelo -> vuelo.getAsientos())
				.flatMap(asiento -> asiento.stream()) //los asientos van a estar en listas separadas, esto los pone en una sola.
				.filter(asiento -> asiento.getAerolinea() == "Oceanic") //si su estado es null, son asientosDTO.
				.collect(Collectors.toList());
	}	
}