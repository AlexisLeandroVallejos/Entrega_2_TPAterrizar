package modelo;

import java.util.List;


public abstract class AsientoBusquedaOrden {
	//PRECIOA, PRECIOD, TIEMPOVUELO, POPULARIDAD;

	private String descripcion;

	public AsientoBusquedaOrden()
	{}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public abstract List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar);

}