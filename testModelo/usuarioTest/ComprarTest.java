package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionAsientoNoDisponible;
import excepciones.ExcepcionUsuarioNoStandarNoPuedeReservar;
import modelo.*;

public class ComprarTest {
	
	@Test
	public void comprar_UsuarioCompraUnAsiento(){
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
		usuario.comprar("EC0344-1");
	}
	
	@Test
	public void comprar_UsuarioCompraUnAsientoYNoQuedaDisponible(){
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
		usuario.comprar("EC0344-1");
		Assert.assertEquals("El asiento no esta reservado", asiento1.getEstadoAsiento(), Estado.COMPRADO);
	}
	
	@Test
	public void comprar_DosUsuariosCompranDifrentesAsientosDisponiblesDelMismoVuelo(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484, aero);
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
		usuario.comprar("EC0344-1");
		otroUsuario.comprar("EC0344-3");	
		//agregar assert de estado de asiento
	}	
	
	@Test(expected = ExcepcionAsientoNoDisponible.class)
	public void comprar_UsuarioCompraUnAsientoYOtroUsuarioIntentaComprarloPeroNoLoEncuentraDisponible(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484, aero);
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
		usuario.comprar("EC0344-1");
		otroUsuario.comprar("EC0344-1");
	}
	
	@Test
	public void comprar_unUsuarioEstandarCompraUnAsientoDisponible(){
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
		usuario.comprar("EC0344-1");
	}
	
	@Test
	public void comprar_unUsuarioNoEstandarCompraUnAsientoDisponible(){
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
		usuario.comprar("EC0344-1");
	}
	
	@Test
	public void comprar_unUsuarioNoEstandarCompraUnAsientoDisponibleConRecargo(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuarioNoEstandar = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Mariano","Martinez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		//seteo precios:
		asiento1.setPrecio(usuarioNoEstandar);
		asiento3.setPrecio(usuarioEstandar);
		
		Assert.assertEquals("No tiene el recargo", true, asiento1.getPrecio() > asiento3.getPrecio());
	}
	
	@Test(expected=ExcepcionAsientoNoDisponible.class)
	public void comprar_unUsuarioEstandarIntentaComprarUnAsientoConsideradoSuperOfertaYFalla(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Seteo precios de asientos:
		asiento1.setPrecio(usuario);
		asiento2.setPrecio(usuario);
		asiento3.setPrecio(usuario);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.comprar("EC0344-1");
	}
	
	@Test(expected=ExcepcionAsientoNoDisponible.class)
	public void comprar_unUsuarioNoEstandarIntentaComprarUnAsientoConsideradoSuperOfertaYFalla(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//seteo precio de asientos:
		asiento1.setPrecio(usuario);
		asiento2.setPrecio(usuario);
		asiento3.setPrecio(usuario);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.comprar("EC0344-1");
	}
	
	@Test
	public void comprar_unUsuarioVIPCompraUnAsientoConsideradoSuperOferta(){
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
		usuario.comprar("EC0344-1");
	}
	
	@Test(expected=ExcepcionAsientoNoDisponible.class)
	public void comprar_unUsuarioIntentaComprarUnAsientoInexistente(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.comprar("EC0344-1");
	}
	
	@Test
	public void comprar_unUsuarioEstandarCompraSuReserva() throws ExcepcionUsuarioNoStandarNoPuedeReservar{
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
		usuario.comprar("EC0344-1");
	}
}
