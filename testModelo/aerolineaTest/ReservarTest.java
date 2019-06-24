package aerolineaTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class ReservarTest {

	@Test
	public void reservar_PudoReservar() {
		// inicio:
		String dni = "28977321";
		String codigoDeVuelo = "ECO23";
		Integer numeroDeAsiento = 35;

		String codigoOrigenOceanic1 = "ZX"; // esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "RX";

		String fechaSalida1 = "12/04/2017";

		Aerolinea aerolinea = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aerolinea.setOceanic(oceanic);
		OceanicCriterioDeReserva criterioReserva = new OceanicCriterioDeReserva(dni, codigoDeVuelo, numeroDeAsiento);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20"); // cumplen

		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", numeroDeAsiento, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);
		vuelo1.agregarAsiento(asiento3);

		aerolinea.agregarVuelo(vuelo1); // los asientos guardados cumplen por el vuelo.

		boolean puedeReservar = aerolinea.getOceanicBusquedaCompraYReserva().reservar(criterioReserva);
		// prueba:
		Mockito.when(oceanic.reservar(dni, codigoDeVuelo, numeroDeAsiento)).thenReturn(puedeReservar);
		Assert.assertEquals(aerolinea.getOceanic().reservar(dni, codigoDeVuelo, numeroDeAsiento), puedeReservar);
		Mockito.verify(oceanic).reservar(dni, codigoDeVuelo, numeroDeAsiento);
	}

	@Test
	public void reservar_NoPudoReservar() {
		// inicio:
		String dni = "28977321";
		String codigoDeVuelo = "ECO23";
		Integer numeroDeAsiento = 35;

		String codigoOrigenOceanic1 = "ZX"; // esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "RX";

		String fechaSalida1 = "12/04/2017";

		Aerolinea aerolinea = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aerolinea.setOceanic(oceanic);
		OceanicCriterioDeReserva criterioReserva = new OceanicCriterioDeReserva(dni, codigoDeVuelo, numeroDeAsiento);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20"); // cumplen

		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA,Ubicacion.VENTANA);
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", numeroDeAsiento, fechaSalida1, "20:15", 650.5, Clase.PRIMERA,Ubicacion.PASILLO);
		asiento3.setEstadoAsiento(Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento3);

		aerolinea.agregarVuelo(vuelo1); // los asientos guardados cumplen por el vuelo.

		boolean puedeReservar = aerolinea.getOceanicBusquedaCompraYReserva().reservar(criterioReserva);
		// prueba:
		Mockito.when(oceanic.reservar(dni, codigoDeVuelo, numeroDeAsiento)).thenReturn(puedeReservar);
		Assert.assertEquals(aerolinea.getOceanic().reservar(dni, codigoDeVuelo, numeroDeAsiento), puedeReservar);
		Mockito.verify(oceanic).reservar(dni, codigoDeVuelo, numeroDeAsiento);
	}
}
