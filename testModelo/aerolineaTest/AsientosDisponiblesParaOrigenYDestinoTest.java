package aerolineaTest;


import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class AsientosDisponiblesParaOrigenYDestinoTest {
	
	@Test
	public void asientosDisponiblesParaOrigenYDestino_SeObtienenAsientosQueCumplanOrigenFechaSalidaYDestino() {
		//inicio:
		String codigoOrigenOceanic1 = "LA"; //esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "NR"; //esto debe cambiar a NR_; vuelo1
					
		String fechaSalida1 = "12/04/2017";
				
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aterrizarTramitesDeAsientos.setOceanic(oceanic);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20");
		OceanicCriterioDeBusqueda criterioBusqueda = new OceanicCriterioDeBusqueda(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1);
						
		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", 22, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);	
		vuelo1.agregarAsiento(asiento3);
						
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
						
		List<Asiento> listaAsientosDisponibles = aterrizarTramitesDeAsientos.getOceanicBusquedaCompraYReserva().asientosDisponiblesParaOrigenYDestino(criterioBusqueda);
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1)).thenReturn(listaAsientosDisponibles);
		Assert.assertEquals(aterrizarTramitesDeAsientos.getOceanic().asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1).size(), listaAsientosDisponibles.size());
		Mockito.verify(oceanic).asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1);
	}
	
	@Test
	public void asientosDisponiblesParaOrigenYDestino_CodigoOrigenLADevuelveSLAYCodigoDestinoNRDevuelveNR_() {
		//inicio:
		String codigoOrigenOceanic1 = "LA"; //esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "NR"; //esto debe cambiar a NR_; vuelo1
				
		String fechaSalida1 = "12/04/2017";
			
		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aterrizarTramitesDeAsientos.setOceanic(oceanic);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20");
		OceanicCriterioDeBusqueda criterioBusqueda = new OceanicCriterioDeBusqueda(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1);
				
		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", 22, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);	
		vuelo1.agregarAsiento(asiento3);
				
		aterrizarTramitesDeAsientos.agregarVuelo(vuelo1);
				
		List<Asiento> listaAsientosDisponibles = aterrizarTramitesDeAsientos.getOceanicBusquedaCompraYReserva().asientosDisponiblesParaOrigenYDestino(criterioBusqueda);
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1)).thenReturn(listaAsientosDisponibles);
		Assert.assertEquals(aterrizarTramitesDeAsientos.getOceanic().asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1), listaAsientosDisponibles);
		Mockito.verify(oceanic).asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic1, fechaSalida1, codigoDestinoOceanic1);
	}
	
}
