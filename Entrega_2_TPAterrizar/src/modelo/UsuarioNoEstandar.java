package modelo;

public class UsuarioNoEstandar extends Usuario {

	final double recargoAUsuarioNoEstandar = 20;
	
	public UsuarioNoEstandar(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		super(nombre, apellido, dni, aerolinea);
	}

	//modificar el comprar para ponerle recargo
	public void comprar(String CodAsiento){
		try{
			aerolinea.comprar(CodAsiento, false);
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
}
