package modelo;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	protected Aerolinea aerolinea;
	protected double dineroTotalGastado;
	
	private ArrayList<ArrayList<String>> historicoBusquedas = new ArrayList<ArrayList<String>>();
	
	public Usuario(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		this.setNombre(nombre);
		this.apellido = apellido;
		this.setDni(dni);
		this.aerolinea = aerolinea;
	}
	
	private void setDni(int _dni) {
		this.dni = _dni;
	}
	
	private int getDni(){
		return dni;
	}

	private void setNombre(String _nombre) {
		this.nombre = _nombre;
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

	public ArrayList<ArrayList<String>> getHistoricoBusquedas() {
		return historicoBusquedas;
	}

	public String getNombre() {
		return nombre;
	}

}
