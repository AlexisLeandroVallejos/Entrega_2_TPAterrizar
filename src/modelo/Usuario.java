package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import excepciones.ExcepcionUsuarioNoStandarNoPuedeReservar;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	protected Aerolinea aerolinea;
	protected double dineroTotalGastado;
	
	private ArrayList<Asiento> asientosReservados = new ArrayList<Asiento>();
	private ArrayList<Asiento> asientosComprados = new ArrayList<Asiento>();
	
	private ArrayList<ArrayList<String>> historicoBusquedas = new ArrayList<ArrayList<String>>();
	
	public Usuario(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.aerolinea = aerolinea;
	}
	
	public ArrayList<Asiento> getAsientosReservados() {
		return asientosReservados;
	}

	public void setAsientosReservados(ArrayList<Asiento> asientosReservados) {
		this.asientosReservados = asientosReservados;
	}

	public ArrayList<Asiento> getAsientosComprados() {
		return asientosComprados;
	}

	public void setAsientosComprados(ArrayList<Asiento> asientosComprados) {
		this.asientosComprados = asientosComprados;
	}
	
	public String getApellido() {
		return apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String _nombre) {
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
			asientosComprados.add(aerolinea.comprar(CodAsiento));
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public boolean esUsuarioVIP(){
		return dineroTotalGastado >= 100000.0;
	}

	public void reservar(String CodAsiento) throws ExcepcionUsuarioNoStandarNoPuedeReservar {
		try{
			aerolinea.reservar(CodAsiento, esUsuarioVIP(), this);
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
}
