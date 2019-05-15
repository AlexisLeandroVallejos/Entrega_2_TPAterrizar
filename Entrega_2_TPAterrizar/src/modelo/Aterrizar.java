package modelo;

import java.util.ArrayList;

public class Aterrizar implements AerolineaLanchita {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 
	private Aerolinea aerolinea;

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
		return aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida, destino, fechaLlegada, horaLlegada);
	}

	@Override
	public void comprar(String codigoAsiento){
		aerolinea.comprar(codigoAsiento);
	}
	
	public void comprar(String codigoAsiento, Usuario user){
		aerolinea.comprar(codigoAsiento);
	}
	
	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
}
