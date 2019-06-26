package viewmodel;

import java.util.List;

import javax.swing.table.TableModel;

import modelo.Asiento;
import modelo.Usuario;

public class UsuarioViewModel {

	public TableModel getReservaOCompra(Usuario user, Consulta consulta) {
		List<Asiento> listaDeCompraOReserva;
		if(consulta.getDescripcion() == "Compras"){
			listaDeCompraOReserva = user.getAsientosComprados();
		}else{
			listaDeCompraOReserva = user.getAsientosReservados();
		}
		ComprasViewTableModel tm = new ComprasViewTableModel(listaDeCompraOReserva);
		return (TableModel)tm;
	}
}
