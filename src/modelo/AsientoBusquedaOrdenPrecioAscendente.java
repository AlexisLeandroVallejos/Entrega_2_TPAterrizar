package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsientoBusquedaOrdenPrecioAscendente extends AsientoBusquedaOrden {
	
	public AsientoBusquedaOrdenPrecioAscendente() 
	{
		super();
	}
	
	public List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar) {
		listaAOrdenar = listaAOrdenar.stream()
				.sorted(Comparator.comparing(Asiento::getPrecio).reversed())
				.collect(Collectors.toList());
		return listaAOrdenar;
	}

}
