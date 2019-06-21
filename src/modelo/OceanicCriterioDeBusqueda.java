package modelo;

public class OceanicCriterioDeBusqueda {
	private String codigoOrigenOceanic;
	private String fechaSalida;
	private String codigoDestinoOceanic;

	public OceanicCriterioDeBusqueda(String codigoOrigenOceanic, String fechaSalida) {
		this.codigoOrigenOceanic = codigoOrigenOceanic;
		this.fechaSalida = fechaSalida;
	}

	public OceanicCriterioDeBusqueda(String codigoOrigenOceanic, String fechaSalida, String codigoDestinoOceanic) {
		this(codigoOrigenOceanic,fechaSalida);
		this.codigoDestinoOceanic = codigoDestinoOceanic;
	}

	public String getCodigoOrigenOceanic() {
		return codigoOrigenOceanic;
	}

	public void setCodigoOrigenOceanic(String codigoOrigenOceanic) {
		this.codigoOrigenOceanic = codigoOrigenOceanic;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getCodigoDestinoOceanic() {
		return codigoDestinoOceanic;
	}

	public void setCodigoDestinoOceanic(String codigoDestinoOceanic) {
		this.codigoDestinoOceanic = codigoDestinoOceanic;
	}

}