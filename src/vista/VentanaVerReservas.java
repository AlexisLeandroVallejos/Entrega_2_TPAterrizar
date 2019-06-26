package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import controller.AerolineaController;
import modelo.Usuario;
import viewmodel.UsuarioViewModel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerReservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5530977666036494116L;
	private JPanel contentPane;
	private JTable table;
	private Usuario user;
	private JFrame VentanaParent;
	private UsuarioViewModel model;
	
	/**
	 * Create the frame.
	 */ 
	public VentanaVerReservas(Usuario user) {
		this.user = user;
		this.model = new UsuarioViewModel();
		//setTitle(controller.getNombreAplicacion());
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(91, 11, 100, 25);
		contentPane.add(lblNombre);
		
		JLabel label = new JLabel("Compras de");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 11, 83, 25);
		contentPane.add(label);
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Salida", "Aerolinea", "Vuelo", "Asiento", "Precio"
			}
		));*/
		
		JButton button = new JButton("Cerrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(10, 227, 100, 23);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 414, 169);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(model.getReservas(user));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
	}

	public JFrame getVentanaParent() {
		return VentanaParent;
	}

	public void setVentanaParent(JFrame ventanaParent) {
		VentanaParent = ventanaParent;
	}
}
