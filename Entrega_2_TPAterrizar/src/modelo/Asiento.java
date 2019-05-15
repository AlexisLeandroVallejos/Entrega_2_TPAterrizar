package modelo;

import excepciones.ExcepcionPrecioClaseAsiento;
import excepciones.ExcepcionPrecioUbicacionAsiento;

public class Asiento {
	private final Vuelo vuelo;
	private final Usuario usuarioBuscando;
	private final String claseAsiento; // T, E, P - No va cambiar una vez que se defina.
	private final String ubicacionAsiento; // V, C, P - ^idem.
	private String estadoAsiento; // D, R - El estado podria cambiar.
	private String codigoDeAsiento; // Se agregara despues en un set... que set mas tramposo.
	private String precioFinal;

	
	public Asiento(Vuelo vuelo, Usuario usuario, String claseAsiento, String ubicacionAsiento, String estadoAsiento) {
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
		return usuarioBuscando.getClass() == UsuarioNoEstandar.class;
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

	public String getEstadoAsiento() {
		return estadoAsiento;
	}

	public void setEstadoAsiento(String estadoAsiento) {
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

	public boolean esDisponible() {
		return estadoAsiento == "D";
	}

	public boolean esAsientoTurista() {
		return claseAsiento == "T";
	}

	public boolean esAsientoEjecutivo() {
		return claseAsiento == "E";
	}

	public boolean esAsientoPrimeraClase() {
		return claseAsiento == "P";
	}

	public boolean esAsientoVentanilla() {
		return ubicacionAsiento == "V";
	}

	public boolean esAsientoCentro() {
		return ubicacionAsiento == "C";
	}

	public boolean esAsientoPasillo() {
		return ubicacionAsiento == "P";
	}

	public double precioClaseAsiento() {
		if (esAsientoTurista()) {
			return Aerolinea.asientoTurista;
		}
		if (esAsientoEjecutivo()) {
			return Aerolinea.asientoEjecutivo;
		}
		if (esAsientoPrimeraClase()) {
			return Aerolinea.asientoPrimeraClase;
		} else {
			throw new ExcepcionPrecioClaseAsiento();
		}
	}

	public double precioUbicacionAsiento() {
		if (esAsientoVentanilla()) {
			return Aerolinea.asientoVentanilla;
		}
		if (esAsientoCentro()) {
			return Aerolinea.asientoCentro;
		}
		if (esAsientoPasillo()) {
			return Aerolinea.asientoPasillo;
		} else {
			throw new ExcepcionPrecioUbicacionAsiento();
		}
	}

	public boolean esAsientoPrimeraClaseYPrecioFinalMenorA8000() {
		return esAsientoPrimeraClase() && Double.parseDouble(precioFinal) < 8000;
	}

	public boolean esAsientoEjecutivoYPrecioFinalMenorA4000() {
		return esAsientoEjecutivo() && Double.parseDouble(precioFinal) < 4000;
	}

	public boolean esSuperOferta() {
		if (esAsientoPrimeraClaseYPrecioFinalMenorA8000() || 
			esAsientoEjecutivoYPrecioFinalMenorA4000()) {
			return true;
		} else {
			return false;
		}
	}

}
