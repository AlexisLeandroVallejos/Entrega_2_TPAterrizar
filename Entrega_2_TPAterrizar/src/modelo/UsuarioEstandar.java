package modelo;

public class UsuarioEstandar extends Usuario {

	public UsuarioEstandar(String nombre, String apellido, int dni) {
		super(nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comprar(String CodAsiento, AerolineaLanchita aero) {
		// TODO Auto-generated method stub
		aero.comprar(CodAsiento);
	}
}
