package modelo;

import excepciones.ExcepcionUsuarioNoStandarNoPuedeReservar;

public class UsuarioNoEstandar extends Usuario {

	final double recargoAUsuarioNoEstandar = 20; //Esto no se si va, ya esta en asiento...
	
	public UsuarioNoEstandar(String nombre, String apellido, int dni, AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos) {
		super(nombre, apellido, dni, aterrizarTramitesDeAsientos);
	}

	@Override
	//modificar el comprar para ponerle recargo
	public void comprar(Asiento asiento){
		try{
			aterrizarTramitesDeAsientos.comprar(asiento, suscripto(), this);
		}
		catch (Exception ex){
			throw ex;
		}
	}

	@Override
	public void reservar(Asiento asiento) throws ExcepcionUsuarioNoStandarNoPuedeReservar {
			
		throw new ExcepcionUsuarioNoStandarNoPuedeReservar();
	
	}
	
}
