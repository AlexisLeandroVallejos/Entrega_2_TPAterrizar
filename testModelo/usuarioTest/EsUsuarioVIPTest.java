package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class EsUsuarioVIPTest {
	
	@Test
	public void esUsuarioVIP_UsuarioEstandarSuperaComprasPorCienMilYEsVIP(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		usuario.sumarADineroTotalGastado(110000);
		Assert.assertEquals("No supera compras por cien mil", true, usuario.esUsuarioVIP());
	}
}
