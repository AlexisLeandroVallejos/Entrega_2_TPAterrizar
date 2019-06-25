package modelo;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.ExcepcionAsientoNoDisponible;

public class Aerolinea {
	
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	private ArrayList<CombinacionAsientoUsuario> asientosSobreReservados = new ArrayList<CombinacionAsientoUsuario>();
	private ArrayList<CombinacionAsientoUsuario> asientosReservados = new ArrayList<CombinacionAsientoUsuario>();
	private ArrayList<CombinacionAsientoUsuario> asientosComprados = new ArrayList<CombinacionAsientoUsuario>();
	
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
		List<Asiento> asientos = buscarAsientos(origen, fecha, destino, null, 0, 0, false, null);
		List<Asiento> asientosOceanic = asientosDisponiblesParaOrigenYDestino(origen, fecha, destino);
		asientos.addAll(asientosOceanic);
		return asientos;
	}

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
				.filter(asiento -> clase == null || asiento.esClaseAsiento(clase)).collect(Collectors.toList());

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
			reservar(siguienteReserva.get(0).getAsiento().getCodigoDeAsiento(),
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

	public Asiento comprar(String codigoAsiento) {
		return this.comprar(codigoAsiento, false);
	}

	public Asiento comprar(String codigoAsiento, boolean aceptaOfertas, Usuario usuario) {
		try {
			String codigoVuelo = codigoAsiento.split("-")[0];
			ArrayList<Asiento> asientoAComprar = null;
			for (Vuelo v : vuelos) {
				if (v.getCodDeVuelo().equalsIgnoreCase(codigoVuelo)) {
					if (aceptaOfertas) {
						asientoAComprar = (ArrayList<Asiento>) v.obtenerTodosLosAsientos().stream().filter(
								vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.collect(Collectors.toList());
						if (asientoAComprar.size() == 1 && asientoAComprar.get(0).getEstadoAsiento().estaDisponible()) {
							asientoAComprar.get(0).setEstadoAsiento(Estado.COMPRADO);
							asientosComprados.add(new CombinacionAsientoUsuario(asientoAComprar.get(0), usuario));
						} else if (asientoAComprar.size() == 1
								&& asientoAComprar.get(0).getEstadoAsiento().estaReservado()
						/* && asientoAComprar.get(0).getUsuario().equals(usuario) */) {
							asientoAComprar.get(0).setEstadoAsiento(Estado.COMPRADO);
							asientosComprados.add(new CombinacionAsientoUsuario(asientoAComprar.get(0), usuario));
						} else {
							throw new ExcepcionAsientoNoDisponible();
						}
					} else {
						asientoAComprar = (ArrayList<Asiento>) v.obtenerTodosLosAsientos().stream().filter(
								vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.filter(vueloAsiento -> vueloAsiento.esSuperOferta() == false)
								.collect(Collectors.toList());
						if (asientoAComprar.size() == 1 && asientoAComprar.get(0).getEstadoAsiento().estaDisponible()) {
							asientoAComprar.get(0).setEstadoAsiento(Estado.COMPRADO);
							asientosComprados.add(new CombinacionAsientoUsuario(asientoAComprar.get(0), usuario));
						} else if (asientoAComprar.size() == 1
								&& asientoAComprar.get(0).getEstadoAsiento().estaReservado()
						/* && asientoAComprar.get(0).getUsuario().equals(usuario) */ ) {
							asientoAComprar.get(0).setEstadoAsiento(Estado.COMPRADO);
							asientosComprados.add(new CombinacionAsientoUsuario(asientoAComprar.get(0), usuario));
						} else {
							throw new ExcepcionAsientoNoDisponible();
						}
					}
				}
			}
			return asientoAComprar.get(0);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public Asiento comprar(String codigoAsiento, boolean aceptaOfertas) {
		return this.comprar(codigoAsiento, aceptaOfertas, null);
	}

	public void agregarVuelo(Vuelo vuelo) {
		vuelos.add(vuelo);
	}

	// reservar tiene que tener el asiento directamente, mejorar codigo

	public Asiento reservar(String codigoAsiento, boolean aceptaOfertas, Usuario usuario) {
		try {
			String codigoVuelo = codigoAsiento.split("-")[0];
			ArrayList<Asiento> asientosEnEvaluacion = null;
			for (Vuelo v : vuelos) {
				if (v.getCodDeVuelo().equalsIgnoreCase(codigoVuelo)) {
					if (aceptaOfertas) {
						asientosEnEvaluacion = (ArrayList<Asiento>) v.obtenerTodosLosAsientos().stream().filter(
								vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.collect(Collectors.toList());
						if (asientosEnEvaluacion.size() == 1
								&& asientosEnEvaluacion.get(0).getEstadoAsiento().estaReservado()) {
							CombinacionAsientoUsuario reserva = new CombinacionAsientoUsuario(asientosEnEvaluacion.get(0), usuario);
							sobreReservar(reserva);
						} else if (asientosEnEvaluacion.size() == 1
								&& asientosEnEvaluacion.get(0).getEstadoAsiento().estaDisponible()) {
							asientosEnEvaluacion.get(0).setEstadoAsiento(Estado.RESERVADO);
							asientosReservados.add(new CombinacionAsientoUsuario(asientosEnEvaluacion.get(0), usuario));
						} else {
							throw new ExcepcionAsientoNoDisponible();
						}
					} else {
						asientosEnEvaluacion = (ArrayList<Asiento>) v.obtenerTodosLosAsientos().stream().filter(
								vueloAsiento -> vueloAsiento.getCodigoDeAsiento().equalsIgnoreCase(codigoAsiento))
								.filter(vueloAsiento -> vueloAsiento.esSuperOferta() == false)
								.collect(Collectors.toList());
						if (asientosEnEvaluacion.size() == 1
								&& asientosEnEvaluacion.get(0).getEstadoAsiento().estaReservado()) {
							CombinacionAsientoUsuario reserva = new CombinacionAsientoUsuario(asientosEnEvaluacion.get(0), usuario);
							sobreReservar(reserva);
						} else if (asientosEnEvaluacion.size() == 1
								&& asientosEnEvaluacion.get(0).getEstadoAsiento().estaDisponible()) {
							asientosEnEvaluacion.get(0).setEstadoAsiento(Estado.RESERVADO);
							asientosReservados.add(new CombinacionAsientoUsuario(asientosEnEvaluacion.get(0), usuario));
							
						} else {
							throw new ExcepcionAsientoNoDisponible();
						}
					}
				}
			}
			return asientosEnEvaluacion.get(0);
		} catch (Exception ex) {
			throw ex;
		}
	}

//el asiento se agrega a la lista, dentro tiene la informacion del usuario que lo sobrereservo
	public void sobreReservar(CombinacionAsientoUsuario reserva) {
		asientosSobreReservados.add(reserva);
	}

	public ArrayList<CombinacionAsientoUsuario> getAsientosSobreReservados() {
		return asientosSobreReservados;
	}

	public List<Asiento> getCompras(Usuario usuario) {
		return asientosComprados
				.stream()
				.filter(combinacion -> combinacion.getUsuario() == usuario)
				.map(combinacion -> combinacion.getAsiento())
				.collect(Collectors.toList());
	}
	
	public List<Asiento> getReservas(Usuario usuario) {
		return asientosComprados
				.stream()
				.filter(combinacion -> combinacion.getUsuario() == usuario)
				.map(combinacion -> combinacion.getAsiento())
				.collect(Collectors.toList());
	}
}
