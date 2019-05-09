package modelo;

import java.util.ArrayList;

public class Aerolinea implements AerolineaLanchita {
	private ArrayList<String> asiento = new ArrayList<String>();
	private final int asientoTurista = 250;
	private final int asientoEjecutivo = 500;
	private final int asientoPrimeraClase = 1000;
	private final int asientoPasillo = 200;
	private final int asientoCentro = 100;
	private final int asientoVentanilla = 300;
	
	public ArrayList<String> getAsiento() {
		return asiento;
	}
	public void setAsiento(ArrayList<String> asiento) {
		this.asiento = asiento;
	}
	public void agregarAsiento
		(String codigoDeAsiento, String claseAsiento, String ubicacionAsiento, String estadoAsiento) {
		asiento.add(0,codigoDeAsiento);
		asiento.add(1,claseAsiento);
		asiento.add(2,ubicacionAsiento);
		asiento.add(3,estadoAsiento);
	}	
	
	@Override
	public ArrayList<ArrayList<String>> asientosDisponibles
		(String origen, String fechaSalida, String horaSalida,
		String destino, String fechaLlegada, String horaLlegada) {
		return null;
	}
	

	@Override
	public void comprar(String codigoAsiento) {
		// TODO Auto-generated method stub

	}

}
