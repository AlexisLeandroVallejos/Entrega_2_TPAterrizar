package aerolineaTest;


import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class AsientosDisponiblesParaOrigenTest {
	
	@Test
	public void asientosDisponiblesParaOrigen_SeObtienenAsientosQueCumplanOrigenYFechaSalida() {
		//inicio:
		String codigoOrigenOceanic1 = "ZX"; //esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "RX"; //esto debe cambiar a NR_; vuelo1
				
		String fechaSalida1 = "12/04/2017";
				
		Aerolinea aerolinea = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aerolinea.setOceanic(oceanic);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20"); //cumplen
		OceanicCriterioDeBusqueda criterioBusqueda = new OceanicCriterioDeBusqueda(codigoOrigenOceanic1, fechaSalida1);
		
		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA); 
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", 22, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);	
		vuelo1.agregarAsiento(asiento3);
			
		aerolinea.agregarVuelo(vuelo1); //los asientos guardados cumplen por el vuelo.
			
		List<Asiento> listaAsientosDisponibles = aerolinea.getOceanicBusquedaCompraYReserva().asientosDisponiblesParaOrigen(criterioBusqueda);
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigen(codigoOrigenOceanic1, fechaSalida1)).thenReturn(listaAsientosDisponibles);
		Assert.assertEquals(aerolinea.getOceanic().asientosDisponiblesParaOrigen(codigoOrigenOceanic1, fechaSalida1).size(), listaAsientosDisponibles.size());
		Mockito.verify(oceanic).asientosDisponiblesParaOrigen(codigoOrigenOceanic1, fechaSalida1);
	}
	
	@Test
	public void asientosDisponiblesParaOrigen_CodigoOrigenLADevuelveSLAYCodigoDestinoNRDevuelveNR_() {
		//inicio:
		String codigoOrigenOceanic1 = "LA"; //esto debe cambiar a SLA; vuelo1
		String codigoDestinoOceanic1 = "NR"; //esto debe cambiar a NR_; vuelo1
		
		String fechaSalida1 = "12/04/2017";
		
		Aerolinea aerolinea = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		aerolinea.setOceanic(oceanic);
		Vuelo vuelo1 = new Vuelo("ECO23", codigoOrigenOceanic1, codigoDestinoOceanic1, fechaSalida1, "2010117", "20:10", "14:20");
		OceanicCriterioDeBusqueda criterioBusqueda = new OceanicCriterioDeBusqueda(codigoOrigenOceanic1, fechaSalida1);
		
		AsientoDTO asiento1 = new AsientoDTO("ECO23", 12, fechaSalida1, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		vuelo1.agregarAsiento(asiento1);
		AsientoDTO asiento3 = new AsientoDTO("ECO23", 22, fechaSalida1, "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);	
		vuelo1.agregarAsiento(asiento3);
		
		aerolinea.agregarVuelo(vuelo1);
		
		List<Asiento> listaAsientosDisponibles = aerolinea.getOceanicBusquedaCompraYReserva().asientosDisponiblesParaOrigen(criterioBusqueda);
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigen(codigoOrigenOceanic1, fechaSalida1)).thenReturn(listaAsientosDisponibles);
		Assert.assertEquals(aerolinea.getOceanic().asientosDisponiblesParaOrigen(codigoOrigenOceanic1, fechaSalida1), listaAsientosDisponibles);
		Mockito.verify(oceanic).asientosDisponiblesParaOrigen(codigoOrigenOceanic1, fechaSalida1);
	}
	
}
