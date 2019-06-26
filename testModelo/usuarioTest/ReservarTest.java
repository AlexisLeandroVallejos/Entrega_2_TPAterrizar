package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionUsuarioNoStandarNoPuedeReservar;
import modelo.*;

public class ReservarTest {
	
	@Test(expected=ExcepcionUsuarioNoStandarNoPuedeReservar.class)
	public void reservar_unUsuarioNoEstandarReservaUnAsiento(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.reservar("EC0344-1");
		Assert.assertTrue(asiento1.getEstadoAsiento().estaReservado());
	}
	
	@Test
	public void reservar_unUsuarioEstandarReservaUnAsiento(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.reservar("EC0344-1");
		Assert.assertTrue(asiento1.getEstadoAsiento().estaReservado());
	}
	
	@Test
	public void reservar_unUsuarioVIPReservaUnAsiento(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		usuario.sumarADineroTotalGastado(100000);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.reservar("EC0344-1");
		Assert.assertTrue(asiento1.getEstadoAsiento().estaReservado());
	}
	
	@Test
	public void reservar_unUsuarioVIPReservaUnAsientoConsideradoSuperOferta(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		usuario.sumarADineroTotalGastado(100000);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.reservar("EC0344-1");
		Assert.assertTrue(asiento1.getEstadoAsiento().estaReservado());
	}
	
	@Test
	public void reservar_unUsuarioEstandarSobreReservaUnAsientoYaReservado(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
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
		aero.agregarVuelo(vuelo1);
		usuario.reservar("EC0344-1");
		Assert.assertTrue(aero.getAsientosSobreReservados().size() == 1);
	}
}
