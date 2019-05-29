package modelo;

public enum Clase {
	TURISTA, EJECUTIVA, PRIMERA;

	private String descripcion;

	static {
		TURISTA.descripcion = "Turista";
		EJECUTIVA.descripcion = "Ejecutiva";
		PRIMERA.descripcion = "Primera";

	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean esTurista() {
		return descripcion == "Turista";
	}
	
	public boolean esEjecutiva() {
		return descripcion == "Ejecutiva";
	}
	
	public boolean esPrimeraClase() {
		return descripcion == "Primera";
	}

}
