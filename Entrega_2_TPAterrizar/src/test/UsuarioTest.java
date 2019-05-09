package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class UsuarioTest {
	
	@Test
	public void usuario_seCreaUnUsuarioNoEstandar() {
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Tomas","Perez", 24146654);
	}
	
	@Test
	public void usuario_seCreaUnUsuarioVIP() {
		UsuarioVIP usuario = new UsuarioVIP("Jose","Perez", 27946654);
	}
	
	@Test
	public void realizarBusqueda_usuarioEstandarRealizaUnaBusqueda() {
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Aterrizar aterrizar = new Aterrizar();
		String lugarOrigen = "BUE";
		String lugarDestino = "LA";
		String fechaSalida = "20121010";
		String fechaLlegada = null;
		String horaSalida = null;
		String horaLlegada = null;
		Assert.assertEquals("El usuario no realizo la busqueda.", 
				usuario.realizarBusqueda(lugarOrigen, lugarDestino, fechaSalida, fechaLlegada),
				aterrizar.asientosDisponibles(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada));
		
	}
}
