package modelo;

public class Asiento {
	private final Vuelo vuelo;
	private final Usuario usuarioBuscando;
	private final Clase claseAsiento;
	private final Ubicacion ubicacionAsiento;
	private Estado estadoAsiento;
	private String codigoDeAsiento;
	private String precioFinal;

	public Asiento(Vuelo vuelo, Usuario usuario, Clase claseAsiento, Ubicacion ubicacionAsiento, Estado estadoAsiento) {
		this.vuelo = vuelo;
		this.usuarioBuscando = usuario;
		this.claseAsiento = claseAsiento;
		this.ubicacionAsiento = ubicacionAsiento;
		this.estadoAsiento = estadoAsiento;
		this.codigoDeAsiento = setCodigoDeAsiento();
		this.precioFinal = setPrecio();
	}

	public String getPrecioFinal() {
		return precioFinal;
	}

	public String setPrecio() {
		if (usuarioNoEstandarEstaBuscando()) {
			return Double.toString(precioTotalConRecargoAUsuarioNoEstandar());
		} else {
			return Double.toString(precioTotalSinRecargo());
		}

	}

	public boolean usuarioNoEstandarEstaBuscando() {
		return usuarioBuscando.getClass() == UsuarioNoEstandar.class; // TODO: REEEEEEEEEEEEEEEEfactorizar. pero para
																		// ayer...
	}

	public double precioAsiento() {
		return precioClaseAsiento() + precioUbicacionAsiento();
	}

	public double impuestoAlPrecioAsiento() {
		return precioAsiento() * Aerolinea.impuesto;
	}

	public double recargoAUsuarioNoEstandar() {
		return Aerolinea.recargoAUsuarioNoEstandar;
	}

	public double precioTotalConRecargoAUsuarioNoEstandar() {
		return precioAsiento() + impuestoAlPrecioAsiento() + recargoAUsuarioNoEstandar();
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
		if (claseAsiento.esTurista()) {
			return Aerolinea.asientoTurista;
		}
		if (claseAsiento.esEjecutiva()) {
			return Aerolinea.asientoEjecutivo;
		} else {
			return Aerolinea.asientoPrimeraClase;
		}
	}

	public double precioUbicacionAsiento() {
		if (ubicacionAsiento.esVentana()) {
			return Aerolinea.asientoVentana;
		}
		if (ubicacionAsiento.esCentro()) {
			return Aerolinea.asientoCentro;
		} else {
			return Aerolinea.asientoPasillo;
		}
	}

	public boolean esAsientoPrimeraClaseYPrecioFinalMenorA8000() {
		return claseAsiento.esPrimeraClase() && Double.parseDouble(precioFinal) < 8000;
	}

	public boolean esAsientoEjecutivoYPrecioFinalMenorA4000() {
		return claseAsiento.esEjecutiva() && Double.parseDouble(precioFinal) < 4000;
	}

	public boolean esSuperOferta() {
		if (esAsientoPrimeraClaseYPrecioFinalMenorA8000() || esAsientoEjecutivoYPrecioFinalMenorA4000()) {
			return true;
		} else {
			return false;
		}
	}

}
