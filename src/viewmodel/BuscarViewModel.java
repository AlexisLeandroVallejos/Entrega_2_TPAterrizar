package viewmodel;

import java.util.List;

import javax.swing.table.TableModel;

import bd.AterrizarTramitesDeAsientosDataDummy;
import modelo.AterrizarTramitesDeAsientos;
import modelo.Asiento;

public class BuscarViewModel {

	private Asiento asientoElegido = null;
	
	public Asiento getAsientoElegido() {
		// TODO Auto-generated method stub
		return asientoElegido;
	}

	public void setAsientoElegido(Asiento asientoElegido) {
		// TODO Auto-generated method stub
		this.asientoElegido = asientoElegido;
	}
	
	public String validarBusqueda(String origen, String destino, String fecha)
	{
		String error = "";
		if(origen.isEmpty())
		{
			error = "Por favor complete el Origen" + "\n";
		}
		if(destino.isEmpty())
		{

			error += "Por favor complete el Destino" + "\n";
		}
		if(fecha.isEmpty())
		{

			error += "Por favor complete la Fecha" + "\n";
		}
		if(!error.isEmpty())
		{
			error = BuscarViewModel.convertToMultiline(error);
		}
		return error;
	}

	public BusquedaViewTableModel buscar(String origen, String destino, String fecha) {

		AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		AterrizarTramitesDeAsientosDataDummy aterrizarTramitesDeAsientosDD = new AterrizarTramitesDeAsientosDataDummy();
		aterrizarTramitesDeAsientos = aterrizarTramitesDeAsientosDD.obtenerAterrizarTramitesDeAsientosTest();
		List<Asiento> listaBusqueda = aterrizarTramitesDeAsientos.buscarAsientos(origen, fecha, destino);
		BusquedaViewTableModel tm = new BusquedaViewTableModel(listaBusqueda);
		return tm;
	}
	
	public static String convertToMultiline(String orig)
	{
	    return "<html>" + orig.replaceAll("\n", "<br>");
	}

	public void Comprar(String codigoDeAsiento) {
		// TODO Auto-generated method stub
		
	}

	public void Reservar(String codigoDeAsiento) {
		// TODO Auto-generated method stub
		
	}
}
