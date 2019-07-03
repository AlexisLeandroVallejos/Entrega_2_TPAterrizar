package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.mockito.Mockito;

import modelo.AterrizarTramitesDeAsientos;
import modelo.Asiento;
import modelo.AsientoDTO;
import modelo.Clase;
import modelo.Oceanic;
import modelo.Ubicacion;
import modelo.UsuarioEstandar;
import viewmodel.ComprasViewTableModel;

public class AterrizarTramitesDeAsientosController {

	//SEPARAR LOS METODOS DE LAS VISTAS
	private AterrizarTramitesDeAsientos aterrizarTramitesDeAsientos;
	
	
	private String nombreAplicacion;
	
	private UsuarioEstandar user;
	
	public AterrizarTramitesDeAsientosController()
	{
		aterrizarTramitesDeAsientos = new AterrizarTramitesDeAsientos();
		this.nombreAplicacion = "Aterrizar.com";
		user = new UsuarioEstandar("Tomas", "Perez", 2345677, new AterrizarTramitesDeAsientos());
	}

	
	public UsuarioEstandar getUser() {
		return user;
	}


	public void setUser(UsuarioEstandar user) {
		this.user = user;
	}


	public AterrizarTramitesDeAsientos getAterrizarTramitesDeAsientos() {
		return aterrizarTramitesDeAsientos;
	}


	public TableModel buscar(String origen, String destino, String fecha) {
		
		List<Asiento> listaBusqueda = aterrizarTramitesDeAsientos.buscarAsientos(origen, fecha, destino);

		ComprasViewTableModel tm = new ComprasViewTableModel(listaBusqueda);
		return tm;
	}


	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

}
