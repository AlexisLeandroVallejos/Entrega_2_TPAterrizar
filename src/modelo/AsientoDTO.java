package modelo;

import java.util.HashMap;

public class AsientoDTO extends Asiento {

	private String codigoDeVuelo;
	private Integer numeroDeAsiento;
	private String fechaDeSalida; // dd/MM/yyyy
	private String horaDeSalida; // HH:mm
	private double precio;
	private Clase claseAsiento;
	//private Ubicacion ubicacionAsiento;
	private boolean reservado = false;
	private boolean comprado = false;

	
	public AsientoDTO(String codigoDeVuelo, Integer numeroDeAsiento, String fechaDeSalida, 
			String horaDeSalida, double precio, Clase claseAsiento, Ubicacion ubicacionAsiento) {
		super(new Vuelo(codigoDeVuelo,"","",fechaDeSalida,"", horaDeSalida,""),
				claseAsiento,ubicacionAsiento,Estado.DISPONIBLE);
		this.codigoDeVuelo = codigoDeVuelo;
		this.numeroDeAsiento = numeroDeAsiento;
		this.fechaDeSalida = fechaDeSalida;
		this.horaDeSalida = horaDeSalida;
		this.precio = precio;
		this.claseAsiento = claseAsiento;
	}

	public String getCodigoDeVuelo() {
		return codigoDeVuelo;
	}

	public void setCodigoDeVuelo(String codigoDeVuelo) {
		this.codigoDeVuelo = codigoDeVuelo;
	}

	public String getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(String fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	public boolean esClaseAsiento(Clase[] clases) {
		boolean esClase = false;
		for(int index = 0; index < clases.length || esClase == true; index++)
		{
			if(clases[index].equals(this.claseAsiento))
			{
				esClase = true;
			}
		}
		return esClase;
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
		datos.put("Vuelo",this.codigoDeVuelo);
		//("Asiento");
		datos.put("Asiento",Integer.toString(this.numeroDeAsiento));
		//("Precio");
		datos.put( "Precio", Double.toString(this.precio ));
		datos.put( "Ubicacion", this.ubicacionAsiento.getDescripcion());
		return datos;
	}

}
