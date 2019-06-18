package vistaTest;

import org.junit.Test;

import modelo.Aerolinea;
import modelo.UsuarioEstandar;
import vista.AaterrizarPrincipal;

public class AterrizarPrincipalTest {

	@Test
	public void AterrizarPrincipal_muestraNombreDeUsuario()
	{
		UsuarioEstandar user = new UsuarioEstandar("Matias","TEst", 2321331,new Aerolinea());
		AaterrizarPrincipal vistaPrinc = new AaterrizarPrincipal();
		
		vistaPrinc.show();
	}
}
