package modelo;

public class OceanicCriterioDeReserva {
	private String dni;
	private String codigoDeVuelo;
	private Integer numeroDeAsiento;

	public OceanicCriterioDeReserva(String codigoDeVuelo, Integer numeroDeAsiento) {
		this.codigoDeVuelo = codigoDeVuelo;
		this.numeroDeAsiento = numeroDeAsiento;
	}

	public OceanicCriterioDeReserva(String dni, String codigoDeVuelo, Integer numeroDeAsiento) {
		this(codigoDeVuelo, numeroDeAsiento);
		this.dni = dni;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigoDeVuelo() {
		return codigoDeVuelo;
	}

	public void setCodigoDeVuelo(String codigoDeVuelo) {
		this.codigoDeVuelo = codigoDeVuelo;
	}

	public Integer getNumeroDeAsiento() {
		return numeroDeAsiento;
	}

	public void setNumeroDeAsiento(Integer numeroDeAsiento) {
		this.numeroDeAsiento = numeroDeAsiento;
	}


}
