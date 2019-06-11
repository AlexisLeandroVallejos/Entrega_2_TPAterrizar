package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class ComprarSiHayDisponibilidadTest {
	
	@Test
	public void comprarSiHayDisponibilidad_PudoComprar() {
		//inicio:
		String dni = "29999123";
		String codigoVuelo = "LAR";
		Integer numeroDeAsiento = 12;
		String fechaSalida = "09/05/2010";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoVuelo, numeroDeAsiento, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		boolean noEstabaComprado = asiento1.isComprado() == false;
		//prueba:
		Mockito.when(oceanic.comprarSiHayDisponibilidad(dni, codigoVuelo, numeroDeAsiento)).thenReturn(noEstabaComprado);
		Assert.assertEquals(noEstabaComprado, lanchita.comprarSiHayDisponibilidad(dni, codigoVuelo, numeroDeAsiento));
		Mockito.verify(oceanic).comprarSiHayDisponibilidad(dni, codigoVuelo, numeroDeAsiento);
	}
	
	@Test
	public void comprarSiHayDisponibilidad_NoPudoComprar() {
		//inicio:
		String dni = "29999123";
		String codigoVuelo = "LAR";
		Integer numeroDeAsiento = 12;
		String fechaSalida = "09/05/2010";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoVuelo, numeroDeAsiento, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		asiento1.setComprado(true);
		boolean noEstabaComprado = asiento1.isComprado() == false;
		//prueba:
		Mockito.when(oceanic.comprarSiHayDisponibilidad(dni, codigoVuelo, numeroDeAsiento)).thenReturn(noEstabaComprado);
		Assert.assertEquals(noEstabaComprado, lanchita.comprarSiHayDisponibilidad(dni, codigoVuelo, numeroDeAsiento));
		Mockito.verify(oceanic).comprarSiHayDisponibilidad(dni, codigoVuelo, numeroDeAsiento);
	}
}
