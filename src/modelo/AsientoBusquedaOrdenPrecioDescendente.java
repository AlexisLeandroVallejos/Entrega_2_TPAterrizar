package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsientoBusquedaOrdenPrecioDescendente extends AsientoBusquedaOrden {

	public AsientoBusquedaOrdenPrecioDescendente() 
	{
		super();
	}
	
	public List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar)
	{
		listaAOrdenar = listaAOrdenar.stream()
				.sorted(Comparator.comparing(Asiento::getPrecio))
				.collect(Collectors.toList());
		return listaAOrdenar;
	}
}
