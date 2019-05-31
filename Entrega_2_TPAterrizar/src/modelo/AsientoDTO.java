package modelo;

public class AsientoDTO {

	private String codigoDeVuelo;
	private Integer numeroDeAsiento;
	private String fechaDeSalida;
	private String horaDeSalida;
	private double precio;
	private Clase claseAsiento;
	private Ubicacion ubicacionAsiento;

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

}
