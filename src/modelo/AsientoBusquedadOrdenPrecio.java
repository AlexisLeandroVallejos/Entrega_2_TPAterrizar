package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsientoBusquedadOrdenPrecio extends AsientoBusquedaOrden {
	
	private boolean reverso = false;
	
	public AsientoBusquedadOrdenPrecio(boolean reverso)
	{
		super();
		this.reverso = reverso;
	}

	public AsientoBusquedadOrdenPrecio() 
	{
		super();
	}
	
	public  List<Asiento> ordenarListaSegunCriterio(List<Asiento> listaAOrdenar)
	{
		//convertir Enum a Clase
		if(reverso) {
			listaAOrdenar = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPrecio))
			  .collect(Collectors.toList());
		}
		else{
			listaAOrdenar = listaAOrdenar.stream().sorted(Comparator.comparing(Asiento::getPrecio).reversed())
			  .collect(Collectors.toList());
				
		}
		return listaAOrdenar;
	}
}
