package bd;

import modelo.Aerolinea;
import modelo.Asiento;
import modelo.Clase;
import modelo.CombinacionAsientoUsuario;
import modelo.Estado;
import modelo.Ubicacion;
import modelo.Usuario;
import modelo.UsuarioEstandar;
import modelo.Vuelo;

public class UsuarioDataDummy {

	public Usuario getUsuarioTest() {
		// TODO Auto-generated method stub
		Aerolinea aero = new Aerolinea();
		UsuarioEstandar user = new UsuarioEstandar("Tomas", "Perez", 2345677, aero);
		aero = llenarListaDeReservas(aero, user);
		aero = llenarListaDeReservas(aero, user);
		return user;
	}
	
	public Aerolinea  llenarListaDeReservas(Aerolinea aerolinea, Usuario usuario){
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		
		aerolinea.agregarVuelo(vuelo1);
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.TURISTA, Ubicacion.CENTRO, Estado.RESERVADO),usuario));
		usuario.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.VENTANA, Estado.RESERVADO),usuario));
		usuario.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		String codDeVuelo2 = "LAN370";
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "LA", "URU", "20110126", "20110127", "22:10", "08:20");
		aerolinea.agregarVuelo(vuelo2);
		usuario.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		usuario.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo2, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		
		return aerolinea;
	}
	
	public Aerolinea llenarListaDeCompras(Aerolinea aerolinea, Usuario usuario){
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		aerolinea.agregarVuelo(vuelo1);
		usuario.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.CENTRO, Estado.COMPRADO),usuario));
		usuario.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.CENTRO, Estado.COMPRADO),usuario));
		String codDeVuelo2 = "LAN370";
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "LA", "URU", "20110126", "20110127", "22:10", "08:20");
		aerolinea.agregarVuelo(vuelo2);
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo2, Clase.TURISTA, Ubicacion.CENTRO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo2, Clase.TURISTA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));

		return aerolinea;
	}
}
