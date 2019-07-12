package modelo;

import excepciones.ExcepcionUsuarioNoEstandarNoPuedeComprarSuperOferta;
import excepciones.ExcepcionUsuarioNoEstandarNoPuedeReservar;

public class UsuarioNoEstandar extends Usuario {

	final double recargoAUsuarioNoEstandar = 20; //Esto no se si va, ya esta en asiento...
	
	public UsuarioNoEstandar(String nombre, String apellido, int dni, AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos) {
		super(nombre, apellido, dni, aterrizarTramitesDeAsientos);
	}

	@Override
	//modificar el comprar para ponerle recargo
	public void comprar(Asiento asiento){
		if(asiento.esSuperOferta()) {
			throw new ExcepcionUsuarioNoEstandarNoPuedeComprarSuperOferta();
		}
		aterrizarTramitesDeAsientos.comprar(asiento, suscripto(), this);
	}

	@Override
	public void reservar(Asiento asiento) throws ExcepcionUsuarioNoEstandarNoPuedeReservar {
		throw new ExcepcionUsuarioNoEstandarNoPuedeReservar();
	}
	
}
