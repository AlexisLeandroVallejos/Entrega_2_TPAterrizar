package modelo;

public class UsuarioVIP extends Usuario {
	
	private int _montoMinimoViajes = 100000;
	
	public UsuarioVIP(String nombre, String apellido, int dni) {
		super(nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comprar(String codAsiento, AerolineaLanchita aero) {
		// TODO Auto-generated method stub
		aero.comprar(codAsiento);
	}

}
