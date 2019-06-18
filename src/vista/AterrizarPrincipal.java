package vista;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AerolineaController;
import modelo.Aerolinea;
import modelo.Usuario;
import modelo.UsuarioEstandar;

import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class AterrizarPrincipal extends JFrame {

	private JPanel contentPane;
	private Label lblNombreUsuario;
	private AerolineaController controller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AterrizarPrincipal frame = new AterrizarPrincipal();
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
	public AterrizarPrincipal() {
		
		controller = new AerolineaController();
		
		setTitle("Aterrizar.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Label Hola = new Label("Hola");
		Hola.setFont(new Font("Arial", Font.PLAIN, 14));
		Hola.setBounds(23, 23, 42, 22);
		contentPane.add(Hola);
		
		
		Label label = new Label("Que desea hacer?");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(23, 59, 164, 22);
		contentPane.add(label);
		
		JButton bReservas = new JButton("Reservas");
		bReservas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bReservas.setBounds(122, 87, 89, 23);
		contentPane.add(bReservas);
		
		bReservas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVerReservas ventana = new VentanaVerReservas(controller);
				ventana.setVisible(true);
				getFrame().setVisible(false);
				ventana.addWindowListener(new VentanaSeCierraListener()
				{
					@Override
					public void windowClosed(WindowEvent e) {
						//TO DO: Terminar la vuelta a la ventana Parent
						getFrame().setVisible(true);
					}
				});
				//mostrar Ventana reserva
			}
		});
		
		
		JButton bCompras = new JButton("Compras");
		bCompras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bCompras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//mostrar Venana compras
				VentanaVerCompras ventanaCompras = new VentanaVerCompras(controller);
				ventanaCompras.setVisible(true);
				//obtengo el la ventana que llama a VerCompras
				ventanaCompras.addWindowListener(new VentanaSeCierraListener()
						{
							@Override
							public void windowClosed(WindowEvent e) {
								//TO DO: Terminar la vuelta a la ventana Parent
								getFrame().setVisible(true);
							}
						});
				getFrame().setVisible(false);
			}
		});
		bCompras.setBounds(23, 87, 89, 23);
		contentPane.add(bCompras);
		
		JButton bBuscarAsientos = new JButton("Buscar Asientos");
		bBuscarAsientos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bBuscarAsientos.setBounds(221, 87, 128, 23);
		contentPane.add(bBuscarAsientos);
		
		lblNombreUsuario = new Label("XXXXXXXXXXX");
		lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombreUsuario.setBounds(71, 23, 164, 22);
		contentPane.add(lblNombreUsuario);
		
		
		bBuscarAsientos.addActionListener(new ActionListener()
			{	
				public void actionPerformed(ActionEvent e) {
					VentanaDeBusquedaDeAsientos ventana = new VentanaDeBusquedaDeAsientos(controller);
					ventana.setVisible(true);
					getFrame().setVisible(false);
					ventana.addWindowListener(new VentanaSeCierraListener()
					{
						@Override
						public void windowClosed(WindowEvent e) {
							//TO DO: Terminar la vuelta a la ventana Parent
							getFrame().setVisible(true);
						}
					});
				}
			}
		);
	}
	

	public UsuarioEstandar getUser() {
		return controller.getUser();
	}

	public JFrame getFrame()
	{
		return this;
	}
	public void setUser(UsuarioEstandar user) {
		this.controller.setUser(user);
		this.lblNombreUsuario.setText(controller.getUser().ToString());
	}
}
