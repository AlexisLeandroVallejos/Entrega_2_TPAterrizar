package modelo;

import java.util.ArrayList;

public interface Oceanic {
	
	//busquedas:
	public ArrayList<ArrayList<AsientoDTO>> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida);
	
	public ArrayList<ArrayList<AsientoDTO>> asientosDisponiblesParaOrigenYDestino
		(String codigoOrigenOceanic, String fechaSalida, String codigoDestinoOceanic);
	
	public boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento);
	
	//compras:
	public boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento);
	
	//reservas:
	public boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento);
}
