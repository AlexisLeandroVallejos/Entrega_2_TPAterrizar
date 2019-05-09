package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Aterrizar;
import modelo.Usuario;

public class AterrizarTest {
	
	@Test
	public void registrarUsuario_usuarioSeRegistraEnAterrizar() {
		Aterrizar aterrizar = new Aterrizar();
		aterrizar.registrarUsuario("Roman", "Perez", 24547202);
		Assert.assertEquals("El usuario no se pudo registrar.", 
				aterrizar.getUsuarios().size(), 1);
	}
	
}
