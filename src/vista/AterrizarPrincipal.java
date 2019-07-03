package vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.UsuarioDataDummy;
import modelo.Usuario;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class AterrizarPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797745868537851156L;
	private JPanel contentPane;
	private Label lblNombreUsuario;
	private Usuario model;
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
		UsuarioDataDummy usuarioDummy = new UsuarioDataDummy();
		setTitle("Aterrizar.com");
		setBounds(100, 100, 416, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Label Hola = new Label("Hola" );
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
				VentanaVerLista ventana = new VentanaVerLista(model);
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
				VentanaVerLista ventanaCompras = new VentanaVerLista(model);
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
		
		lblNombreUsuario = new Label( "Nombre Usuario");
		lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombreUsuario.setBounds(71, 23, 164, 22);
		contentPane.add(lblNombreUsuario);
		

		this.setUser(usuarioDummy.getUsuarioTest());
		
		bBuscarAsientos.addActionListener(new ActionListener()
			{	
				public void actionPerformed(ActionEvent e) {
					VentanaDeBusquedaDeAsientos ventana = new VentanaDeBusquedaDeAsientos(model);
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
	

	public JFrame getFrame()
	{
		return this;
	}
	public void setUser(Usuario user) {
		model = user;
		this.lblNombreUsuario.setText(model.getNombre());
	}
}
