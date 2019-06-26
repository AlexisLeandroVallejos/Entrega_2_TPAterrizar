package modelo;

public class UsuarioNoEstandar extends Usuario {

	final double recargoAUsuarioNoEstandar = 20; //Esto no se si va, ya esta en asiento...
	
	public UsuarioNoEstandar(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		super(nombre, apellido, dni, aerolinea);
	}

	//modificar el comprar para ponerle recargo
	public void comprar(String CodAsiento){
		try{
			aerolinea.comprar(CodAsiento, suscripto());
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	@Override
	public void reservar(String CodAsiento) {
		try {
			throw new Exception("Usuario no puede reservar al no estar registrado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
