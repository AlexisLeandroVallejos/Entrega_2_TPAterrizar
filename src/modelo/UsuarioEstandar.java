package modelo;

import excepciones.ExcepcionUsuarioEstandarNoPuedeComprarSuperOferta;

public class UsuarioEstandar extends Usuario {

	public UsuarioEstandar(String nombre, String apellido, int dni, AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos) {
		super(nombre, apellido, dni, aterrizarTramitesDeAsientos);
	}
	
	public boolean suscripto() {
		return true;
	}
	
	public void sumarADineroTotalGastado(double dinero){
		dineroTotalGastado += dinero;
	}
	
	public void comprar(Asiento asiento){
		if(asiento.esSuperOferta() && !esUsuarioVIP()) {
			throw new ExcepcionUsuarioEstandarNoPuedeComprarSuperOferta();
		}
		aterrizarTramitesDeAsientos.comprar(asiento, suscripto(), this);
	}

}
