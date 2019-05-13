package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import excepciones.ExcepcionAsientoReservado;
import modelo.*;

public class UsuarioTest {
	
	@Test
	public void usuario_seCreaUnUsuarioNoEstandar() {
		UsuarioNoEstandar usuario = new UsuarioNoEstandar("Tomas","Perez", 24146654);
	}
	
	@Test
	public void usuario_seCreaUnUsuarioVIP() {
		UsuarioVIP usuario = new UsuarioVIP("Jose","Perez", 27946654);
	}
	
	@Test
	public void realizarBusqueda_usuarioEstandarRealizaUnaBusqueda() {
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Aterrizar aterrizar = new Aterrizar();
		String lugarOrigen = "BUE";
		String lugarDestino = "LA";
		String fechaSalida = "20121010";
		String fechaLlegada = null;
		String horaSalida = null;
		String horaLlegada = null;
		Assert.assertEquals("El usuario no realizo la busqueda.", 
				usuario.realizarBusqueda(lugarOrigen, lugarDestino, fechaSalida, fechaLlegada),
				aterrizar.asientosDisponibles(lugarOrigen, fechaSalida, horaSalida, lugarDestino, fechaLlegada, horaLlegada));
		
	}
	
	@Test
	public void comprar_UsuarioCompraUnAsiento(){
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Aerolinea aero = new Aerolinea();
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		
		usuario.comprar("EC0344-1", aero);
		
	}
	

	@Test
	public void comprar_UsuarioCompraUnAsientoYNoQuedaDisponible(){
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		Aerolinea aero = new Aerolinea();
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		
		usuario.comprar("EC0344-1", aero);
		Assert.assertEquals("El asiento no esta reservado", asiento1.getEstadoAsiento(), "R");
		
	}
	
	@Test
	public void comprar_DosUsuariosCompranDifrentesAsientosDisponiblesDelMismoVuelo(){
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484);
		Aerolinea aero = new Aerolinea();
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		
		usuario.comprar("EC0344-1", aero);
		otroUsuario.comprar("EC0344-3", aero);	
	}	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void comprar_UsuarioCompraUnAsientoYOtroUsuarioIntentaComprarloPeroNoLoEncuentraDisponible(){
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654);
		UsuarioEstandar otroUsuario = new UsuarioEstandar("Mariano","Martinez", 31256484);
		Aerolinea aero = new Aerolinea();
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, "P", "P", "D");
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, "E", "P", "R");
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, "T", "V", "D");
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		aero.agregarVuelo(vuelo1);
		
		usuario.comprar("EC0344-1", aero);
		otroUsuario.comprar("EC0344-1", aero);
	}
	
	
}
