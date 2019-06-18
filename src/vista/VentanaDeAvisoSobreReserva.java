package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDeAvisoSobreReserva extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 949874357123761087L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaDeAvisoSobreReserva() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Aterrizar.com");
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
		btnSeguirBuscando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSeguirBuscando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeguirBuscando.setBounds(147, 93, 151, 23);
		contentPane.add(btnSeguirBuscando);
	}

}
