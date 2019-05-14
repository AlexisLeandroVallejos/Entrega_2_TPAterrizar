package modelo;

import java.util.ArrayList;

public interface AerolineaLanchita {
	//claseAsiento:
	final double asientoTurista = 250;
	final double asientoEjecutivo = 500;
	final double asientoPrimeraClase = 1000;
	//ubicacionAsiento:
	final double asientoPasillo = 200;
	final double asientoCentro = 100;
	final double asientoVentanilla = 300;
	//impuesto:
	final double impuesto = 0.15;
	//recargo a usuarios no estandar:
	final double recargoAUsuarioNoEstandar = 20;
	
	public ArrayList<ArrayList<Asiento>> asientosDisponibles 
		(String origen, String fechaSalida, String horaSalida,
		String destino, String fechaLlegada, String horaLlegada);
	
	public void comprar (String codigoAsiento);
}
