package modelo;

import java.util.ArrayList;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	
	public Usuario(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public ArrayList<ArrayList<String>> realizarBusqueda (String lugarOrigen, String lugarDestino, String fechaSalida, String fechaLlegada) {
			return null;
		
	}
	
	public void comprar(String CodAsiento, AerolineaLanchita aero){
		try{
			aero.comprar(CodAsiento);
		}
		catch (Exception ex){
			throw ex;
		}
	};
}
