package controller;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Aerolinea;
import modelo.UsuarioEstandar;

public class AerolineaController {

	private Aerolinea aero;
	
	private UsuarioEstandar user = new UsuarioEstandar("Tomas", "Perez", 2345677, new Aerolinea());
	
	public void AerolineaController()
	{
		aero = new Aerolinea();
	}

	
	public UsuarioEstandar getUser() {
		return user;
	}


	public void setUser(UsuarioEstandar user) {
		this.user = user;
	}


	public Aerolinea getAero() {
		return aero;
	}


	public TableModel getCompras() {
		DefaultTableModel tm = new DefaultTableModel();
		//conseguir lista
		this.getListas();
		//traigo las compras
		
		tm = this.getColumnasListas();
		
		tm.addRow(new Object[] {"1","2","3","4","5"});
		tm.addRow(new Object[] {"2","2","3","4","5"});
		tm.addRow(new Object[] {"3","2","3","4","5"});
		
		// TODO Auto-generated method stub
		return (TableModel)tm;
	}

	public TableModel getReservas() {
		DefaultTableModel tm = new DefaultTableModel();
		//traigo la lista.
		this.getListas();
		//obtengo las reservas
		tm = this.getColumnasListas();
		
		tm.addRow(new Object[] {"1","2","3","4","5"});
		tm.addRow(new Object[] {"2","2","3","4","5"});
		tm.addRow(new Object[] {"3","2","3","4","5"});
		
		// TODO Auto-generated method stub
		return (TableModel)tm;
	}

	public void getListas()
	{
		
	}

	

	private DefaultTableModel getColumnasListas() {

		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Salida"); 
		tm.addColumn("Aerolinea");
		tm.addColumn("Vuelo");
		tm.addColumn("Asiento");
		tm.addColumn("Precio");
		return tm;
	}

	

	public TableModel buscar() {

		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Aerolinea");
		tm.addColumn("Vuelo");
		tm.addColumn("Asiento");
		tm.addColumn("Precio");
		tm.addColumn("Ubicacion"); 
		tm.addColumn("Clase");
		return tm;
		// TODO Auto-generated method stub
	}


	public void setVueloElegido() {
		// TODO Auto-generated method stub
		
	}
}
