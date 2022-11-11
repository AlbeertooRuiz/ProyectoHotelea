package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaAnterior, ventanaActual;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;


	/**
	 * Create the frame.
	 */
	public VentanaRegistro(JFrame va) {
		ventanaActual = this;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		panelSur.add(btnRegistrarse);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Introduce tus datos");
		panelNorte.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panelCentro.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panelCentro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panelCentro.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		panelCentro.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		panelCentro.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		panelCentro.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		panelCentro.add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		panelCentro.add(textFieldContrasenia);
		textFieldcontrasenia.setColumns(10);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		setVisible(true);
		
		btnRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String erNombre = "[A-Z][a-z]{1,}";
				String nombre = textFieldNombre.getText();
				if(Pattern.matches(erNombre, nombre)) {
					VentanaInicio vi= new VentanaInicio();
					vi.setVisible(true);
					dispose();
				}
			}
			
		});
	}
	
	

}
