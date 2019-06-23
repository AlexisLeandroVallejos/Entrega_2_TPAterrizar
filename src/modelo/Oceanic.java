package modelo;

import java.util.List;

public interface Oceanic {
	
	//busquedas:
	public List<Asiento> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida);
	
	public List<Asiento> asientosDisponiblesParaOrigenYDestino
		(String codigoOrigenOceanic, String fechaSalida, String codigoDestinoOceanic);
	
	public boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento);
	
	//compras:
	public boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento);
	
	//reservas:
	public boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento);
}

