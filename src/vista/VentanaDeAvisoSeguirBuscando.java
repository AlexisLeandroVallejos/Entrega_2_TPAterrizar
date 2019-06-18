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

public class VentanaDeAvisoSeguirBuscando extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeAvisoSeguirBuscando frame = new VentanaDeAvisoSeguirBuscando();
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
	public VentanaDeAvisoSeguirBuscando() {
		setTitle("Aterrizar.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("New label");
		lblAviso.setVerticalAlignment(SwingConstants.TOP);
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAviso.setBounds(10, 11, 386, 71);
		contentPane.add(lblAviso);
		
		JButton btnSeguirBuscando = new JButton("Seguir Buscando");
		btnSeguirBuscando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeguirBuscando.setBounds(10, 93, 173, 23);
		contentPane.add(btnSeguirBuscando);
	}

}
