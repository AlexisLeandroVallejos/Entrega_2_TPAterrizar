package modelo;

public abstract class OceanicCriterioCompraOReserva {
	protected String dni;
	protected String codigoDeVuelo;
	protected Integer numeroDeAsiento;
	
	public OceanicCriterioCompraOReserva(String codigoDeVuelo, Integer numeroDeAsiento) {
		this.codigoDeVuelo = codigoDeVuelo;
		this.numeroDeAsiento = numeroDeAsiento;
	}

	
	public OceanicCriterioCompraOReserva(String dni, String codigoDeVuelo, Integer numeroDeAsiento) {
		this.dni = dni;
		this.codigoDeVuelo = codigoDeVuelo;
		this.numeroDeAsiento = numeroDeAsiento;
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
