package test;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionAsientoNoDisponible;
import modelo.*;

public class UsuarioTest {
	
	@Test
	public void realizarBusqueda_usuarioEstandarRealizaUnaBusqueda() {
		String codDeVuelo1 = "EC0344";
		Aerolinea aero = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20121010", "2010111", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		aero.agregarVuelo(vuelo1);
		String lugarOrigen = "BUE";
		String lugarDestino = "LA";
		String fechaSalida = "20121010";
		String fechaLlegada = null;
		String horaSalida = null;
		String horaLlegada = null;
		Assert.assertEquals("El usuario no realizo la busqueda.", 
				usuario.realizarBusqueda(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada),
				aero.asientosDisponibles(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada));
		
	}
	

	@Test
	public void realizarBusqueda_usuarioEstandarNoRealizaBusquedaEHistoricoEstaVacio() {
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("El usuario no guardo la busqueda.", 0,usuario.getHistoricoBusquedas().size());
		
	}
	
	@Test
	public void realizarBusqueda_usuarioEstandarRealizaUnaBusquedaYQuedaEnElHistorico() {
		String codDeVuelo1 = "EC0344";
		Aerolinea aero = new Aerolinea();
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20121010", "2010111", "20:10", "14:20");
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		aero.agregarVuelo(vuelo1);
		String lugarOrigen = "BUE";
		String lugarDestino = "LA";
		String fechaSalida = "20121010";
		String fechaLlegada = null;
		String horaSalida = null;
		String horaLlegada = null;
		usuario.realizarBusqueda(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada);
		Assert.assertEquals("El usuario no guardo la busqueda.", 1,usuario.getHistoricoBusquedas().size());
		
	}
	
	@Test
	public void comprar_UsuarioCompraUnAsiento(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.comprar("EC0344-1");
	}
	

	@Test
	public void suscripto_UsuarioEstandarEstaSuscripto(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("No esta suscripto", true, usuario.suscripto());
	}

	@Test
	public void suscripto_UsuarioVIPEstaSuscripto(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("No esta suscripto", true, usuario.suscripto());
	}
	
	@Test
	public void suscripto_UsuarioNoEstandarNoEstaSuscripto(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("Esta suscripto", false, usuario.suscripto());
	}

	@Test
	public void superaComprasPorCienMil_UsuarioNoEstandarNosuperaComprasPorCienMil(){
		Aerolinea aero = new Aerolinea();
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("Supera compras Compras Por Cien Mil", false, usuario.superaComprasPorCienMil());
	}


	@Test
	public void superaComprasPorCienMil_UsuarioVIPsuperaComprasPorCienMil(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		usuario.sumarADineroTotalGastado(110000);
		Assert.assertEquals("No Supera compras Compras Por Cien Mil", true, usuario.esUsuarioVIP());
	}
	
	@Test
	public void superaComprasPorCienMil_UsuarioEstandarsuperaComprasPorCienMil(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		Assert.assertEquals("Supera compras Compras Por Cien Mil", false, usuario.superaComprasPorCienMil());
	}

	@Test
	public void comprar_UsuarioCompraUnAsientoYNoQuedaDisponible(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		usuario.comprar("EC0344-1");
		Assert.assertEquals("El asiento no esta reservado", asiento1.getEstadoAsiento(), "R");
	}
	
	@Test
	public void comprar_DosUsuariosCompranDifrentesAsientosDisponiblesDelMismoVuelo(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
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
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
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
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
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
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
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
		Asiento asiento1 = new Asiento(vuelo1, usuarioEstandar, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento3 = new Asiento(vuelo1, usuarioNoEstandar, "T", "P", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		Assert.assertEquals("No tiene el recargo", false ,asiento1.getPrecioFinal().equalsIgnoreCase(asiento3.getPrecioFinal()) );
	}
	
	@Test(expected=ExcepcionAsientoNoDisponible.class)
	public void comprar_unUsuarioEstandarIntentaComprarUnAsientoConsideradoSuperOfertaYFalla(){
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aero);
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
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
		Asiento asiento1 = new Asiento(vuelo1, usuario, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
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
		Asiento asiento1 = new Asiento(vuelo1, usuario, "T", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, "T", "V", "D");
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
}
