package modelo;

public class UsuarioNoEstandar extends Usuario {

	public UsuarioNoEstandar(String nombre, String apellido, int dni) {
		super(nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comprar(String CodAsiento, AerolineaLanchita aero) {
		// TODO Auto-generated method stub
		aero.comprar(CodAsiento);
	}

}
