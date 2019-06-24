package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int dni;
	protected Aerolinea aerolinea;
	protected double dineroTotalGastado;
	
	private ArrayList<ArrayList<String>> historicoBusquedas = new ArrayList<ArrayList<String>>();
	protected List<Asiento> compras = new ArrayList<Asiento>();
	protected List<Asiento> reservas = new ArrayList<Asiento>();
	
	public Usuario(String nombre, String apellido, int dni, Aerolinea aerolinea) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.aerolinea = aerolinea;
	}
	
	public String getApellido() {
		return apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	public ArrayList<ArrayList<Asiento>> realizarBusqueda 
			(String origen, String fechaSalida, String horaSalida,
			String destino, String fechaLlegada, String horaLlegada) {
		
		ArrayList<String> criterios = new ArrayList<>(
				Arrays.asList(origen, fechaSalida, horaSalida, destino, fechaLlegada, horaLlegada));
		this.historicoBusquedas.add(criterios);
			return aerolinea.asientosDisponibles(origen, fechaSalida, horaSalida,
					destino, fechaLlegada, horaLlegada);
		
	}
	
	public void comprar(String CodAsiento){
		try{
			Asiento asientoComprado = aerolinea.comprar(CodAsiento);
			compras.add(asientoComprado);
			
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public boolean suscripto() {
		return false;
	}

	public ArrayList<ArrayList<String>> getHistoricoBusquedas() {
		return historicoBusquedas;
	}

	public List<Asiento> getCompras() {
		return compras;
	}

	public List<Asiento> getReservas() {
		return reservas;
	}
}
