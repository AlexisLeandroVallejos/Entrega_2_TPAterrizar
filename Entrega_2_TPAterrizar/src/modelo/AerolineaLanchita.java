package modelo;

import java.util.ArrayList;

public interface AerolineaLanchita {
	final int asientoTurista = 250;
	final int asientoEjecutivo = 500;
	final int asientoPrimeraClase = 1000;
	final int asientoPasillo = 200;
	final int asientoCentro = 100;
	final int asientoVentanilla = 300;
	final double impuesto = 0.15;
	
	public ArrayList<ArrayList<String>> asientosDisponibles 
		(String origen, String fechaSalida, String horaSalida,
		String destino, String fechaLlegada, String horaLlegada);
	
	public void comprar (String codigoAsiento);
}
