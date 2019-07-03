package usuarioTest;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionAsientoNoDisponible;
import excepciones.ExcepcionUsuarioNoStandarNoPuedeReservar;
import modelo.*;

public class ComprarTest {
	
	@Test
	public void comprar_UsuarioCompraUnAsiento(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
	}
	
	@Test
	public void comprar_UsuarioCompraUnAsientoYNoQuedaDisponible(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
		Assert.assertEquals("El asiento no esta reservado", asiento1.getEstadoAsiento(), Estado.COMPRADO);
	}
	
	@Test
	public void comprar_DosUsuariosCompranDifrentesAsientosDisponiblesDelMismoVuelo(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
		otroUsuario.comprar(asiento3);	
		//agregar assert de estado de asiento
	}	
	
	@Test(expected = ExcepcionAsientoNoDisponible.class)
	public void comprar_UsuarioCompraUnAsientoYOtroUsuarioIntentaComprarloPeroNoLoEncuentraDisponible(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
		otroUsuario.comprar(asiento1);
	}
	
	@Test
	public void comprar_unUsuarioEstandarCompraUnAsientoDisponible(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
	}
	
	@Test
	public void comprar_unUsuarioNoEstandarCompraUnAsientoDisponible(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
	}
	
	@Test
	public void comprar_unUsuarioNoEstandarCompraUnAsientoDisponibleConRecargo(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioNoEstandar usuarioNoEstandar = new UsuarioNoEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Mariano","Martinez", 24888654, aterrizarTramitesDeAsientos);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento3 = new Asiento(vuelo1, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		//seteo precios:
		asiento1.setPrecio(usuarioNoEstandar);
		asiento3.setPrecio(usuarioEstandar);
		
		Assert.assertEquals("No tiene el recargo", true, asiento1.getPrecio() > asiento3.getPrecio());
	}
	
	@Test(expected=ExcepcionAsientoNoDisponible.class)
	public void comprar_unUsuarioEstandarIntentaComprarUnAsientoConsideradoSuperOfertaYFalla(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
	}
	
	@Test(expected=ExcepcionAsientoNoDisponible.class)
	public void comprar_unUsuarioNoEstandarIntentaComprarUnAsientoConsideradoSuperOfertaYFalla(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
	}
	
	@Test
	public void comprar_unUsuarioVIPCompraUnAsientoConsideradoSuperOferta(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(asiento1);
	}
	
	@Test(expected=NullPointerException.class)
	public void comprar_unUsuarioIntentaComprarUnAsientoInexistente(){
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Agregar vuelos a aerolinea:
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.comprar(null);
	}
	
	@Test
	public void comprar_unUsuarioEstandarCompraSuReserva() throws ExcepcionUsuarioNoStandarNoPuedeReservar{
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aterrizarTramitesDeAsientos);
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
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
		usuario.reservar(asiento3);
		usuario.comprar(asiento3);
	}
}
