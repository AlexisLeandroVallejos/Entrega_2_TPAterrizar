package modelo;

import java.util.HashMap;

public class Asiento{
	private final Vuelo vuelo;
	private final Clase claseAsiento;
	protected final Ubicacion ubicacionAsiento;
	private Estado estadoAsiento;
	private String codigoDeAsiento;
	private double precioFinal;

	public Asiento(Vuelo vuelo, Clase claseAsiento, Ubicacion ubicacionAsiento, Estado estadoAsiento) {
		this.vuelo = vuelo;
		this.claseAsiento = claseAsiento;
		this.ubicacionAsiento = ubicacionAsiento;
		this.estadoAsiento = estadoAsiento;
		this.codigoDeAsiento = setCodigoDeAsiento();
	}

	public double getPrecioFinal() {
		return precioFinal;
	}
	
	public void setPrecioFinal() {
		this.precioFinal = precioTotalSinRecargo();
	}

	public void setPrecioFinal(Usuario usuario) {
		if (usuarioNoEstandarEstaBuscando(usuario)) {
			this.precioFinal = precioTotalConRecargoAUsuarioNoEstandar();
		} else {
			setPrecioFinal();
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

	public String getCodigoDeAsiento() {
		return codigoDeAsiento;
	}

	public String setCodigoDeAsiento() {
		return vuelo.getCodDeVuelo() + "-" + sumadorDeAsientos();
	}

	public boolean esCodigoDeVuelo(String codDeVuelo) {
		return codigoDeAsiento.contains(codDeVuelo);
	}

	public String sumadorDeAsientos() {
		int sumador = vuelo.cantidadDeAsientos() + 1;
		return Integer.toString(sumador);
	}

	public double precioClaseAsiento() {
		return claseAsiento.getPrecio();
	}

	public double precioUbicacionAsiento() {
		return ubicacionAsiento.getPrecio();
	}

	public boolean esAsientoPrimeraYPrecioFinalMenorA8000() {
		return claseAsiento.getDescripcion() == "Primera" && precioFinal < 8000;
	}

	public boolean esAsientoEjecutivoYPrecioFinalMenorA4000() {
		return claseAsiento.getDescripcion() == "Ejecutivo" && precioFinal < 4000;
	}
	
	public boolean esSuperOferta() {
		return esAsientoPrimeraYPrecioFinalMenorA8000() || esAsientoEjecutivoYPrecioFinalMenorA4000();
	}

	public boolean esClaseAsiento(Clase[] clases) {
		boolean esClase = false;
		//ArrayList<Clase> listaArray = new ArrayList<Clase>();
		//listaArray.addAll(clases);
		if(clases != null) {
			//arreglar condicion de corte en FOR cambiar a Lista
			
			for(int index = 0; index < clases.length; index++)
			{
				if(clases[index].equals(this.claseAsiento))
				{
					esClase = true;
					return esClase;
				}
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
		datos.put("Salida",this.getVuelo().getFechaSalida() + " " + this.getVuelo().getHoraSalida());
		//("Aerolinea");
		datos.put("Aerolinea",this.getAerolinea());
		//("Vuelo");
		datos.put("Vuelo",this.vuelo.getCodDeVuelo());
		//("Asiento");
		datos.put("Asiento",this.getCodigoDeAsiento().split("-")[1]);
		//("Precio");
		datos.put("Precio",Double.toString(this.getPrecioFinal() ));
		datos.put( "Ubicacion", this.ubicacionAsiento.getDescripcion());
		return datos;
	}

	public boolean vencioReserva()
	{
		// definir sistema de vencimientos, devuelvo true para testing.
		return false;
	}

}
