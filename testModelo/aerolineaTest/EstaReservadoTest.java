package aerolineaTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class EstaReservadoTest {
	
	@Test
	public void estaReservado_asientoEstaReservado() {
		//inicio:
		String codigoDeVuelo = "ECO23";
		Integer numeroDeAsiento = 35;
						
		String fechaSalida1 = "12/04/2017";
						
		Aerolinea aerolinea = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aerolinea.setOceanic(oceanic);
		OceanicCriterioDeReserva criterioReserva = new OceanicCriterioDeReserva(codigoDeVuelo, numeroDeAsiento);
				
		AsientoDTO asiento1 = new AsientoDTO(codigoDeVuelo, numeroDeAsiento, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA); 
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aerolinea);
		Reserva reserva = new Reserva(asiento1, usuario);
					
		aerolinea.sobreReservar(reserva); //los asientos guardados cumplen por el vuelo.
					
		boolean asientoEstaReservado = OceanicBusquedaCompraYReserva.estaReservado(criterioReserva);
		//prueba:
		Mockito.when(oceanic.estaReservado(codigoDeVuelo, numeroDeAsiento)).thenReturn(asientoEstaReservado);
		Assert.assertEquals(aerolinea.getOceanic().estaReservado(codigoDeVuelo, numeroDeAsiento), asientoEstaReservado);
		Mockito.verify(oceanic).estaReservado(codigoDeVuelo, numeroDeAsiento);
	}
	
	@Test
	public void estaReservado_asientoNoEstaReservado() {
		//inicio:
		String codigoDeVuelo1 = "ECO23";
		Integer numeroDeAsiento1 = 35;
		
		String codigoDeVuelo2 = "RRR99";
		Integer numeroDeAsiento2 = 19;					
		
		String fechaSalida1 = "12/04/2017";
								
		Aerolinea aerolinea = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aerolinea.setOceanic(oceanic);
		OceanicCriterioDeReserva criterioReserva = new OceanicCriterioDeReserva(codigoDeVuelo2, numeroDeAsiento2);
						
		AsientoDTO asiento1 = new AsientoDTO(codigoDeVuelo1, numeroDeAsiento1, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA); 
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, aerolinea);
		Reserva reserva = new Reserva(asiento1, usuario);
							
		aerolinea.sobreReservar(reserva); //los asientos guardados cumplen por el vuelo.
							
		boolean asientoNoEstaReservado = OceanicBusquedaCompraYReserva.estaReservado(criterioReserva);
		//prueba:
		Mockito.when(oceanic.estaReservado(codigoDeVuelo2, numeroDeAsiento2)).thenReturn(asientoNoEstaReservado);
		Assert.assertEquals(aerolinea.getOceanic().estaReservado(codigoDeVuelo2, numeroDeAsiento2), asientoNoEstaReservado);
		Mockito.verify(oceanic).estaReservado(codigoDeVuelo2, numeroDeAsiento2);
	}
}
