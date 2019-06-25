package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import controller.AerolineaController;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerCompras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6217215503784595974L;
	private JPanel contentPane;
	private JTable table;
	private AerolineaController controller;
	
	/**
	 * Create the frame.
	 */
	public VentanaVerCompras(AerolineaController aero) {
		this.controller = aero;
		setTitle(controller.getNombreAplicacion());
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 414, 170);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(controller.getCompras());
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		JButton bCerrar = new JButton("Cerrar");
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bCerrar.setBounds(10, 227, 100, 23);
		contentPane.add(bCerrar);
	}

}
