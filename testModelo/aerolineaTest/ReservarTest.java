package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class ReservarTest {
	
	@Test
	public void reservar_PudoReservar() {
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
		boolean noEstabaReservado = asiento1.isReservado() == false;
		//prueba:
		Mockito.when(oceanic.reservar(dni, codigoVuelo, numeroDeAsiento)).thenReturn(noEstabaReservado);
		Assert.assertEquals(noEstabaReservado, lanchita.reservar(dni, codigoVuelo, numeroDeAsiento));
		Mockito.verify(oceanic).reservar(dni, codigoVuelo, numeroDeAsiento);
	}
	
	@Test
	public void reservar_NoPudoReservar() {
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
		asiento1.setReservado(true);
		boolean noEstabaReservado = asiento1.isReservado() == false;
		//prueba:
		Mockito.when(oceanic.reservar(dni, codigoVuelo, numeroDeAsiento)).thenReturn(noEstabaReservado);
		Assert.assertEquals(noEstabaReservado, lanchita.reservar(dni, codigoVuelo, numeroDeAsiento));
		Mockito.verify(oceanic).reservar(dni, codigoVuelo, numeroDeAsiento);
	}
}
