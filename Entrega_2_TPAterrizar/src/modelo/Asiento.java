package modelo;

public class Asiento {
	private final Vuelo vuelo; // Necesita una relacion, "el asiento conoce su vuelo".
	private String valor; //se calcula segun lo que la empresa disponga junto con las caracteristicas del mismo
	private final String claseAsiento; // T, E, P - No va cambiar una vez que se defina.
	private final String ubicacionAsiento; // V, C, P - ^idem.
	private String estadoAsiento; // D, R - El estado podria cambiar.
	private String codigoDeAsiento; // Se agregara despues en un set... que set mas tramposo.
	
	public Asiento(Vuelo vuelo, String valor, String claseAsiento, String ubicacionAsiento, String estadoAsiento) {
		this.vuelo = vuelo;
		this.claseAsiento = claseAsiento;
		this.valor = valor;
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
	
	public boolean esSuperOferta(float costoTotal) {
		if(claseAsiento == "P" && costoTotal < 8000){
			return true;
		}
		if (claseAsiento == "E" && costoTotal < 4000) {
			return true;
		}
		else{
			return false;
		}
	}
	
}
