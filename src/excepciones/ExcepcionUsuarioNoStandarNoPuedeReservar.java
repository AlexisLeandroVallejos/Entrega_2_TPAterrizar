package excepciones;

public class ExcepcionUsuarioNoStandarNoPuedeReservar extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2325496707022665812L;
	public ExcepcionUsuarioNoStandarNoPuedeReservar(){
		super("Usuario no puede reservar al no estar registrado");
		
	}
}
