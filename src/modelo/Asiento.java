package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import excepciones.ExcepcionAsientoNoDisponible;

public class Asiento{
	
	protected Vuelo vuelo;
	protected Clase claseAsiento;
	protected Ubicacion ubicacionAsiento;
	protected Estado estadoAsiento;

	protected String codigoDeAsiento;
	protected double precio;
	private SimpleDateFormat formatterVuelo;
	private SimpleDateFormat formatterVista;

	public Asiento(Vuelo vuelo, Clase claseAsiento, Ubicacion ubicacionAsiento, Estado estadoAsiento) {
		this.vuelo = vuelo;
		this.claseAsiento = claseAsiento;
		this.ubicacionAsiento = ubicacionAsiento;
		this.estadoAsiento = estadoAsiento;
		this.codigoDeAsiento = setCodigoDeAsiento();
		formatterVuelo = new SimpleDateFormat("yyyyMMdd");
		formatterVista = new SimpleDateFormat("dd/MM/yyyy");
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
		return precioAsiento() * AterrizarTramitesDeAsientos.impuesto;
	}

	public double precioTotalConRecargoAUsuarioNoEstandar() {
		return precioTotalSinRecargo() + AterrizarTramitesDeAsientos.recargoAUsuarioNoEstandar;
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
		;  
		HashMap<String, String> datos = new HashMap<String, String>();
		//("Salida"); 
		
		Date fecha = null;
		try {
			fecha = formatterVuelo.parse(this.getVuelo().getFechaSalida());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datos.put("Salida",formatterVista.format(fecha) );
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
	
	public Asiento comprar() {
		setEstadoAsiento(Estado.COMPRADO);
		return this;
	}

	public Asiento comprarSiEstaDisponible() {
		if(estadoAsiento.estaDisponible()) {
			return comprar();
		}
		else {
			throw new ExcepcionAsientoNoDisponible();
		}
	}
	
	private boolean validacionReservadoODisponible(boolean aceptaOfertas, Usuario usuario) {
		return estadoAsiento.estaDisponible() || (estadoAsiento.estaReservado() && usuario.getAsientosReservados().contains(this));
	}

	public Asiento comprarSegun(boolean aceptaOfertas, Usuario usuario) {
		if(validacionReservadoODisponible(aceptaOfertas, usuario)) {
			return comprar();
		}
		else {
			throw new ExcepcionAsientoNoDisponible();
		}
	}

	public Asiento reservar() {
		setEstadoAsiento(Estado.RESERVADO);
		return this;
	}

	public Asiento sobreReservar(Usuario usuario, AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos) {
		if(estadoAsiento.estaReservado()) {
			CombinacionAsientoUsuario reserva = new CombinacionAsientoUsuario(this, usuario);
			aterrizarTramitesDeAsientos.sobreReservar(reserva);
		}
		else if(estadoAsiento.estaDisponible()) {
			reservar();
		}
		else {
			throw new ExcepcionAsientoNoDisponible();
		}
		return this;
	}
}
