package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class BuscarAsientoTest {
	@Test
	public void buscarAsiento_Trae2AsientosSinFiltrosOpcionales() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontraron asientos en vuelos a BUE", 2, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA").size());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosReservados() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontraron asientos en vuelos a BUE", 3, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", null,0,0,true, null).size());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorPrecioDescendente() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		
		AsientoBusquedaOrden ordenPrecio = AsientoBusquedaOrden.PRECIOD;
		
		Assert.assertEquals("No se encontraron el asiento1", asiento1, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenPrecio).get(0));
	}
	

	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorTiempoVuelo() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		
		AsientoBusquedaOrden ordenTiempoVuelo = AsientoBusquedaOrden.TIEMPOVUELO;
		
		Assert.assertEquals("No se encontraron el vuelo1, el de menor duracion", vuelo1, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenTiempoVuelo).get(1).getVuelo());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosEjecutivos() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Clase claseEjecutiva = Clase.EJECUTIVA;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("No se encontro el asiento ejecutivo", 1, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	

	@Test
	public void buscarAsiento_NoTraeAsientosEjecutivos() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Clase claseEjecutiva = Clase.EJECUTIVA;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("Se encontro el asiento ejecutivo", 0, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	
}
