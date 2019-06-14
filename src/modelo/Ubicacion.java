package modelo;

public enum Ubicacion {
	VENTANA, CENTRO, PASILLO;

	private String descripcion;
	private double precio;

	static {
		VENTANA.descripcion = "Ventana";
		CENTRO.descripcion = "Centro";
		PASILLO.descripcion = "Pasillo";
		VENTANA.precio = Aerolinea.asientoVentana;
		CENTRO.precio = Aerolinea.asientoCentro;
		PASILLO.precio = Aerolinea.asientoPasillo;

	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}

}
