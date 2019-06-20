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
			Asiento asientoComprado = aerolinea.comprar(CodAsiento, esUsuarioVIP(), this);
			super.compras.add(asientoComprado);
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

	public void reservar(String CodAsiento) {
		try{
			Asiento asientoReservado = aerolinea.reservar(CodAsiento, esUsuarioVIP(), this);
			super.reservas.add(asientoReservado);
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public String ToString()
	{
		return this.getNombre() + " " + this.getApellido();
	}
}
