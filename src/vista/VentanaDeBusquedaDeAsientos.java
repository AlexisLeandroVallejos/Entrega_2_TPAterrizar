package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.AerolineaController;
import modelo.Usuario;
import viewmodel.BusquedaViewTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDeBusquedaDeAsientos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2991103238308943665L;
	private JPanel contentPane;
	private JTextField textFieldOrigen;
	private JTextField textFieldFecha;
	private JTextField textFieldDestino;
	private JLabel lblError1;
	private JLabel lblError2;
	private JLabel lblError3;
	private JTable tableAsientos;
	private Usuario controller;
	private controllerAerolinea controllerAero;

	/**
	 * Create the frame.
	 */
	public VentanaDeBusquedaDeAsientos(Usuario model) {
		controller = model;
		//setTitle(controller.getNombreAplicacion());
		setBounds(100, 100, 449, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblError1 = new JLabel("");
		lblError1.setForeground(Color.RED);
		lblError1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblError1.setBounds(10, 11, 402, 22);
		contentPane.add(lblError1);

		lblError2 = new JLabel("");
		lblError2.setForeground(Color.RED);
		lblError2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblError2.setBounds(10, 43, 402, 22);
		contentPane.add(lblError2);
		
		lblError3 = new JLabel("");
		lblError3.setForeground(Color.RED);
		lblError3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblError3.setBounds(10, 69, 402, 22);
		contentPane.add(lblError3);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 102, 60, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 135, 60, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Destino");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 168, 60, 22);
		contentPane.add(lblNewLabel_2);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(64, 105, 360, 20);
		contentPane.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(64, 138, 360, 20);
		contentPane.add(textFieldFecha);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setColumns(10);
		textFieldDestino.setBounds(64, 168, 360, 20);
		contentPane.add(textFieldDestino);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TO DO: Agregar buscar
				String origen = textFieldOrigen.getText();
				String destino = textFieldDestino.getText();
				String fecha = textFieldFecha.getText();
				if(validarBusqueda(origen, destino, fecha))
				{
					TableModel tm = controllerAero.buscar(origen, destino, fecha);
					tableAsientos.setModel(tm);
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(10, 212, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controller.getAsientoElegido() == null) {
					model.getUser().comprar(controller.getAsientoElegido().getCodigoDeAsiento());
				}
			}
		});
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprar.setBounds(10, 420, 89, 23);
		contentPane.add(btnComprar);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controller.getAsientoElegido() == null) {
					//eliminar el codigo de asiento y pasarle directamente el asiento eleigo a reservar
					model.getUser().reservar(controller.getAsientoElegido().getCodigoDeAsiento());
				}
			}
		});
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservar.setBounds(109, 422, 89, 23);
		contentPane.add(btnReservar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(335, 420, 89, 23);
		contentPane.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 414, 153);
		contentPane.add(scrollPane);
		
		tableAsientos = new JTable();
		scrollPane.setViewportView(tableAsientos);
		
		
		//corregir comprando con el ejemplo de codigo de tefi
		tableAsientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAsientos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent event)
			{
				
					BusquedaViewTableModel tablem = (BusquedaViewTableModel)tableAsientos.getModel();
					//Se setea el asiento elegido en model
					controller.setAsientoElegido(tablem.getAsientoEnFila(event.getFirstIndex()));
			}
		}
		);
	}
	//meterlo en el modelo
	private boolean validarBusqueda(String origen, String destino, String fecha)
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
}
