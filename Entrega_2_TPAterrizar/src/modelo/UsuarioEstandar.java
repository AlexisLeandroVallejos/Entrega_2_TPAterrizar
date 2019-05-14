package modelo;

public class UsuarioEstandar extends Usuario {

	public UsuarioEstandar(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		super(nombre, apellido, dni, aerolinea);
	}
	
	public boolean puedePagar() {
		return true;
	}
	
}
