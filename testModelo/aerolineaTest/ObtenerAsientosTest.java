package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class ObtenerAsientosTest {
	
	@Test
	public void obtenerAsientos_seObtieneUnAsientoDadoElCodigoDeVuelo() {
		String codDeVuelo = "EC0344";
		Vuelo vuelo = new Vuelo(codDeVuelo, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Asiento asiento = new Asiento(vuelo, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento);
		Assert.assertEquals("No se encontro asiento.", vuelo.obtenerAsientosDisponibles().get(0), asiento);
	}
}
