package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AaterrizarPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AaterrizarPrincipal frame = new AaterrizarPrincipal();
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
	public AaterrizarPrincipal() {
		setTitle("Aterrizar.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label Hola = new Label("Hola");
		Hola.setFont(new Font("Arial", Font.PLAIN, 14));
		Hola.setBounds(23, 23, 62, 22);
		contentPane.add(Hola);
		
		Label nombreUsuario = new Label("");
		nombreUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		nombreUsuario.setBounds(55, 23, 137, 22);
		contentPane.add(nombreUsuario);
		
		Label label = new Label("Que desea hacer?");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(23, 59, 164, 22);
		contentPane.add(label);
		
		JButton bReservas = new JButton("Reservas");
		bReservas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bReservas.setBounds(122, 87, 89, 23);
		contentPane.add(bReservas);
		
		JButton bCompras = new JButton("Compras");
		bCompras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bCompras.setBounds(23, 87, 89, 23);
		contentPane.add(bCompras);
		
		JButton bBuscarAsientos = new JButton("Buscar Asientos");
		bBuscarAsientos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bBuscarAsientos.setBounds(221, 87, 128, 23);
		contentPane.add(bBuscarAsientos);
	}
}
