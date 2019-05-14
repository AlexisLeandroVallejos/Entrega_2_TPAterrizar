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

	public boolean usuarioVIPEstaBuscando() {
		return usuarioBuscando.getClass() == UsuarioVIP.class;
	}

	public double precioAsiento() {
		return precioClaseAsiento() + precioUbicacionAsiento();
	}

	public double impuestoAlPrecioAsiento() {
		return precioAsiento() * Aerolinea.impuesto;
	}

	public double recargoAUsuarioNoEstandar() {
		return AerolineaLanchita.recargoAUsuarioNoEstandar;
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
			return AerolineaLanchita.asientoTurista;
		}
		if (esAsientoEjecutivo()) {
			return AerolineaLanchita.asientoEjecutivo;
		}
		if (esAsientoPrimeraClase()) {
			return AerolineaLanchita.asientoPrimeraClase;
		} else {
			throw new ExcepcionPrecioClaseAsiento();
		}
	}

	public double precioUbicacionAsiento() {
		if (esAsientoVentanilla()) {
			return AerolineaLanchita.asientoVentanilla;
		}
		if (esAsientoCentro()) {
			return AerolineaLanchita.asientoCentro;
		}
		if (esAsientoPasillo()) {
			return AerolineaLanchita.asientoPasillo;
		} else {
			throw new ExcepcionPrecioUbicacionAsiento();
		}
	}

	public boolean esAsientoPrimeraClaseYPrecioFinalMenorA8000ParaUsuarioVIP() {
		return usuarioVIPEstaBuscando() && esAsientoPrimeraClase() && Integer.parseInt(precioFinal) < 8000;
	}

	public boolean esAsientoEjecutivoYPrecioFinalMenorA4000ParaUsuarioVIP() {
		return usuarioVIPEstaBuscando() && esAsientoEjecutivo() && Integer.parseInt(precioFinal) < 4000;
	}

	public boolean esSuperOferta() {
		if (esAsientoPrimeraClaseYPrecioFinalMenorA8000ParaUsuarioVIP() || 
			esAsientoEjecutivoYPrecioFinalMenorA4000ParaUsuarioVIP()) {
			return true;
		} else {
			return false;
		}
	}

}
