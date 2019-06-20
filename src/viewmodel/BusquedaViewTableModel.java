package viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.Asiento;

public class BusquedaViewTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -370755167944552193L;

	private List<Asiento> asientos = new ArrayList<Asiento>();
	
	private String[] headerColumnas = {"Aerolinea","Vuelo","Asiento","Precio","Ubicacion","Clase"};
	

    public BusquedaViewTableModel(List<Asiento> compras) {
		asientos = compras;
	}

	@Override
    public String getColumnName(int columnIndex){
         return headerColumnas[columnIndex];
    }

    @Override        
    public int getColumnCount() {
        return headerColumnas.length; 
    }

    @Override     
    public int getRowCount() {
        return asientos.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asiento asi = asientos.get(rowIndex);
        HashMap<String, String> datos =  asi.getDatosParaLista();
        return datos.get(this.getColumnName(columnIndex));
   }
    @Override
    public Class<?> getColumnClass(int columnIndex){
           
              return String.class;
       }
}
