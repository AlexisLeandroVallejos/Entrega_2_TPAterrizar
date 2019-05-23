package modelo;

public class UsuarioEstandar extends Usuario {

	public UsuarioEstandar(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		super(nombre, apellido, dni, aerolinea);
	}
	
	public boolean suscripto() {
		return true;
	}
	
	@Override
	public void comprar(String CodAsiento){
		try{
			aerolinea.comprar(CodAsiento, esUsuarioVIP());
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public void sumarADineroTotalGastado(double dinero){
		dineroTotalGastado += dinero;
	}
	
	public boolean esUsuarioVIP(){
		return dineroTotalGastado >= 100000.0;
	}
}
