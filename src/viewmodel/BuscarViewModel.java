package viewmodel;

import java.util.List;

import javax.swing.table.TableModel;

import bd.AterrizarTramitesDeAsientosDataDummy;
import modelo.AterrizarTramitesDeAsientos;
import modelo.Usuario;
import modelo.Asiento;

public class BuscarViewModel {

	private Asiento asientoElegido = null;
	AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
	
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
		if(aterrizarTramitesDeAsientos.getVuelos().size() < 1)
		{
			AterrizarTramitesDeAsientosDataDummy aterrizarTramitesDeAsientosDD = new AterrizarTramitesDeAsientosDataDummy();
			aterrizarTramitesDeAsientos = aterrizarTramitesDeAsientosDD.obtenerAterrizarTramitesDeAsientosTest();
		}
		BusquedaViewTableModel tm = null;
		List<Asiento> listaBusqueda = aterrizarTramitesDeAsientos.buscarAsientos(origen, fecha, destino);
		if(listaBusqueda.size() > 0) {
			tm = new BusquedaViewTableModel(listaBusqueda);
		}
		return tm;
	}
	
	public static String convertToMultiline(String orig)
	{
	    return "<html>" + orig.replaceAll("\n", "<br>");
	}

	public String Comprar(Usuario user) {
		// TODO Auto-generated method stub
		try {
			user.comprar((this.asientoElegido));
			return "Compra Exitosa!! </br> Asiento: " + this.asientoElegido.getCodigoDeAsiento();
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}

	public String Reservar(Usuario user) {
		// TODO Auto-generated method stub
		try {
			user.comprar((this.asientoElegido));
			return "Reserva Exitosa!! </br> Asiento: " + this.asientoElegido.getCodigoDeAsiento(); 
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
}
