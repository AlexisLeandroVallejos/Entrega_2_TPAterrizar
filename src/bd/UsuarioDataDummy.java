package bd;

import modelo.AterrizarTramitesDeAsientos;
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
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		Usuario user = new UsuarioEstandar("Tomas", "Perez", 2345677, aterrizarTramitesDeAsientos);
		user = llenarListaDeReservas(user);
		user = llenarListaDeCompras(user);
		return user;
	}
	
	public Usuario llenarListaDeReservas(Usuario usuario){
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		usuario.getAsientosReservados().add(new Asiento(vuelo1, Clase.TURISTA, Ubicacion.CENTRO, Estado.RESERVADO));
		usuario.getAsientosReservados().add(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.VENTANA, Estado.RESERVADO));
		usuario.getAsientosReservados().add(new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.PASILLO, Estado.RESERVADO));
		String codDeVuelo2 = "LAN370";
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "LA", "URU", "20110126", "20110127", "22:10", "08:20");

		usuario.getAsientosReservados().add(new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO));
		usuario.getAsientosReservados().add(new Asiento(vuelo2, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO));
		
		return usuario;
	}
	
	public Usuario llenarListaDeCompras( Usuario usuario){
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		usuario.getAsientosComprados().add(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.CENTRO, Estado.COMPRADO));
		usuario.getAsientosComprados().add(new Asiento(vuelo1, Clase.EJECUTIVO, Ubicacion.CENTRO, Estado.COMPRADO));
		String codDeVuelo2 = "LAN370";
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "LA", "URU", "20110126", "20110127", "22:10", "08:20");
		usuario.getAsientosComprados().add(new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO));
		usuario.getAsientosComprados().add(new Asiento(vuelo2, Clase.TURISTA, Ubicacion.CENTRO, Estado.COMPRADO));
		usuario.getAsientosComprados().add(new Asiento(vuelo2, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO));
		usuario.getAsientosComprados().add(new Asiento(vuelo2, Clase.TURISTA, Ubicacion.PASILLO, Estado.COMPRADO));

		return usuario;
	}
}
