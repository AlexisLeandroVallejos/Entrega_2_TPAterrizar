package viewmodel;

import javax.swing.table.TableModel;

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
	
	public boolean validarBusqueda(String origen, String destino, String fecha)
	{
		lblError1.setText("");
		lblError2.setText("");
		lblError3.setText("");
		if(origen.isEmpty())
		{
			lblError1.setText("Por favor complete el Origen" + "\n");
		}
		if(destino.isEmpty())
		{

			lblError2.setText(lblError2.getText() + "Por favor complete el Destino" + "\n");
		}
		if(fecha.isEmpty())
		{

			lblError3.setText(lblError3.getText() + "Por favor complete la Fecha" + "\n");
		}
		
		return lblError1.getText().isEmpty() && lblError2.getText().isEmpty() && lblError3.getText().isEmpty();
	}

	public TableModel buscar(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}
}
