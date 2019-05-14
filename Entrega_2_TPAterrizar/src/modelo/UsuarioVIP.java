package modelo;

public class UsuarioVIP extends Usuario {
	
	public UsuarioVIP(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		super(nombre, apellido, dni, aerolinea);
	}
	
	public boolean puedePagar() {
		return true;
	}
	
	public boolean superaComprasPorCienMil() {
		return true;
	}
	

	public void comprar(String CodAsiento){
		try{
			aerolinea.comprar(CodAsiento, true);
		}
		catch (Exception ex){
			throw ex;
		}
	}

}
