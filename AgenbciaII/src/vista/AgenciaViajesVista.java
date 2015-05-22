package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import controlador.ControlarContrato;
import controlador.ControlarLista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class AgenciaViajesVista {

	private JFrame frame;
	private JTextField textFieldPersonas;
	private JTextField txtNif;
	private ControlarLista controlador;
	ControlarContrato contratar;
	JLabel lblRuta;
	JTextArea textAreaDescripcion;
	private JLabel lblCiudad;
	private JLabel lblDuracion;
	private JLabel lblPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgenciaViajesVista window = new AgenciaViajesVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgenciaViajesVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblViajesLatour = new JLabel("Viajes LaTour");
		lblViajesLatour.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblViajesLatour.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblViajesLatour, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setAlignmentX(2.0f);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 1, 1));
		
		JLabel lblNewLabel_2 = new JLabel("Ruta");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		 lblRuta = new JLabel(" ");
		lblRuta.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblRuta);
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Final");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		lblCiudad = new JLabel("");
		lblCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblCiudad);
		
		JLabel lblNewLabel_4 = new JLabel("Duracion");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);
		
		lblDuracion = new JLabel(" ");
		lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblDuracion);
		
		JLabel lblNewLabel_6 = new JLabel("Descripci\u00F3n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel_4.add(lblNewLabel_5);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.escribirCampos(lblRuta, lblCiudad, lblDuracion, textAreaDescripcion);
			}
		});
		panel_4.add(btnSiguiente);
		
		JButton btnSalir = new JButton("Final");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.iniciarLista();
				controlador.escribirCampos(lblRuta, lblCiudad, lblDuracion, textAreaDescripcion);
			}
		});
		panel_4.add(btnSalir);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setLineWrap(true);
		panel_3.add(textAreaDescripcion);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("Contrataci\u00F3n");
		panel_6.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblPersonas = new JLabel("Personas");
		panel_5.add(lblPersonas);
		
		textFieldPersonas = new JTextField();
		panel_5.add(textFieldPersonas);
		textFieldPersonas.setColumns(2);
		
		JLabel lblnoTener = new JLabel("Precio");
		panel_5.add(lblnoTener);
		
		lblPrecio = new JLabel(" ");
		panel_5.add(lblPrecio);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				int valor;				
				if(!textFieldPersonas.getText().equals(""))
					try {
						valor=Integer.parseInt(textFieldPersonas.getText());					
						lblPrecio.setText(Float.toString(contratar.calcularTotal(valor, controlador.getPrecioActual())));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
					}
			}
		});
		panel_5.add(btnCalcular);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel lblNif = new JLabel("NIF");
		panel_7.add(lblNif);
		
		txtNif = new JTextField();
		panel_7.add(txtNif);
		txtNif.setColumns(10);
		
		JButton btnContratar = new JButton("Contratar");
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtNif.getText().equals("")&&!textFieldPersonas.getText().equals("")){
					contratar.almacenarContrato(txtNif.getText(), lblRuta.getText(), Integer.parseInt(textFieldPersonas.getText()));
					try {			
						lblPrecio.setText(Float.toString(contratar.calcularTotal(Integer.parseInt(textFieldPersonas.getText()), controlador.getPrecioActual())));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
					}
				}
					
			}
		});
		panel_7.add(btnContratar);
		controlador=new ControlarLista();
		controlador.escribirCampos(lblRuta, lblCiudad, lblDuracion, textAreaDescripcion);
		contratar=new ControlarContrato();
		
	}

}
