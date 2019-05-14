package modelo;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	protected Aerolinea aerolinea;
	
	private ArrayList<ArrayList<String>> historicoBusquedas = new ArrayList<ArrayList<String>>();
	
	public Usuario(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.aerolinea = aerolinea;
	}
	
	public ArrayList<ArrayList<Asiento>> realizarBusqueda 
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList(origen, fechaSalida, horaSalida, destino, fechaLlegada, horaLlegada));
		this.historicoBusquedas.add(criterios);
			return aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida,
					destino, fechaLlegada, horaLlegada);
		
	}
	
	public void comprar(String CodAsiento){
		try{
			aerolinea.comprar(CodAsiento);
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public boolean suscripto() {
		return false;
	}
	
	public boolean superaComprasPorCienMil() {
		return false;
	}

	public ArrayList<ArrayList<String>> getHistoricoBusquedas() {
		return historicoBusquedas;
	}

}
