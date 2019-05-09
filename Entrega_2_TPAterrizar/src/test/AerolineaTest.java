package test;

import org.junit.Test;

import modelo.*;

public class AerolineaTest {
	
	@Test
	public void agregarAsiento_seAgregaUnAsiento() {
		Aerolinea aerolinea = new Aerolinea();
		aerolinea.agregarAsiento("EC0344-42", "P", "P", "D");
		aerolinea.getAsiento();
	}
}
