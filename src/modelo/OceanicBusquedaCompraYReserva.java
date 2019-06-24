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
		return asientoEvaluado(criterioReserva).getEstadoAsiento() == Estado.RESERVADO;
	}
	
	//Compra en oceanic
	public static boolean comprarSiHayDisponibilidad(OceanicCriterioDeCompra criterioCompra) {
		//asientoEvaluado(criterioCompra).setEstadoAsiento(Estado.COMPRADO);  esto setearia el asiento disponible en comprado, pero deberia ir despues del test?
		return !estaComprado(criterioCompra);
	}
	
	//Reserva en oceanic
	public static boolean reservar(OceanicCriterioDeReserva criterioReserva) {
		//asientoEvaluado(criterioReserva).setEstadoAsiento(Estado.RESERVADO); esto setearia el asiento disponible en reservado, pero deberia ir despues del test?
		return !estaReservado(criterioReserva);
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
				.filter(asiento -> asiento.getAerolinea() == "Oceanic") //solo asientos dto.
				.filter(asiento -> asiento.getEstadoAsiento() == Estado.DISPONIBLE) //disponibles.
				.collect(Collectors.toList());
	}	
	
	public static Asiento asientoEvaluado(OceanicCriterioCompraOReserva criterio) {
		return Aerolinea.getVuelos().stream()
					.filter(vuelo -> vuelo.getCodigoDeVuelo() == criterio.getCodigoDeVuelo())
					.map(vuelo -> vuelo.getAsientos())
					.flatMap(asiento -> asiento.stream())
					.filter(asiento -> asiento.getNumeroDeAsiento() == criterio.getNumeroDeAsiento())
					.collect(Collectors.toList())
					.get(0);
	}
	
	public static boolean estaComprado(OceanicCriterioDeCompra criterioCompra) {
		return asientoEvaluado(criterioCompra).getEstadoAsiento() == Estado.COMPRADO;
	}
	
}