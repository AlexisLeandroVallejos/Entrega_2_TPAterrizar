package modelo;

import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AsientoDTO extends Asiento{
	//AsientoDTO son asientos de Oceanic.
	
	private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/uuuu"); // dd/MM/AAAA
	private DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm"); // hh:mm
	private LocalDate fechaDeSalida;
	private LocalTime horaDeSalida;
	private Integer numeroDeAsiento;

	public AsientoDTO(String codigoDeVuelo, Integer numeroDeAsiento, String fechaDeSalida, 
			String horaDeSalida, double precio, Clase claseAsiento, Ubicacion ubicacionAsiento) {
		super(new Vuelo(codigoDeVuelo,"","",fechaDeSalida,"", horaDeSalida,""), claseAsiento, ubicacionAsiento, Estado.DISPONIBLE);
		this.numeroDeAsiento = numeroDeAsiento;
		this.codigoDeAsiento = setCodigoDeAsiento();
		this.fechaDeSalida = LocalDate.parse(fechaDeSalida, formatoFecha);
		this.horaDeSalida = LocalTime.parse(horaDeSalida, formatoHora);
	}
	
	public Integer getNumeroDeAsiento() {
		return numeroDeAsiento;
	}
	

	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public String getAerolinea()
	{
		return "Oceanic";
	}
	
	//Devuelve los datos formateados para la grilla.
	public HashMap<String,String> getDatosParaLista()
	{
		HashMap<String,String> datos = new HashMap<String,String>();
		//("Salida"); 
		datos.put("Salida", this.fechaDeSalida + " " + this.horaDeSalida);
		//("Aerolinea");
		datos.put("Aerolinea",this.getAerolinea());
		//("Vuelo");
		datos.put("Vuelo",this.getCodigoDeVuelo());
		//("Asiento");
		datos.put("Asiento",this.getNumeroDeAsiento().toString());
		//("Precio");
		datos.put("Precio", Double.toString(this.precio));
		datos.put("Ubicacion", this.ubicacionAsiento.getDescripcion());
		return datos;
	}
	
}
