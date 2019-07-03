package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionUsuarioNoStandarNoPuedeReservar;
import modelo.*;

public class TransferenciaDeReservaTest {
	
	@Test
	public void transferenciaDeReserva_seRealizaUnaTransferenciaDeReserva() throws ExcepcionUsuarioNoStandarNoPuedeReservar{
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.reservar(asiento1);
		aterrizarTramitesDeAsientos.transferenciaDeReserva(asiento1);
		Assert.assertEquals("Los usuarios no son iguales", true, /*asiento1.getUsuario() == usuario &&*/ asiento1.getEstadoAsiento().estaReservado());
	}
}
