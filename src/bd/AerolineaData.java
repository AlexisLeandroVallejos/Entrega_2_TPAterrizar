package bd;

import modelo.Aerolinea;
import modelo.Asiento;
import modelo.Clase;
import modelo.CombinacionAsientoUsuario;
import modelo.Estado;
import modelo.Ubicacion;
import modelo.Usuario;
import modelo.Vuelo;

public class AerolineaData {
	
	public void llenarListaDeReservas(Aerolinea aerolinea, Usuario usuario){
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO),usuario));
	}
	
	public void llenarListaDeCompras(Aerolinea aerolinea, Usuario usuario){
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		aerolinea.getAsientosReservados().add(new CombinacionAsientoUsuario(new Asiento(vuelo1, Clase.PRIMERA, Ubicacion.PASILLO, Estado.COMPRADO),usuario));
		
	}
	
	public void crearVuelos(){
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
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
	}

}
