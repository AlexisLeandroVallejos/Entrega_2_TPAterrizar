package vistaTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.Aerolinea;
import modelo.UsuarioEstandar;
import vista.AterrizarPrincipal;

public class AterrizarPrincipalTest {

	@Test
	public void AterrizarPrincipal_seMuestraLaVentana()
	{
		UsuarioEstandar user = new UsuarioEstandar("Matias","TEst", 2321331,new Aerolinea());
		AterrizarPrincipal vistaPrinc = new AterrizarPrincipal();
		vistaPrinc.setUser(user);
		vistaPrinc.setVisible(true);
		String s = "";
		s = "1";
	}
}
