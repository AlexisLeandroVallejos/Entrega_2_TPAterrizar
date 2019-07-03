package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class SuscriptoTest {
	
	@Test
	public void suscripto_UsuarioEstandarEstaSuscripto(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Assert.assertEquals("No esta suscripto", true, usuario.suscripto());
	}

	@Test
	public void suscripto_UsuarioVIPEstaSuscripto(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		usuario.sumarADineroTotalGastado(100001);
		Assert.assertEquals("No esta suscripto", true, usuario.suscripto());
	}
	
	@Test
	public void suscripto_UsuarioNoEstandarNoEstaSuscripto(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Assert.assertEquals("Esta suscripto", false, usuario.suscripto());
	}
}
