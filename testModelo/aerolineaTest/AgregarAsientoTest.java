package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class AgregarAsientoTest {
	
	@Test
	public void agregarAsiento_seAgregaUnAsientoYCambiaElNumeroDeAsientos() {
		Vuelo vuelo = new Vuelo("EC0344", "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Asiento asiento1 = new Asiento(vuelo, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento1);
		Asiento asiento3 = new Asiento(vuelo, Clase.EJECUTIVA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento3);
		Asiento asiento2 = new Asiento(vuelo, Clase.EJECUTIVA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento2);
		//^este orden es intencional, sino no funciona.
		Assert.assertEquals("El numero de asiento no cambio.", vuelo.cantidadDeAsientos(), 3);
	}
}
