package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class EstaReservadoTest {
	
	@Test
	public void estaReservado_asientoNoEstaReservado() {
		//inicio:
		String codigoDeVuelo = "LAR";
		Integer numeroDeAsiento = 12;
		String fechaSalida = "09/05/2010";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoDeVuelo, numeroDeAsiento, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		//prueba:
		Mockito.when(oceanic.estaReservado(codigoDeVuelo, numeroDeAsiento)).thenReturn(asiento1.isReservado());
		Assert.assertEquals(asiento1.isReservado(), lanchita.estaReservado(codigoDeVuelo, numeroDeAsiento));
		Mockito.verify(oceanic).estaReservado(codigoDeVuelo, numeroDeAsiento);
	}
	
	@Test
	public void estaReservado_asientoEstaReservado() {
		//inicio:
		String codigoDeVuelo = "LAR";
		Integer numeroDeAsiento = 12;
		String fechaSalida = "09/05/2010";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoDeVuelo, numeroDeAsiento, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		asiento1.setReservado(true);
		//prueba:
		Mockito.when(oceanic.estaReservado(codigoDeVuelo, numeroDeAsiento)).thenReturn(asiento1.isReservado());
		Assert.assertEquals(asiento1.isReservado(), lanchita.estaReservado(codigoDeVuelo, numeroDeAsiento));
		Mockito.verify(oceanic).estaReservado(codigoDeVuelo, numeroDeAsiento);
	}
}
