package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDeAviso extends JDialog {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaDeAviso() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Aterrizar.com");
		setBounds(100, 100, 456, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("New label");
		lblAviso.setVerticalAlignment(SwingConstants.TOP);
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAviso.setBounds(10, 11, 386, 71);
		contentPane.add(lblAviso);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(10, 93, 89, 23);
		contentPane.add(btnAceptar);
	}

}
