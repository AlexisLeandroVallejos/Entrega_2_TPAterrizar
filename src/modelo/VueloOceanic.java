package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VueloOceanic extends Vuelo {

	public VueloOceanic(String codigoDeVuelo, String origen, String destino, String fechaSalida, String fechaLlegada,
			String horaSalida, String horaLlegada) {
		super(codigoDeVuelo, origen, destino, fechaSalida, fechaLlegada, horaSalida, horaLlegada);
	}
	
	public List<Asiento> buscarAsientos(Clase[] clase, double precioMin, double precioMax, boolean mostrarReservados) {
			this.setCiudades(this.modificarCiudad());
			return asientosObtenidos(mostrarReservados, precioMin, precioMax, clase);
	}
	
	public boolean fechaEntreSalidaLlegada(String fecha) {
		//Cambiar busqueda para que sea mas especificamente por criterio
		try{
			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate fechaDeSalida = LocalDate.parse(fecha, formatoFecha);
			LocalDate llegadaDate = LocalDate.parse(getFechaLlegada(), formatoFecha);
			LocalDate salidaDate = LocalDate.parse(getFechaSalida(), formatoFecha);
			return (llegadaDate.compareTo(fechaDeSalida) >= 0)
				    && salidaDate.compareTo(fechaDeSalida) <= 0;
		}
		catch(Exception ex){
			
		}
		return false;
	}

	public ArrayList<Asiento> obtenerTodosLosAsientos() {
		ArrayList<Asiento> listaAsientos = asientos.stream()
				.filter(asiento -> asiento.getEstadoAsiento().estaComprado() == false && esCodDeVuelo(asiento))// )
				.collect(Collectors.toCollection(ArrayList<Asiento>::new));
		return listaAsientos;
	}
	
}
