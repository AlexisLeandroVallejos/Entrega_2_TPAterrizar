package modelo;

import java.util.ArrayList;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	protected Aerolinea aerolinea;
	
	public Usuario(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.aerolinea = aerolinea;
	}
	
	public ArrayList<ArrayList<Asiento>> realizarBusqueda 
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
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
	
	public boolean puedePagar() {
		return false;
	}
	
	public boolean superaComprasPorCienMil() {
		return false;
	}
}
