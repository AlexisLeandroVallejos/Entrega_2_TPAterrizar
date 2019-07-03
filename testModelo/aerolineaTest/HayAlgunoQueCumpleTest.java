package aerolineaTest;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class HayAlgunoQueCumpleTest {
	
	@Test
	public void hayAlgunoQueCumple_SeEncuentraAlMenosUnVueloQueCumplaBUE() {
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList("BUE", null, null, null, null, null));
		
		Assert.assertEquals("No se encontraron vuelos", true, 
				aterrizarTramitesDeAsientos.getVuelos().stream().anyMatch(vuelo -> vuelo.cumpleAlgunCriterio(criterios)));
	}
}
