package aerolineaTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgregarAsientoTest.class, AsientosDisponiblesParaOrigenTest.class,
		AsientosDisponiblesParaOrigenYDestinoTest.class, AsientosDisponiblesTest.class, BuscarAsientoTest.class,
		ComprarSiHayDisponibilidadTest.class, EstaReservadoTest.class, HayAlgunoQueCumpleTest.class,
		ObtenerAsientosTest.class, ReservarTest.class })
public class _AerolineaTests {

}
