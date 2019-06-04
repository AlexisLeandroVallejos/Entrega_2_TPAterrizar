package modelo;

public class AsientoDTO {

	private String codigoDeVuelo;
	private Integer numeroDeAsiento;
	private String fechaDeSalida; // dd/MM/yyyy
	private String horaDeSalida; // HH:mm
	private double precio;
	private Clase claseAsiento;
	private Ubicacion ubicacionAsiento;
	private boolean reservado = false;
	private boolean comprado = false;

	public AsientoDTO(String codigoDeVuelo, Integer numeroDeAsiento, String fechaDeSalida, 
			String horaDeSalida, double precio, Clase claseAsiento, Ubicacion ubicacionAsiento) {
		this.codigoDeVuelo = codigoDeVuelo;
		this.numeroDeAsiento = numeroDeAsiento;
		this.fechaDeSalida = fechaDeSalida;
		this.horaDeSalida = horaDeSalida;
		this.precio = precio;
		this.claseAsiento = claseAsiento;
		this.ubicacionAsiento = ubicacionAsiento;
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

}
