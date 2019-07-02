package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsientoBusquedaOrdenPopularidad {
	public AsientoBusquedaOrdenPopularidad() 
	{
		super();
	}
	
	public  List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar)
	{
		//convertir Enum a Clase
		listaAOrdenar = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPopularidadVuelo))
				  .collect(Collectors.toList());
		return listaAOrdenar;
	}
}
