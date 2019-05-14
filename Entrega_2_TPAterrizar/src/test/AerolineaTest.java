package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class AerolineaTest {
	
	@Test
	public void agregarAsiento_seAgregaUnAsientoYCambiaElNumeroDeAsientos() {
		Vuelo vuelo = new Vuelo("EC0344", "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Asiento asiento1 = new Asiento(vuelo, usuario, "P", "P", "D");
		vuelo.agregarAsiento(asiento1);
		Asiento asiento3 = new Asiento(vuelo, usuario, "E", "V", "D");
		vuelo.agregarAsiento(asiento3);
		Asiento asiento2 = new Asiento(vuelo, usuario, "E", "V", "D");
		vuelo.agregarAsiento(asiento2);
		//^este orden es intencional, sino no funciona.
		Assert.assertEquals("El numero de asiento no cambio.", vuelo.cantidadDeAsientos(), 3);
	}
	
	@Test
	public void obtenerAsientos_seObtieneUnAsientoDadoElCodigoDeVuelo() {
		String codDeVuelo = "EC0344";
		Vuelo vuelo = new Vuelo(codDeVuelo, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Asiento asiento = new Asiento(vuelo, usuario, "P", "P", "D");
		vuelo.agregarAsiento(asiento);
		Assert.assertEquals("No se encontro asiento.", vuelo.obtenerAsientos().get(0), asiento);
	}
	

	@Test
	public void hayAlgunoQueCumple_SeEncuentraAlMenosUnVueloQueCumplaBUE() {
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		Aerolinea lanchita = new Aerolinea();
		lanchita.agregarVuelo(vuelo1);
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList("BUE", null, null, null, null, null));
		
		Assert.assertEquals("Se encontraron asientos en vuelos a NYC", true, 
				lanchita.hayAlgunoQueCumple(criterios, vuelo1));
	}
	
	@Test
	public void asientosDisponibles_seObtieneUnaListaDeAsientosDisponibles() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, "P", "P", "R");
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, "E", "C", "R");
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, "T", "V", "D");
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		Aerolinea lanchita = new Aerolinea();
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		lanchita.asientosDisponibles(null, null, null, "BUE", null, null); //el destino es "BUE"
	}
	
	@Test
	public void asientosDisponibles_seObtienenTresVuelosQueCumplenConLaBusqueda() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		String codDeVuelo4 = "MIN12";
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		Vuelo vuelo4 = new Vuelo(codDeVuelo4, "TX", "BUE", "20111024", "20111025", "15:00", "20:00");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, "P", "P", "R");
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, "E", "C", "R");
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, "T", "V", "D");
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento9);
		//Asientos vuelo3
		Asiento asiento10 = new Asiento(vuelo3, usuario, "E", "C", "D");
		vuelo4.agregarAsiento(asiento10);
		Asiento asiento11 = new Asiento(vuelo3, usuario, "T", "C", "R");
		vuelo4.agregarAsiento(asiento11);
		Asiento asiento12 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo4.agregarAsiento(asiento12);
		//Agregar vuelos a aerolinea:
		Aerolinea lanchita = new Aerolinea();
		
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontro un Vuelo a BUE", 3, 
				lanchita.asientosDisponibles("BUE", null, null, null, null, null).size());
	}
	
	@Test
	public void asientosDisponibles_NoSeObtieneUnVuelo() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, "P", "P", "R");
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, "E", "C", "R");
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario,"T", "V", "D");
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, "T", "C", "D");
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		Aerolinea lanchita = new Aerolinea();
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("Se encontraron asientos en vuelos a NYC", 0, 
				lanchita.asientosDisponibles("NYC", null, null, null, null, null).size());
	}
	
	
}
