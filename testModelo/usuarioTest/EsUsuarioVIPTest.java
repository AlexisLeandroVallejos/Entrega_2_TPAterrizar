package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class EsUsuarioVIPTest {
	
	@Test
	public void esUsuarioVIP_UsuarioEstandarSuperaComprasPorCienMilYEsVIP(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		usuario.sumarADineroTotalGastado(110000);
		Assert.assertEquals("No supera compras por cien mil", true, usuario.esUsuarioVIP());
	}
}
