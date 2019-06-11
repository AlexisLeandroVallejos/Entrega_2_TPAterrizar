package aerolineaTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class AsientosDisponiblesParaOrigenTest {
	
	@Test
	public void asientosDisponiblesParaOrigen_SeObtienenAsientosQueCumplanOrigenYFechaSalida() {
		//inicio:
		String codigoOrigenOceanic = "RAR23";
		String fechaSalida = "12/04/2017";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoOrigenOceanic, 12, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		AsientoDTO asiento2 = new AsientoDTO("WAR66", 245, fechaSalida, "17:15", 500.51, Clase.EJECUTIVA, Ubicacion.CENTRO);
		AsientoDTO asiento3 = new AsientoDTO(codigoOrigenOceanic, 22, "16/01/2015", "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);
		List<AsientoDTO> asientos = Arrays.asList(asiento1,asiento2,asiento3);
		List<AsientoDTO> listaAsientosFiltrados = asientos.stream()
				.filter(asiento -> asiento.getCodigoDeVuelo() == codigoOrigenOceanic && asiento.getFechaDeSalida() == fechaSalida)
				.collect(Collectors.toList());
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida)).thenReturn(listaAsientosFiltrados);
		Assert.assertEquals(listaAsientosFiltrados, lanchita.asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida));
		Mockito.verify(oceanic).asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida);
	}
	
	@Test
	public void asientosDisponiblesParaOrigen_CodigoOrigenLADeUnAsientoDevuelveSLA() {
		//inicio:
		String codigoOrigenOceanic = "LA";
		String fechaSalida = "12/04/2017";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoOrigenOceanic, 12, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		AsientoDTO asiento3 = new AsientoDTO(codigoOrigenOceanic, 22, "16/01/2015", "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);
		List<AsientoDTO> asientos = Arrays.asList(asiento1,asiento3);
		List<AsientoDTO> listaAsientosFiltrados = asientos.stream()
				.filter(asiento -> asiento.getCodigoDeVuelo() == codigoOrigenOceanic && asiento.getFechaDeSalida() == fechaSalida)
				.collect(Collectors.toList());
		listaAsientosFiltrados.forEach(asiento -> asiento.setCodigoDeVuelo("S"+codigoOrigenOceanic));
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida)).thenReturn(listaAsientosFiltrados);
		Assert.assertEquals(listaAsientosFiltrados, lanchita.asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida));
		Mockito.verify(oceanic).asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida);
	}
	
	@Test
	public void asientosDisponiblesParaOrigen_CodigoOrigenNoEsLAYAgregaUnGuionBajoAlFinal() {
		//inicio:
		String codigoOrigenOceanic = "LR";
		String fechaSalida = "12/04/2017";
		Aerolinea lanchita = new Aerolinea();
		Oceanic oceanic = Mockito.mock(Oceanic.class);
		lanchita.setOceanic(oceanic);
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoOrigenOceanic, 12, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		AsientoDTO asiento3 = new AsientoDTO(codigoOrigenOceanic, 22, "16/01/2015", "20:15", 650.5, Clase.PRIMERA, Ubicacion.PASILLO);
		List<AsientoDTO> asientos = Arrays.asList(asiento1,asiento3);
		List<AsientoDTO> listaAsientosFiltrados = asientos.stream()
				.filter(asiento -> asiento.getCodigoDeVuelo() == codigoOrigenOceanic && asiento.getFechaDeSalida() == fechaSalida)
				.collect(Collectors.toList());
		listaAsientosFiltrados.forEach(asiento -> asiento.setCodigoDeVuelo(codigoOrigenOceanic+"_"));
		//prueba:
		Mockito.when(oceanic.asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida)).thenReturn(listaAsientosFiltrados);
		Assert.assertEquals(listaAsientosFiltrados, lanchita.asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida));
		Mockito.verify(oceanic).asientosDisponiblesParaOrigen(codigoOrigenOceanic, fechaSalida);
	}
}
