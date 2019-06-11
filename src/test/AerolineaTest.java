package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import modelo.*;

public class AerolineaTest {
	
	@Test
	public void agregarAsiento_seAgregaUnAsientoYCambiaElNumeroDeAsientos() {
		Vuelo vuelo = new Vuelo("EC0344", "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Asiento asiento1 = new Asiento(vuelo, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento1);
		Asiento asiento3 = new Asiento(vuelo, usuario, Clase.EJECUTIVA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento3);
		Asiento asiento2 = new Asiento(vuelo, usuario, Clase.EJECUTIVA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento2);
		//^este orden es intencional, sino no funciona.
		Assert.assertEquals("El numero de asiento no cambio.", vuelo.cantidadDeAsientos(), 3);
	}
	
	@Test
	public void obtenerAsientos_seObtieneUnAsientoDadoElCodigoDeVuelo() {
		String codDeVuelo = "EC0344";
		Vuelo vuelo = new Vuelo(codDeVuelo, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Asiento asiento = new Asiento(vuelo, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo.agregarAsiento(asiento);
		Assert.assertEquals("No se encontro asiento.", vuelo.obtenerAsientosDisponibles().get(0), asiento);
	}
	

	@Test
	public void hayAlgunoQueCumple_SeEncuentraAlMenosUnVueloQueCumplaBUE() {
		String codDeVuelo1 = "EC0344";
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList("BUE", null, null, null, null, null));
		
		Assert.assertEquals("No se encontraron vuelos", true, 
				lanchita.getVuelos().stream().anyMatch(vuelo -> vuelo.cumpleAlgunCriterio(criterios)));
	}
	
	@Test
	public void asientosDisponibles_seObtieneUnaListaDeAsientosDisponibles() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		lanchita.asientosDisponibles(null, null, null, "BUE", null, null); //el destino es "BUE"
	}
	//Agregar test para buscar vuelos: Destino, fecha, clase de asiento, ubicacion
	@Test
	public void asientosDisponibles_seObtienenTresVuelosQueCumplenConLaBusquedaDestino() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		String codDeVuelo4 = "MIN12";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		Vuelo vuelo4 = new Vuelo(codDeVuelo4, "TX", "BUE", "20111024", "20111025", "15:00", "20:00");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Asientos vuelo3
		Asiento asiento10 = new Asiento(vuelo3, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo4.agregarAsiento(asiento10);
		Asiento asiento11 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo4.agregarAsiento(asiento11);
		Asiento asiento12 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo4.agregarAsiento(asiento12);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontro un Vuelo a BUE", 3, 
				lanchita.asientosDisponibles("BUE", null, null, null, null, null).size());
	}
	
	@Test
	public void asientosDisponibles_NoSeObtieneUnVuelo() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "2010116", "2010117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "2010216", "2010216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("Se encontraron asientos en vuelos a NYC", 0, 
				lanchita.asientosDisponibles("NYC", null, null, null, null, null).size());
	}
	
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
	
	@Test
	public void asientosDisponiblesParaOrigenYDestino_SeObtienenAsientosQueCumplanOrigenYFechaSalida() {
		//inicio:
		String codigoOrigenOceanic = "RAR23";
		String fechaSalida = "12/04/2017";
		String codigoDestinoOceanic = "LAL01";
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
		Mockito.when(oceanic.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic))
			.thenReturn(listaAsientosFiltrados);
		Assert.assertEquals(listaAsientosFiltrados, 
				lanchita.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic));
		Mockito.verify(oceanic).asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic);
	}
	
	@Test
	public void asientosDisponiblesParaOrigenYDestino_CodigoOrigenLADeUnAsientoDevuelveSLA() {
		//inicio:
		String codigoOrigenOceanic = "LA";
		String fechaSalida = "12/04/2017";
		String codigoDestinoOceanic = "LAL01";
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
		Mockito.when(oceanic.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic))
			.thenReturn(listaAsientosFiltrados);
		Assert.assertEquals(listaAsientosFiltrados, 
				lanchita.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic));
		Mockito.verify(oceanic).asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic);
	}
	
	@Test
	public void asientosDisponiblesParaOrigenYDestino_CodigoOrigenNoEsLAYAgregaUnGuionBajoAlFinal() {
		//inicio:
		String codigoOrigenOceanic = "LS";
		String fechaSalida = "12/04/2017";
		String codigoDestinoOceanic = "LAL01";
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
		Mockito.when(oceanic.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic))
			.thenReturn(listaAsientosFiltrados);
		Assert.assertEquals(listaAsientosFiltrados, 
				lanchita.asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic));
		Mockito.verify(oceanic).asientosDisponiblesParaOrigenYDestino(codigoOrigenOceanic, fechaSalida, codigoDestinoOceanic);
	}
	
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
	

	
	@Test
	public void buscarAsiento_Trae2AsientosSinFiltrosOpcionales() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontraron asientos en vuelos a BUE", 2, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA").size());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosReservados() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Assert.assertEquals("No se encontraron asientos en vuelos a BUE", 3, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", null,0,0,true, null).size());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorPrecioDescendente() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "WAS", "BUE", "20110216", "20110216", "10:10", "20:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo1.agregarAsiento(asiento2);
		Asiento asiento3 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento3);
		Asiento asiento1 = new Asiento(vuelo1, usuario, Clase.PRIMERA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento1);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		Asiento asiento5 = new Asiento(vuelo2, usuario, Clase.EJECUTIVA, Ubicacion.CENTRO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento5);
		Asiento asiento6 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.VENTANA, Estado.DISPONIBLE);
		vuelo2.agregarAsiento(asiento6);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		
		AsientoBusquedaOrden ordenPrecio = AsientoBusquedaOrden.PRECIOD;
		
		Assert.assertEquals("No se encontraron el asiento1", asiento1, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenPrecio).get(0));
	}
	

	@Test
	public void buscarAsiento_TraeAsientosOrdenadosPorTiempoVuelo() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		
		AsientoBusquedaOrden ordenTiempoVuelo = AsientoBusquedaOrden.TIEMPOVUELO;
		
		Assert.assertEquals("No se encontraron el vuelo1, el de menor duracion", vuelo1, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", null,0,0,true, ordenTiempoVuelo).get(1).getVuelo());
	}
	

	@Test
	public void buscarAsiento_TraeAsientosEjecutivos() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.EJECUTIVA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.PRIMERA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Clase claseEjecutiva = Clase.EJECUTIVA;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("No se encontro el asiento ejecutivo", 1, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	

	@Test
	public void buscarAsiento_NoTraeAsientosEjecutivos() {
		String codDeVuelo1 = "EC0344";
		String codDeVuelo2 = "TGX2";
		String codDeVuelo3 = "JAH18";
		Aerolinea lanchita = new Aerolinea();
		UsuarioEstandar usuario = new UsuarioEstandar("Roman","Perez", 24888654, lanchita);
		Vuelo vuelo2 = new Vuelo(codDeVuelo2, "BUE", "LA", "20110116", "20110316", "10:10", "20:20");
		Vuelo vuelo1 = new Vuelo(codDeVuelo1, "BUE", "LA", "20110116", "20110117", "20:10", "14:20");
		Vuelo vuelo3 = new Vuelo(codDeVuelo3, "TX", "BUE", "20111024", "20111025", "23:40", "09:15");
		//Asientos vuelo1
		Asiento asiento2 = new Asiento(vuelo1, usuario, Clase.TURISTA, Ubicacion.PASILLO, Estado.DISPONIBLE);
		vuelo1.agregarAsiento(asiento2);
		//Asientos vuelo2
		Asiento asiento4 = new Asiento(vuelo2, usuario, Clase.TURISTA, Ubicacion.PASILLO, Estado.RESERVADO);
		vuelo2.agregarAsiento(asiento4);
		//Asientos vuelo3
		Asiento asiento7 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento7);
		Asiento asiento8 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento8);
		Asiento asiento9 = new Asiento(vuelo3, usuario, Clase.TURISTA, Ubicacion.CENTRO, Estado.DISPONIBLE);
		vuelo3.agregarAsiento(asiento9);
		//Agregar vuelos a aerolinea:
		lanchita.agregarVuelo(vuelo1);
		lanchita.agregarVuelo(vuelo2);
		lanchita.agregarVuelo(vuelo3);
		Clase claseEjecutiva = Clase.EJECUTIVA;
		Clase [] clasesAsientos = new Clase[] {claseEjecutiva};
		Assert.assertEquals("Se encontro el asiento ejecutivo", 0, 
				lanchita.BuscarAsientos("BUE","20110116" , "LA", clasesAsientos,0,0,true, null).size());
	}
	//Prueba/Mantenimiento.
	
	
}
