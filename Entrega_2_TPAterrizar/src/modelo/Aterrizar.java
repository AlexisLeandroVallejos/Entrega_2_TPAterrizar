package modelo;

import java.util.ArrayList;

public class Aterrizar implements AerolineaLanchita {
	private final double recargoAUsuarioNoEstandar = 20;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void registrarUsuario(Usuario usuario) {
		
	}

	@Override
	public ArrayList<ArrayList<Asiento>> asientosDisponibles
		(String origen, String fechaSalida, String horaSalida,
		String destino, String fechaLlegada, String horaLlegada) {
		return null;
	}

	@Override
	public void comprar(String codigoAsiento) {
		// TODO Auto-generated method stub
		
	}
	
	
}
