package excepciones;

public class ExcepcionPrecioUbicacionAsiento extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -152211378900654565L;
	
	public ExcepcionPrecioUbicacionAsiento() {
		super("La ubicacion de asiento ingresada es desconocida");

	}
}
