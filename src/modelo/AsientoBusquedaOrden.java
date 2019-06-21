package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum AsientoBusquedaOrden {
	PRECIOA, PRECIOD, TIEMPOVUELO, POPULARIDAD;

	private String descripcion;

	static {
		PRECIOA.descripcion = "Precio Asc";
		PRECIOD.descripcion = "Precio Desc";
		TIEMPOVUELO.descripcion = "Tiempo Vuelo";
		POPULARIDAD.descripcion = "Popularidad";
	}

	
	public String getDescripcion() {
		return descripcion;
	}
	
	public  List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar)
	{
		//convertir Enum a Clase
		switch(descripcion)
		{
			case "Precio Asc":
				listaAOrdenar = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPrecio))
				  .collect(Collectors.toList());
				break;
			case "Precio Desc":
				listaAOrdenar = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPrecio).reversed())
				  .collect(Collectors.toList());
				break;
			case "Tiempo Vuelo":
				listaAOrdenar  = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::duracionVuelo))
				  .collect(Collectors.toList());
				break;
			case "Popularidad":
				listaAOrdenar = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPopularidadVuelo))
				  .collect(Collectors.toList());
				break;
		}
		return listaAOrdenar;
	}

}