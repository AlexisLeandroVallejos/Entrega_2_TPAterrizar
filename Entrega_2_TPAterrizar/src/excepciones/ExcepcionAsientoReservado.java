package excepciones;

public class ExcepcionAsientoReservado extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6910010594427746233L;
	
	public ExcepcionAsientoReservado()
	{
		super("El asiento se encuentra reservado");
		
	}
}
