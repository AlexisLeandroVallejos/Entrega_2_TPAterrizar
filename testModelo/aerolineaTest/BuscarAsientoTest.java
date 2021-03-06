package aerolineaTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class BuscarAsientoTest {
	@Test
	public void buscarAsiento_Trae2AsientosSinFiltrosOpcionales() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		aterrizarTramitesDeAsientos.setOceanic(oceanic);
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVO, Ubicacion.CENTRO, Estado.RESERVADO);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontraron asientos en vuelos a BUE", 2, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA").size());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosReservados() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVO, Ubicacion.CENTRO, Estado.RESERVADO);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontraron asientos en vuelos a BUE", 3, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", null,0,0,true, null).size());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorPrecioAscendente() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVO, Ubicacion.CENTRO, Estado.RESERVADO);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		//seteo precios de asientos:
		asiento1.setPrecio(usuario);
		asiento2.setPrecio(usuario);
		asiento3.setPrecio(usuario);
		asiento4.setPrecio(usuario);
		asiento5.setPrecio(usuario);
		asiento6.setPrecio(usuario);
		asiento7.setPrecio(usuario);
		asiento8.setPrecio(usuario);
		asiento9.setPrecio(usuario);
		
		AsientoBusquedaOrden ordenPrecio = new AsientoBusquedaOrdenPrecioAscendente();
		
		Assert.assertEquals("No se encontraron el asiento1", asiento1, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenPrecio).get(0));
	}
	
	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorPrecioDescendente() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, Clase.EJECUTIVO, Ubicacion.CENTRO, Estado.RESERVADO);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		//seteo precios de asientos:
		asiento1.setPrecio(usuario);
		asiento2.setPrecio(usuario);
		asiento3.setPrecio(usuario);
		asiento4.setPrecio(usuario);
		asiento5.setPrecio(usuario);
		asiento6.setPrecio(usuario);
		asiento7.setPrecio(usuario);
		asiento8.setPrecio(usuario);
		asiento9.setPrecio(usuario);
		
		AsientoBusquedaOrden ordenPrecio = new AsientoBusquedaOrdenPrecioDescendente();
		
		Assert.assertEquals("No se encontraron el asiento1", asiento3, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenPrecio).get(0));
	}
	

	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorTiempoVuelo() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		//Seteo precios de asientos:
		asiento2.setPrecio(usuario);
		asiento4.setPrecio(usuario);
		asiento7.setPrecio(usuario);
		asiento8.setPrecio(usuario);
		asiento9.setPrecio(usuario);
		
		AsientoBusquedaOrden ordenTiempoVuelo = new AsientoBusquedaOrdenDuracion();
		
		Assert.assertEquals("No se encontraron el vuelo1, el de menor duracion", vuelo1, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenTiempoVuelo).get(0).getVuelo());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosEjecutivos() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		Clase claseEjecutiva = Clase.EJECUTIVO;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("No se encontro el asiento ejecutivo", 1, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	

	@Test
	public void buscarAsiento_NoTraeAsientosEjecutivos() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo3);
		Clase claseEjecutiva = Clase.EJECUTIVO;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("Se encontro el asiento ejecutivo", 0, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	
	@Test
	public void buscarAsiento_Trae2AsientosEjecutivosDeDiferentesAerolineas() {
		//ahora hay vuelos de diferentes aerolineas como decia el enunciado!
		//con esto se resuelve el issue #13
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		VueloOceanic vuelo1 = new VueloOceanic(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		//AsientosDTO vuelo1
		AsientoDTO asiento2 = new AsientoDTO(codDeVuelo1, 24, "16/01/2011", "20:10", 245.2, Clase.EJECUTIVO, Ubicacion.VENTANA);
		vuelo1.agregarAsiento(asiento2);
		//Asiento vuelo2
		Asiento asiento4 = new Asiento(vuelo2, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo2);
		Clase claseEjecutiva = Clase.EJECUTIVO;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("No se encontro el asiento ejecutivo", 2, 
				aterrizarTramitesDeAsientos.buscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	
}
