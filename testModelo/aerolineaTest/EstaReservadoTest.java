package aerolineaTest;

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
						
		String codigoOrigenOceanic1 = "ZX"; //esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "RX";
									
		String fechaSalida1 = "12/04/2017";
										
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aterrizarTramitesDeAsientos.setOceanic(oceanic);
		OceanicCriterioDeReserva criterioReserva = new OceanicCriterioDeReserva(codigoDeVuelo, numeroDeAsiento);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20"); //cumplen
						
		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA); 
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", numeroDeAsiento, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);	
		asiento3.setEstadoAsiento(Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento3);
							
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1); //los asientos guardados cumplen por el vuelo.
									
		boolean asientoEstaReservado = aterrizarTramitesDeAsientos.getOceanicBusquedaCompraYReserva().estaReservado(criterioReserva);
		//prueba:
		Mockito.when(oceanic.estaReservado(codigoDeVuelo, numeroDeAsiento)).thenReturn(asientoEstaReservado);
		Assert.assertEquals(aterrizarTramitesDeAsientos.getOceanic().estaReservado(codigoDeVuelo, numeroDeAsiento), asientoEstaReservado);
		Mockito.verify(oceanic).estaReservado(codigoDeVuelo, numeroDeAsiento);
	}
	
	@Test
	public void estaReservado_asientoNoEstaReservado() {
		//inicio:
		String codigoDeVuelo = "ECO23";
		Integer numeroDeAsiento = 35;
				
		String codigoOrigenOceanic1 = "ZX"; //esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "RX";
								
		String fechaSalida1 = "12/04/2017";
								
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aterrizarTramitesDeAsientos.setOceanic(oceanic);
		OceanicCriterioDeReserva criterioReserva = new OceanicCriterioDeReserva(codigoDeVuelo, numeroDeAsiento);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20"); //cumplen
				
		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA); 
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", numeroDeAsiento, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);	
		vuelo1.agregarAsiento(asiento3);
					
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1); //los asientos guardados cumplen por el vuelo.
							
		boolean asientoEstaReservado = aterrizarTramitesDeAsientos.getOceanicBusquedaCompraYReserva().estaReservado(criterioReserva);
		//prueba:
		Mockito.when(oceanic.estaReservado(codigoDeVuelo, numeroDeAsiento)).thenReturn(asientoEstaReservado);
		Assert.assertEquals(aterrizarTramitesDeAsientos.getOceanic().estaReservado(codigoDeVuelo, numeroDeAsiento), asientoEstaReservado);
		Mockito.verify(oceanic).estaReservado(codigoDeVuelo, numeroDeAsiento);
	}
}
