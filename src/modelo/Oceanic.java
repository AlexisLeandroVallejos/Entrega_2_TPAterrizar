package modelo;

import java.util.List;

public interface Oceanic {
	
	//busquedas:
	public List<AsientoDTO> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida);
	
	public List<AsientoDTO> asientosDisponiblesParaOrigenYDestino
		(String codigoOrigenOceanic, String fechaSalida, String codigoDestinoOceanic);
	
	public boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento);
	
	//compras:
	public boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento);
	
	//reservas:
	public boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento);
}

