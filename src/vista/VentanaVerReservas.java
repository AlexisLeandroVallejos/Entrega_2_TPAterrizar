package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class VentanaVerReservas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerReservas frame = new VentanaVerReservas();
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
	public VentanaVerReservas() {
		setTitle("Aterrizar.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReservasDe = new JLabel("Reservas de");
		lblReservasDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReservasDe.setBounds(10, 11, 83, 25);
		contentPane.add(lblReservasDe);
		
		JLabel lvlNombre = new JLabel("");
		lvlNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lvlNombre.setBounds(91, 11, 100, 25);
		contentPane.add(lvlNombre);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Salida", "Aerolinea", "Vuelo", "Asiento", "Precio"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 69, 414, 181);
		contentPane.add(table);
	}

}
