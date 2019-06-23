package modelo;

public class OceanicCriterioDeCompra {
	private int dni;
	private String codigoDeVuelo;
	private Integer numeroDeAsiento;

	public OceanicCriterioDeCompra(int dni, String codigoDeVuelo, Integer numeroDeAsiento) {
		this.dni = dni;
		this.codigoDeVuelo = codigoDeVuelo;
		this.numeroDeAsiento = numeroDeAsiento;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCodigoDeVuelo() {
		return codigoDeVuelo;
	}

	public void setCodigoDeVuelo(String codigoVuelo) {
		this.codigoDeVuelo = codigoVuelo;
	}

	public Integer getNumeroDeAsiento() {
		return numeroDeAsiento;
	}

	public void setNumeroDeAsiento(Integer numeroDeAsiento) {
		this.numeroDeAsiento = numeroDeAsiento;
	}

}