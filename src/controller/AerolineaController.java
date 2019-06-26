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

	//SEPARAR LOS METODOS DE LAS VISTAS
	private Aerolinea aero;
	
	
	private String nombreAplicacion;
	
	private UsuarioEstandar user;
	
	public AerolineaController()
	{
		aero = new Aerolinea();
		this.nombreAplicacion = "Aterrizar.com";
		user = new UsuarioEstandar("Tomas", "Perez", 2345677, new Aerolinea());
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


	public TableModel buscar(String origen, String destino, String fecha) {
		
		List<Asiento> listaBusqueda = aero.buscarAsientos(origen, fecha, destino);

		ComprasViewTableModel tm = new ComprasViewTableModel(listaBusqueda);
		return tm;
	}


	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

}
