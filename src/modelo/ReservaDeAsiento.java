package modelo;

public class ReservaDeAsiento {
	private Asiento asiento;
	private Usuario usuario;
	
	
	public ReservaDeAsiento(Asiento asiento, Usuario usuario) {
		this.asiento = asiento;
		this.usuario = usuario;
	}
	public Asiento getAsiento() {
		return asiento;
	}
	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
