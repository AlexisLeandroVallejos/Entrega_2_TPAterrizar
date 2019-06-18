package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaDeBusquedaDeAsientos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOrigen;
	private JTextField textFieldFecha;
	private JTextField textFieldDestino;
	private JTable tableAsientos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeBusquedaDeAsientos frame = new VentanaDeBusquedaDeAsientos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDeBusquedaDeAsientos() {
		setTitle("Aterrizar.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblError = new JLabel("Error");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblError.setBounds(10, 11, 414, 80);
		contentPane.add(lblError);
		
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
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(10, 212, 89, 23);
		contentPane.add(btnBuscar);
		
		tableAsientos = new JTable();
		tableAsientos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Aerolinea", "Vuelo", "Asiento", "Ubicacion", "Precio"
			}
		));
		tableAsientos.setBounds(10, 246, 414, 152);
		contentPane.add(tableAsientos);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprar.setBounds(10, 420, 89, 23);
		contentPane.add(btnComprar);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservar.setBounds(109, 422, 89, 23);
		contentPane.add(btnReservar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(335, 420, 89, 23);
		contentPane.add(btnCerrar);
	}
}
