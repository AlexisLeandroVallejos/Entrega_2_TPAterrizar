package modelo;

import java.util.HashMap;

public class Asiento{
	
	protected Vuelo vuelo;
	protected Clase claseAsiento;
	protected Ubicacion ubicacionAsiento;
	protected Estado estadoAsiento;

	protected String codigoDeAsiento;
	protected double precio;

	public Asiento(Vuelo vuelo, Clase claseAsiento, Ubicacion ubicacionAsiento, Estado estadoAsiento) {
		this.vuelo = vuelo;
		this.claseAsiento = claseAsiento;
		this.ubicacionAsiento = ubicacionAsiento;
		this.estadoAsiento = estadoAsiento;
		this.codigoDeAsiento = setCodigoDeAsiento();
	}

	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio() {
		this.precio = precioTotalSinRecargo();
	}

	public void setPrecio(Usuario usuario) {
		if (usuarioNoEstandarEstaBuscando(usuario)) {
			this.precio = precioTotalConRecargoAUsuarioNoEstandar();
		} else {
			setPrecio();
		}

	}

	public boolean usuarioNoEstandarEstaBuscando(Usuario usuario) {
		return !usuario.suscripto();
	}

	public double precioAsiento() {
		return precioClaseAsiento() + precioUbicacionAsiento();
	}

	public double impuestoAlPrecioAsiento() {
		return precioAsiento() * Aerolinea.impuesto;
	}

	public double precioTotalConRecargoAUsuarioNoEstandar() {
		return precioTotalSinRecargo() + Aerolinea.recargoAUsuarioNoEstandar;
	}

	public double precioTotalSinRecargo() {
		return precioAsiento() + impuestoAlPrecioAsiento();
	}

	public Estado getEstadoAsiento() {
		return estadoAsiento;
	}

	public void setEstadoAsiento(Estado estadoAsiento) {
		this.estadoAsiento = estadoAsiento;
	}
	
	public String getCodigoDeVuelo() {
		return vuelo.getCodDeVuelo();
	}

	public String getCodigoDeAsiento() {
		return codigoDeAsiento;
	}

	public String setCodigoDeAsiento() {
		return vuelo.getCodDeVuelo() + "-" + getNumeroDeAsiento();
	}

	public boolean esCodigoDeVuelo(String codDeVuelo) {
		return codigoDeAsiento.contains(codDeVuelo);
	}

	public Integer getNumeroDeAsiento() {
		return vuelo.cantidadDeAsientos() + 1;
	}

	public double precioClaseAsiento() {
		return claseAsiento.getPrecio();
	}

	public double precioUbicacionAsiento() {
		return ubicacionAsiento.getPrecio();
	}

	public boolean esAsientoPrimeraYPrecioFinalMenorA8000() {
		return claseAsiento.getDescripcion() == "Primera" && precio < 8000;
	}

	public boolean esAsientoEjecutivoYPrecioFinalMenorA4000() {
		return claseAsiento.getDescripcion() == "Ejecutivo" && precio < 4000;
	}
	
	public boolean esSuperOferta() {
		return esAsientoPrimeraYPrecioFinalMenorA8000() || esAsientoEjecutivoYPrecioFinalMenorA4000();
	}

	public boolean esClaseAsiento(Clase[] clases) {
		boolean esClase = false;
		for(Clase clase : clases)
		{
			if(clase.equals(this.claseAsiento))
			{
				esClase = true;
			}
		}
		return esClase;
	}
	
	public Vuelo getVuelo(){
		return vuelo;
	}
	
	public double duracionVuelo(){
		return vuelo.getDuracionVuelo();
	}

	public double getPopularidadVuelo()
	{
		//algo? definir sistema de popularidad..
		return 0;
	}
	
	public String getAerolinea()
	{
		return "Lanchita";
	}
	
	//Devuelve los datos formateados para la grilla.
	public HashMap<String,String> getDatosParaLista()
	{
		HashMap<String, String> datos = new HashMap<String, String>();
		//("Salida"); 
		datos.put("Salida", this.getVuelo().getFechaSalida() + " " + this.getVuelo().getHoraSalida());
		//("Aerolinea");
		datos.put("Aerolinea", this.getAerolinea());
		//("Vuelo");
		datos.put("Vuelo", this.getCodigoDeVuelo());
		//("Asiento");
		datos.put("Asiento", this.getNumeroDeAsiento().toString());
		//("Precio");
		datos.put("Precio", Double.toString(this.getPrecio()));
		datos.put("Ubicacion", this.ubicacionAsiento.getDescripcion());
		return datos;
	}

	public boolean vencioReserva()
	{
		// definir sistema de vencimientos, devuelvo true para testing.
		return false;
	}
	

}
