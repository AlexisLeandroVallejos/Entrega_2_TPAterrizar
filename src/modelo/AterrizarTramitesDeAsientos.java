package modelo;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.ExcepcionAsientoNoDisponible;

public class AterrizarTramitesDeAsientos {
	
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	private ArrayList<CombinacionAsientoUsuario> asientosSobreReservados = new ArrayList<CombinacionAsientoUsuario>();
	
	AerolineaLanchita aerolineaLanchita;
	Oceanic oceanic;
	private OceanicBusquedaCompraYReserva oceanicBusquedaCompraYReserva = new OceanicBusquedaCompraYReserva(this);

	// claseAsiento
	final static double asientoTurista = 250;
	final static double asientoEjecutivo = 500;
	final static double asientoPrimera = 1000;
	// ubicacionAsiento:
	final static double asientoPasillo = 200;
	final static double asientoCentro = 100;
	final static double asientoVentana = 300;
	// impuesto:
	final static double impuesto = 0.15;
	// recargo a usuarios no estandar:
	final static double recargoAUsuarioNoEstandar = 20;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
//Busquedas en Oceanic:
	public List<Asiento> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida) {
		OceanicCriterioDeBusqueda criterio = new OceanicCriterioDeBusqueda(codigoOrigenOceanic, fechaSalida);
		return oceanicBusquedaCompraYReserva.asientosDisponiblesParaOrigen(criterio);
	}

	public List<Asiento> asientosDisponiblesParaOrigenYDestino(String codigoOrigenOceanic, String fechaSalida, String codigoDestinoOceanic) {
		OceanicCriterioDeBusqueda criterio = new OceanicCriterioDeBusqueda(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic);
		return oceanicBusquedaCompraYReserva.asientosDisponiblesParaOrigenYDestino(criterio);
	}

	public boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento) {
		OceanicCriterioDeReserva criterio = new OceanicCriterioDeReserva(codigoDeVuelo, numeroDeAsiento);
		return oceanicBusquedaCompraYReserva.estaReservado(criterio);
	}

//Compra en Oceanic
	public boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento) {
		OceanicCriterioDeCompra criterio = new OceanicCriterioDeCompra(dni, codigoVuelo, numeroDeAsiento);
		return oceanicBusquedaCompraYReserva.comprarSiHayDisponibilidad(criterio);
	}

//Reserva en Oceanic
	public boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento) {
		OceanicCriterioDeReserva criterio = new OceanicCriterioDeReserva(dni, codigoVuelo, numeroDeAsiento);
		return oceanicBusquedaCompraYReserva.reservar(criterio);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////


	public OceanicBusquedaCompraYReserva getOceanicBusquedaCompraYReserva() {
		return oceanicBusquedaCompraYReserva;
	}

	public void setOceanicBusquedaCompraYReserva(OceanicBusquedaCompraYReserva oceanicBusquedaCompraYReserva) {
		this.oceanicBusquedaCompraYReserva = oceanicBusquedaCompraYReserva;
	}
	
	public Oceanic getOceanic() {
		return oceanic;
	}

	public void setOceanic(Oceanic oceanic) {
		this.oceanic = oceanic;
	}

	public List<Asiento> buscarAsientos(String origen, String fecha, String destino) {
		return buscarAsientos(origen, fecha, destino, null, 0, 0, false, null);
		 
	}
/*
	public List<Asiento> buscarAsientos(String origen, String fecha, String destino, Clase[] clase, double precioMin,
			double precioMax, boolean mostrarReservados, AsientoBusquedaOrden orden) {
		ArrayList<String> criterios = new ArrayList<>(Arrays.asList(origen, destino));


		
		List<Asiento> lista = vuelos.stream().filter(vuelo -> vuelo.cumpleAlgunCriterio(criterios))
				.filter(vuelo -> vuelo.fechaEntreSalidaLlegada(fecha))
				// nuevos filtros
				.map(vuelo -> ((mostrarReservados) ? vuelo.obtenerTodosLosAsientos()
						: vuelo.obtenerAsientosDisponibles()))
				.filter(asiento -> asiento.size() > 0).flatMap(Collection::stream)
				.filter(asiento -> precioMin == 0 || asiento.getPrecio() >= precioMin) // asiento.precioAsiento()
																							// no es el precioFinal!!!
				.filter(asiento -> precioMax == 0 || asiento.getPrecio() <= precioMax) // asiento.precioAsiento()
																							// no es el precioFinal!!!
				.filter(asiento -> clase == null || asiento.esClaseAsiento(clase))
				.collect(Collectors.toList());

		if (orden != null) {
			lista = orden.ordenarListaSegunCriterio(lista);
		}
		return lista;
	}
*/
	public List<Asiento> buscarAsientos(String origen, String fecha, String destino, Clase[] clase, double precioMin,
			double precioMax, boolean mostrarReservados, AsientoBusquedaOrden orden) {
		ArrayList<String> criterios = new ArrayList<>(Arrays.asList(origen, destino));
		List<Asiento> lista = vuelos.stream()
				.filter(vuelo -> vuelo.cumpleAlgunCriterio(criterios))
				.filter(vuelo -> vuelo.fechaEntreSalidaLlegada(fecha))
				.map(vuelo -> vuelo.buscarAsientos(clase, precioMin, precioMax, mostrarReservados))
				.flatMap(asientos -> asientos.stream())
				.collect(Collectors.toList());
		if (orden != null) {
			lista = orden.ordenarListaSegunCriterio(lista);
		}
		return lista;
	}
	
	
	public void transferenciaDeReserva(Asiento asientoExpirado) {
		ArrayList<CombinacionAsientoUsuario> siguienteReserva = new ArrayList<CombinacionAsientoUsuario>();
		siguienteReserva = (ArrayList<CombinacionAsientoUsuario>) asientosSobreReservados.stream()
				.filter(asientoSobreReservado -> asientoSobreReservado.getAsiento().getCodigoDeAsiento()
						.equals(asientoExpirado.getCodigoDeAsiento()))
				.collect(Collectors.toList());
		if (siguienteReserva.size() == 1) {
			asientoExpirado.setEstadoAsiento(Estado.DISPONIBLE);
			reservar(siguienteReserva.get(0).getAsiento(),
					siguienteReserva.get(0).getUsuario().suscripto(), siguienteReserva.get(0).getUsuario());
			asientosSobreReservados.remove(siguienteReserva.get(0));
		}
	}

	public ArrayList<ArrayList<Asiento>> asientosDisponibles(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {

		try {
			// Parsear los vuelos que nos mande aerolineas lanchita.
			// Para armar los vuelos y asientos

			// ArrayList<ArrayList<String>> respuestaAero =
			// aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida, destino,
			// fechaLlegada, horaLlegada);
			// Pido los asientos disponibles a la AerolineaLanchita por medio de la interfaz
			String deLanchitaJson = "[['EC0344-42','565.60','P','P','D'], ['EC0344-66','365.60','T','E','D']]";

			JSONArray j = (JSONArray) this.parsearJsonAerolinea(deLanchitaJson);

			ArrayList<String> criterios = new ArrayList<>(
					Arrays.asList(origen, destino, fechaSalida, fechaLlegada, horaSalida, horaLlegada));

			List<ArrayList<Asiento>> listaAsientos = vuelos.stream()
					.filter(vuelo -> vuelo.cumpleAlgunCriterio(criterios))
					.map(vuelo -> vuelo.obtenerAsientosDisponibles()).filter(asiento -> asiento.size() > 0)
					.collect(Collectors.toList());

			return (ArrayList<ArrayList<Asiento>>) listaAsientos;
		} catch (Exception ex) {
			return null;
		}
	}

	@SuppressWarnings("unused")
	private ArrayList<Vuelo> parsearJsonAerolinea(String deLanchitaJson) throws ParseException {

		try {
			JSONArray j = new JSONArray();
			org.json.simple.parser.JSONParser js = new org.json.simple.parser.JSONParser();
			j = (JSONArray) js.parse(deLanchitaJson.replace('\'', '\"').toString());
			ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
			// paso cada item a una lista de string, proximamente a asientos.
			for (int i = 0; i < j.size(); i++) {
				ArrayList<String> listAsientos = new ArrayList<String>();
				for (int k = 0; k < ((JSONArray) j.get(i)).size(); k++) {
					listAsientos.add(((JSONArray) j.get(i)).get(k).toString());

				}
				list.add(listAsientos);
			}
			int r = 0;
			r = 2;
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
	
	public Asiento comprar(Asiento asiento) {
		if(asiento.estadoAsiento.estaDisponible())
		{
			asiento.setEstadoAsiento(Estado.COMPRADO );
			return asiento;
		}
		else
		{
			throw new ExcepcionAsientoNoDisponible();
		}
		//return this.comprar(asiento.codigoDeAsiento, false);
	}

	public Asiento comprar(Asiento asiento, boolean aceptaOfertas, Usuario usuario) {
		if(asiento.estadoAsiento.estaDisponible() || 
				(asiento.estadoAsiento.estaReservado()  && usuario.getAsientosReservados().contains(asiento)))
		{
			if(!asiento.esSuperOferta() || aceptaOfertas) 
			{
				asiento.setEstadoAsiento(Estado.COMPRADO );
				return asiento;
			}
			throw new ExcepcionAsientoNoDisponible();
		}
		else
		{
			throw new ExcepcionAsientoNoDisponible();
		}
		//return this.comprar(asiento.codigoDeAsiento, false);
	}
	
	public Asiento reservar(Asiento asiento) {
		asiento.setEstadoAsiento(Estado.RESERVADO );
		return asiento;
		//return this.comprar(asiento.codigoDeAsiento, false);
	}

	public Asiento reservar(Asiento asiento, boolean aceptaOfertas, Usuario usuario) {
		try {
			if(asiento.estadoAsiento.estaDisponible())
			{
				asiento.setEstadoAsiento(Estado.RESERVADO );
			}else if(asiento.estadoAsiento.estaReservado()) {
				CombinacionAsientoUsuario reserva = new CombinacionAsientoUsuario(asiento, usuario);
				sobreReservar(reserva);
			}
			else
			{
				throw new ExcepcionAsientoNoDisponible();
			}
			return asiento;
		} catch (ExcepcionAsientoNoDisponible ex) {
			throw ex;
		} catch (Exception ex) {
			throw new ExcepcionAsientoNoDisponible();
		}
		//return this.comprar(asiento.codigoDeAsiento, aceptaOfertas);
	}

	public Asiento comprar(Asiento asiento, boolean aceptaOfertas) {
		if(asiento.estadoAsiento.estaDisponible() )
		{
			asiento.setEstadoAsiento(Estado.COMPRADO );
			return asiento;
		}
		else
		{
			throw new ExcepcionAsientoNoDisponible();
		}
		//return this.comprar(asiento.codigoDeAsiento, aceptaOfertas);
	}

	public void agregarVuelo(Vuelo vuelo) {
		vuelos.add(vuelo);
	}

//el asiento se agrega a la lista, dentro tiene la informacion del usuario que lo sobrereservo
	public void sobreReservar(CombinacionAsientoUsuario reserva) {
		asientosSobreReservados.add(reserva);
	}

	public ArrayList<CombinacionAsientoUsuario> getAsientosSobreReservados() {
		return asientosSobreReservados;
	}
}
