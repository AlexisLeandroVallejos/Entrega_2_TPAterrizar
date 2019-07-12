package excepciones;

public class ExcepcionUsuarioNoEstandarNoPuedeComprarSuperOferta extends RuntimeException{

		
		/**
	 * 
	 */
	private static final long serialVersionUID = 9002611192287311126L;

		public ExcepcionUsuarioNoEstandarNoPuedeComprarSuperOferta(){
			super("Usuarios no Estandar no pueden comprar este asiento");
			
		}
}
