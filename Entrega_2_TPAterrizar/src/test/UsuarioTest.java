package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Aterrizar;
import modelo.Usuario;

public class UsuarioTest {
	
	@Test
	public void realizarBusqueda_usuarioHaceUnaBusqueda() {
		Usuario usuario = new Usuario("Gonzalo","Campos",19999234);
		Aterrizar aterrizar = new Aterrizar();
		Assert.assertEquals("El usuario realizo una busqueda.", 
				usuario.realizarBusqueda("origen", "destino", "fechaDeSalida", "fechaDeLlegada"), 
				aterrizar.buscar("origen","destino", "fechaDeSalida", "fechaDeLlegada");
		
	}
}
