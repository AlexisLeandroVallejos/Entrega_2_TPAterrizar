package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Vuelo {
	//private final Aerolinea aerolinea;
	private final String codDeVuelo;
	private final String origen;
	private final String destino;
	private final String fechaSalida;
	private final String fechaLlegada;
	private final String horaSalida;
	private final String horaLlegada;
	private ArrayList<String> criterios;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();

	public Vuelo(String codDeVuelo, String origen, String destino, String fechaSalida, String fechaLlegada,
			String horaSalida, String horaLlegada) {
		//this.aerolinea = aerolinea;
		this.codDeVuelo = codDeVuelo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.criterios = setCriterios();
		
	}

	public boolean cumpleAlgunCriterio(String criterio) {
		return criterios.stream().anyMatch(palabra -> palabra == criterio);
	}


	public boolean cumpleAlgunCriterio(ArrayList<String> criterio) {
		return criterios.stream().anyMatch(
				palabra -> criterio.stream().anyMatch(palabraCriterio -> palabraCriterio == palabra));
	}

	
	public ArrayList<String> setCriterios() {
		return criterios = new ArrayList<>(
				Arrays.asList(origen, destino, fechaSalida, fechaLlegada, horaSalida, horaLlegada));
	}

	public String getCodDeVuelo() {
		return codDeVuelo;
	}

	public void agregarAsiento(Asiento asiento) {
		asientos.add(asiento); 
	}

	public boolean esCodDeVuelo(Asiento asiento) {
		return asiento.esCodigoDeVuelo(codDeVuelo);
	}

	public boolean estaDisponible(Asiento asiento) {
		return asiento.esDisponible();
	}

	public ArrayList<Asiento> obtenerAsientos() {
		ArrayList<Asiento> listaAsientos = asientos.stream()
				.filter(asiento -> esCodDeVuelo(asiento) && estaDisponible(asiento))
				.collect(Collectors.toCollection(ArrayList<Asiento>::new));
		return listaAsientos;
	}
	
	public int cantidadDeAsientos() {
		return asientos.size();
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

}
