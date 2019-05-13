package modelo;

public class Asiento {
	private final Vuelo vuelo; // Necesita una relacion, "el asiento conoce su vuelo".
	private final String claseAsiento; // T, E, P - No va cambiar una vez que se defina.
	private final String ubicacionAsiento; // V, C, P - ^idem.
	private String estadoAsiento; // D, R - El estado podria cambiar.
	private String codigoDeAsiento; // Se agregara despues en un set... que set mas tramposo.
	
	public Asiento(Vuelo vuelo, String claseAsiento, String ubicacionAsiento, String estadoAsiento) {
		this.vuelo = vuelo;
		this.claseAsiento = claseAsiento;
		this.ubicacionAsiento = ubicacionAsiento;
		this.estadoAsiento = estadoAsiento;
		this.codigoDeAsiento = setCodigoDeAsiento();
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

}
