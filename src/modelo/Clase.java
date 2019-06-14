package modelo;

public enum Clase {
	TURISTA, EJECUTIVO, PRIMERA;

	private String descripcion;
	private double precio;

	static {
		TURISTA.descripcion = "Turista";
		EJECUTIVO.descripcion = "Ejecutivo";
		PRIMERA.descripcion = "Primera";
		TURISTA.precio = Aerolinea.asientoTurista;
		EJECUTIVO.precio = Aerolinea.asientoEjecutivo;
		PRIMERA.precio = Aerolinea.asientoPrimera;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
}
