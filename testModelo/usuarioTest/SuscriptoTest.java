package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class SuscriptoTest {
	
	@Test
	public void suscripto_UsuarioEstandarEstaSuscripto(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("No esta suscripto", true, usuario.suscripto());
	}

	@Test
	public void suscripto_UsuarioVIPEstaSuscripto(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		usuario.sumarADineroTotalGastado(100001);
		Assert.assertEquals("No esta suscripto", true, usuario.suscripto());
	}
	
	@Test
	public void suscripto_UsuarioNoEstandarNoEstaSuscripto(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("Esta suscripto", false, usuario.suscripto());
	}
}
