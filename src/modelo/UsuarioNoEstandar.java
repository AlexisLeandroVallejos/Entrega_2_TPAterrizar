package modelo;

public class UsuarioNoEstandar extends Usuario {

	final double recargoAUsuarioNoEstandar = 20; //Esto no se si va, ya esta en asiento...
	
	public UsuarioNoEstandar(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		super(nombre, apellido, dni, aerolinea);
	}

	//modificar el comprar para ponerle recargo
	public void comprar(String CodAsiento){
		try{
			Asiento asientoComprado =  aerolinea.comprar(CodAsiento, suscripto());
			super.compras.add(asientoComprado);
		}
		catch (Exception ex){
			throw ex;
		}
	}

	public void reservar(String CodAsiento) {
		try{
			Asiento asientoReservado = aerolinea.reservar(CodAsiento, suscripto(), this);
			super.reservas.add(asientoReservado);
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
}
