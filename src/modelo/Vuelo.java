package modelo;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Vuelo {
	
	private final String codigoDeVuelo;
	private final String fechaSalida;
	private final String fechaLlegada;
	private final String horaSalida;
	private final String horaLlegada;
	private ArrayList<String> caracteristicasVuelo;
	private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
	private String origen;
	private String destino;

	public Vuelo(String codigoDeVuelo, String origen, String destino, String fechaSalida, String fechaLlegada,
			String horaSalida, String horaLlegada) {
		this.codigoDeVuelo = codigoDeVuelo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.caracteristicasVuelo = setCriterios();
		
	}

	public String getCodigoDeVuelo() {
		return codigoDeVuelo;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}



	public boolean cumpleAlgunCriterio(ArrayList<String> criteriosBusqueda) {
		//Cambiar busqueda para que sea mas especificamente por criterio
		return caracteristicasVuelo.stream().anyMatch(
				caracteristica -> criteriosBusqueda.stream().anyMatch(palabraCriterio -> palabraCriterio == caracteristica));
	}


	public boolean fechaEntreSalidaLlegada(String fecha) {
		//Cambiar busqueda para que sea mas especificamente por criterio
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMdd");
		try{
			Date fechaDate = simpleDate.parse(fecha);
			return (simpleDate.parse(this.getFechaLlegada()).compareTo(fechaDate) >= 0)
						&& simpleDate.parse(this.getFechaSalida()).compareTo(fechaDate) <= 0;
		}
		catch(Exception ex){
			
		}
		return false;
	}
	
	public ArrayList<String> setCriterios() {
		return caracteristicasVuelo = new ArrayList<>(
				Arrays.asList(origen, destino, fechaSalida, fechaLlegada, horaSalida, horaLlegada));
	}

	public String getCodDeVuelo() {
		return codigoDeVuelo;
	}

	public void agregarAsiento(Asiento asiento) {
		asientos.add(asiento); 
	}

	public boolean esCodDeVuelo(Asiento asiento) {
		return asiento.esCodigoDeVuelo(codigoDeVuelo);
	}

	public boolean estaDisponible(Asiento asiento) {
		return asiento.getEstadoAsiento().estaDisponible();
	}
//agregar filtro por super asientos
	public ArrayList<Asiento> obtenerAsientosDisponibles() {
		ArrayList<Asiento> listaAsientos = asientos.stream()
				.filter(asiento -> esCodDeVuelo(asiento) && estaDisponible(asiento))
				.collect(Collectors.toCollection(ArrayList<Asiento>::new));
		return listaAsientos;
	}
//Esta busqueda es para los asientos que se pueden reservar, que son todos los que no fueron comprados, hay que ver si se puede hacer mejor
	public ArrayList<Asiento> obtenerTodosLosAsientos() {
		ArrayList<Asiento> listaAsientos = asientos.stream()
				.filter(asiento -> esCodDeVuelo(asiento) && asiento.getEstadoAsiento().estaComprado() == false)
				.collect(Collectors.toCollection(ArrayList<Asiento>::new));
		return listaAsientos;
	}

	public ArrayList<Asiento> obtenerAsientosReservados() {
		ArrayList<Asiento> listaAsientos = asientos.stream()
				.filter(asiento -> esCodDeVuelo(asiento) && estaDisponible(asiento) == false)
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
	
	public double getDuracionVuelo()
	{

		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMdd kk:mm");
		try{
			Date salida = simpleDate.parse(this.getFechaLlegada() + horaSalida);
			Date llegada = simpleDate.parse(this.getFechaSalida() + this.horaLlegada);
			long mili = salida.getTime() - llegada.getTime();
			mili = Math.abs(mili);
			double dias = mili /1000; //Segundos
			dias = dias/60; //Minutos
			dias = dias/60; //Horas
			dias = dias/24;
			return (double)dias;
		}
		catch(Exception ex){
			
		}
		return 0;
	}
	
	public boolean ciudadDeDosDeExtension(String ciudad) {
		return ciudad.length() == 2;
	}
	
	public boolean esOrigen(String ciudad) {
		return ciudad.contains(origen);
	}
	
	public boolean esDestino(String ciudad) {
		return ciudad.contains(destino);
	}
	
	public boolean esSLA(String ciudad) {
		return ciudad.equalsIgnoreCase("SLA");
	}
	
	public List<String> getCiudades() {
		List<String> ciudades = Arrays.asList(origen, destino);
		return ciudades;
	}
	
	public String setCiudadSegunCriterio(String ciudad) {
		if(ciudad.equalsIgnoreCase("LA")) {
			return "SLA";
		}
		else if(ciudad.equalsIgnoreCase(origen)) {
			return origen + "_";
		}
		else{
			return destino + "_";
		}
	}
	
	public List<String> modificarCiudad() {
		return this.getCiudades().stream()
			.filter(ciudad -> this.ciudadDeDosDeExtension(ciudad))
			.map(ciudad -> this.setCiudadSegunCriterio(ciudad))
			.collect(Collectors.toList());
		
	}
	
	public Vuelo setCiudades(List<String> ciudades) {
		for (String ciudad : ciudades) {
			if((this.esSLA(ciudad) && origen.contains("LA")) || this.esOrigen(ciudad)) {
				this.setOrigen(ciudad);
			}
			else if ((this.esSLA(ciudad) && destino.contains("LA")) || this.esDestino(ciudad)) {
				this.setDestino(ciudad);
			}
		}
		return this;
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

}
