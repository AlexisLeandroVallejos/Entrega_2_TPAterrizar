package modelo;

public enum Clase {
	TURISTA, EJECUTIVA, PRIMERACLASE;

	private String descripcion;

	static {
		TURISTA.descripcion = "Turista";
		EJECUTIVA.descripcion = "Ejecutiva";
		PRIMERACLASE.descripcion = "PrimeraClase";

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
		return descripcion == "PrimeraClase";
	}

}
