package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsientoBusquedaOrdenDuracion extends AsientoBusquedaOrden {

	public AsientoBusquedaOrdenDuracion() 
	{
		super();
	}
	
	public  List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar)
	{
		listaAOrdenar  = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::duracionVuelo))
				  .collect(Collectors.toList());
		return listaAOrdenar;
	}
}
