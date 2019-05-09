package modelo;

import java.util.ArrayList;

public class Aterrizar {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void registrarUsuario(String nombre, String apellido, int dni) {
		Usuario usuario = new Usuario(nombre, apellido, dni);
		usuarios.add(usuario);
	}
	
	
}
