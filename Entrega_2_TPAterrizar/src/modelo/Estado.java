package modelo;

public enum Estado {
	DISPONIBLE, RESERVADO;

	private String descripcion;

	static {
		DISPONIBLE.descripcion = "Disponible";
		RESERVADO.descripcion = "Reservado";

	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean esDisponible() {
		return descripcion == "Disponible";
	}
	
	public boolean esReservado() {
		return descripcion == "Reservado";
	}
}
