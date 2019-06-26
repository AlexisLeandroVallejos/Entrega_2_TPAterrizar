package viewmodel;

import java.util.List;

import javax.swing.table.TableModel;

import modelo.Asiento;
import modelo.Usuario;

public class UsuarioViewModel {

	public TableModel getReservas(Usuario user) {
		List<Asiento> reservas = user.getAsientosReservados();
		ComprasViewTableModel tm = new ComprasViewTableModel(reservas);
		return (TableModel)tm;
	}

	public TableModel getCompras(Usuario user) {
		List<Asiento> compras = user.getAsientosComprados();
		ComprasViewTableModel tm = new ComprasViewTableModel(compras);
		return (TableModel)tm;
	}

}
