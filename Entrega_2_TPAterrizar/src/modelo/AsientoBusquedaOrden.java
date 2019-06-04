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
	
	public  List<Asiento> Orden(List<Asiento> listaAOrdenar)
	{
		switch(descripcion)
		{
		case "Precio Asc":
			listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPrecioFinal))
			  .collect(Collectors.toList());
			break;
		case "Precio Desc":
			listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPrecioFinal).reversed())
			  .collect(Collectors.toList());
			break;
		case "Tiempo Vuelo":
			listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::duracionVuelo))
			  .collect(Collectors.toList());
			break;
		case "Popularidad":
			listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPopularidadVuelo))
			  .collect(Collectors.toList());
			break;
		}
		return listaAOrdenar;
	}

}