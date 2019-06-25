package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.mockito.Mockito;

import modelo.Aerolinea;
import modelo.Asiento;
import modelo.AsientoDTO;
import modelo.Clase;
import modelo.Oceanic;
import modelo.Ubicacion;
import modelo.UsuarioEstandar;
import viewmodel.ComprasViewTableModel;

public class AerolineaController {

	private Aerolinea aero;
	
	private UsuarioEstandar user = new UsuarioEstandar("Tomas", "Perez", 2345677, new Aerolinea());
	
	public AerolineaController()
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
		List<Asiento> compras = aero.getCompras(user);
		

		//agrego asiento a mano para TEST
		Integer numeroDeAsiento = 12;
		String fechaSalida = "09/05/2010";
		String codigoVuelo = "LAR";
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoVuelo, numeroDeAsiento, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		
		compras.add(asiento1);
		
		
		ComprasViewTableModel tm = new ComprasViewTableModel(compras);
		
		return (TableModel)tm;
	}

	public TableModel getReservas() {
		
		
		List<Asiento> reservas = aero.getReservas(user);
		
		//agrego asiento a mano para TEST
		Integer numeroDeAsiento = 12;
		String fechaSalida = "09/05/2010";
		String codigoVuelo = "LAR";
		//asientos:
		AsientoDTO asiento1 = new AsientoDTO(codigoVuelo, numeroDeAsiento, fechaSalida, "15:15", 245.45, Clase.TURISTA, Ubicacion.VENTANA);
		
		reservas.add(asiento1);
		
		ComprasViewTableModel tm = new ComprasViewTableModel(reservas);
		
		return (TableModel)tm;
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


	public TableModel buscar(String origen, String destino, String fecha) {
		DefaultTableModel tm = new DefaultTableModel();
		
		tm.addColumn("Aerolinea");
		tm.addColumn("Vuelo");
		tm.addColumn("Asiento");
		tm.addColumn("Precio");
		tm.addColumn("Ubicacion"); 
		tm.addColumn("Clase");
		
		List<Asiento> listaBusqueda = aero.buscarAsientos(origen, fecha, destino);
		
		return tm;
	}
}
