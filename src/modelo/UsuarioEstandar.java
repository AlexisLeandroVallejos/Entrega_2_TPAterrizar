package modelo;

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

	public String ToString()
	{
		return this.getNombre() + " " + this.getApellido();
	}
}
