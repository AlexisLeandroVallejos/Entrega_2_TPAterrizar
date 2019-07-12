package excepciones;

public class ExcepcionAsientoNoDisponible extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6910010594427746233L;
	
	public ExcepcionAsientoNoDisponible(){
		super("El asiento se encuentra reservado o comprado");
		
	}
}
