package modelo;

import java.util.ArrayList;

public interface AerolineaLanchita {

	
	public ArrayList<ArrayList<Asiento>> asientosDisponibles 
		(String origen, String fechaSalida, String horaSalida,
		String destino, String fechaLlegada, String horaLlegada);
	
	public void comprar (String codigoAsiento);
}
