package excepciones;

public class ExcepcionUsuarioNoEstandarNoPuedeReservar extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2325496707022665812L;
	public ExcepcionUsuarioNoEstandarNoPuedeReservar(){
		super("Usuario no puede reservar al no estar registrado");
		
	}
}
