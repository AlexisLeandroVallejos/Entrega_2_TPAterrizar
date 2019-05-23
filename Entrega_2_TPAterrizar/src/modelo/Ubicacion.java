package modelo;

public enum Ubicacion {
	VENTANA, CENTRO, PASILLO;

	private String descripcion;

	static {
		VENTANA.descripcion = "Ventana";
		CENTRO.descripcion = "Centro";
		PASILLO.descripcion = "Pasillo";

	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean esVentana() {
		return descripcion == "Ventana";
	}
	
	public boolean esCentro() {
		return descripcion == "Centro";
	}
	
	public boolean esPasillo() {
		return descripcion == "Pasillo";
	}
}
