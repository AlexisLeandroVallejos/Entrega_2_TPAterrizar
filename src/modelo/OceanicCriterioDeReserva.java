package modelo;

public class OceanicCriterioDeReserva extends OceanicCriterioCompraOReserva {

	public OceanicCriterioDeReserva(String codigoDeVuelo, Integer numeroDeAsiento) {
		super(codigoDeVuelo,numeroDeAsiento);
	}

	public OceanicCriterioDeReserva(String dni, String codigoDeVuelo, Integer numeroDeAsiento) {
		super(codigoDeVuelo,numeroDeAsiento);
		this.dni = dni;
	}

}
