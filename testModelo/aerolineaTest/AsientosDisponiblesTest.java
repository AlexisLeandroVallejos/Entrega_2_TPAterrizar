package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class AsientosDisponiblesTest {
	
	@Test
	public void asientosDisponibles_seObtieneUnaListaDeAsientosDisponibles() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		lanchita.asientosDisponibles(null, null, null, "BUE", null, null); //el destino es "BUE"
	}
	//Agregar test para buscar vuelos: Destino, fecha, clase de asiento, ubicacion
	@Test
	public void asientosDisponibles_seObtienenTresVuelosQueCumplenConLaBusquedaDestino() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		String codDeVuelo4 = "MIN12";
		Aerolinea lanchita = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		Vuelo vuelo4 = new Vuelo(codDeVuelo4, "TX", "BUE", "20111024", "20111025", "15:00", "20:00");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Asientos vuelo3
		Asiento asiento10 = new Asiento(vuelo3, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo4.agregarAsiento(asiento10);
		Asiento asiento11 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo4.agregarAsiento(asiento11);
		Asiento asiento12 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo4.agregarAsiento(asiento12);
		//Agregar vuelos a aerolinea:
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
		Aerolinea lanchita = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("Se encontraron asientos en vuelos a NYC", 0, 
				lanchita.asientosDisponibles("NYC", null, null, null, null, null).size());
	}
}
