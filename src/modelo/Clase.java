package modelo;

public enum Clase {
	TURISTA, EJECUTIVO, PRIMERA;

	private String descripcion;
	private double precio;

	static {
		TURISTA.descripcion = "Turista";
		EJECUTIVO.descripcion = "Ejecutivo";
		PRIMERA.descripcion = "Primera";
		TURISTA.precio = AterrizarTramitesDeAsientos.asientoTurista;
		EJECUTIVO.precio = AterrizarTramitesDeAsientos.asientoEjecutivo;
		PRIMERA.precio = AterrizarTramitesDeAsientos.asientoPrimera;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
}
