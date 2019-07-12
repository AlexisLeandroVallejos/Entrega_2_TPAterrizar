package excepciones;

public class ExcepcionUsuarioEstandarNoPuedeComprarSuperOferta extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8843079487499258954L;
	
	public ExcepcionUsuarioEstandarNoPuedeComprarSuperOferta(){
		super("UsuarioEstandar no puede comprar asiento en super oferta");
		
	}
}
