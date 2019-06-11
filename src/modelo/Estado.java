package modelo;

public enum Estado {
	DISPONIBLE, RESERVADO, COMPRADO;

	private String descripcion;

	static {
		DISPONIBLE.descripcion = "Disponible";
		RESERVADO.descripcion = "Reservado";
		COMPRADO.descripcion = "Comprado";

	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean estaDisponible() {
		return descripcion == "Disponible";
	}
	
	public boolean estaReservado() {
		return descripcion == "Reservado";
	}
	
	public boolean estaComprado() {
		return descripcion == "Comprado";
	}
}
