package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class AerolineaTest {
	
	@Test
	public void agregarAsiento_seAgregaUnAsientoYCambiaElNumeroDeAsiento() {
		Vuelo vuelo = new Vuelo("EC0344", "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Asiento asiento1 = new Asiento(vuelo, "P", "P", "D");
		vuelo.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo, "E", "V", "D");
		vuelo.agregarAsiento(asiento2);
		//^este orden es intencional, sino no funciona.
		Assert.assertEquals("El numero de asiento no cambio.", vuelo.cantidadDeAsientos(), 2);
	}
	
	@Test
	public void obtenerAsientos_seObtieneUnAsientoDadoElCodigoDeVuelo() {
		String codDeVuelo = "EC0344";
		Vuelo vuelo = new Vuelo(codDeVuelo, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Asiento asiento = new Asiento(vuelo, "P", "P", "D");
		vuelo.agregarAsiento(asiento);
		Assert.assertEquals("No se encontro asiento.", vuelo.obtenerAsientos().get(0), asiento);
	}
	
	@Test
	public void asientosDisponibles_seObtieneUnaListaDeAsientosDisponibles() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, "P", "P", "R");
		vuelo1.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, "E", "C", "R");
		vuelo1.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, "T", "V", "D");
		vuelo1.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, "T", "C", "D");
		vuelo1.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, "T", "C", "D");
		vuelo1.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, "T", "C", "D");
		vuelo1.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		Aerolinea lanchita = new Aerolinea();
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		lanchita.asientosDisponibles(null, null, null, "BUE", null, null); //el destino es "BUE"
	}
	
	
	
}
