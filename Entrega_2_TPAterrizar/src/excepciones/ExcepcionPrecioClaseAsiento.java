package excepciones;

public class ExcepcionPrecioClaseAsiento extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6732701204359862721L;

	public ExcepcionPrecioClaseAsiento() {
		super("La clase de asiento ingresada es desconocida");

	}
}
