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

public class VentanaDeAvisoSobreReserva extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeAvisoSobreReserva frame = new VentanaDeAvisoSobreReserva();
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
	public VentanaDeAvisoSobreReserva() {
		setTitle("Aterrizar.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("New label");
		lblAviso.setVerticalAlignment(SwingConstants.TOP);
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAviso.setBounds(10, 11, 386, 71);
		contentPane.add(lblAviso);
		
		JButton btnSobreReservar = new JButton("Sobre-Reservar");
		btnSobreReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSobreReservar.setBounds(10, 93, 127, 23);
		contentPane.add(btnSobreReservar);
		
		JButton btnSeguirBuscando = new JButton("Seguir Buscando");
		btnSeguirBuscando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeguirBuscando.setBounds(147, 93, 151, 23);
		contentPane.add(btnSeguirBuscando);
	}

}
