package Ventanas;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.BD;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaAnterior, ventanaActual;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;
	private JTextField textFieldDNI;


	/**
	 * Create the frame.
	 */
	public VentanaRegistro(JFrame va) {
		//Nos conectamos con la base de datos
		Connection con = BD.initBD("Hotelea.db");
		ventanaActual = this;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panelSur.add(btnRegistrarse);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Introduce tus datos");
		panelNorte.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblDNI = new JLabel("DNI");
		panelCentro.add(lblDNI);
		
		textFieldDNI = new JTextField();
		panelCentro.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
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
		textFieldContrasenia.setColumns(10);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		setVisible(true);
		
		btnRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String erDNI = "[0-9]{8}";
				String dni = textFieldDNI.getText();
				String erNombre = "[A-Za-z]{1,}";
				String nombre = textFieldNombre.getText();
				String erApellidos = "[A-Za-z]{1,}";
				String apellidos = textFieldApellidos.getText();
				String erUsuario = "[A-Za-z0-9]{1,}";
				String usuario = textFieldUsuario.getText();
				String erContrasenia = "[A-Za-z0-9]{1,}";
				String contrasenia = textFieldContrasenia.getText();
				if(Pattern.matches(erDNI, dni)) {
					if(Pattern.matches(erNombre, nombre)) {
						if(Pattern.matches(erApellidos, apellidos)) {
							if(Pattern.matches(erUsuario, usuario)) {
								if(Pattern.matches(erContrasenia, contrasenia)) {
									BD.insertarCliente(con, dni, nombre, apellidos, usuario, contrasenia);
									VentanaInicio vi= new VentanaInicio();
									vi.setVisible(true);
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos(Contraseña - Letras y numeros)", "ERROR", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos(Usuario - Letras y numeros)", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos(Apellidos - Solo letras)", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos(Nombre - Solo letras)", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos(DNI - 8 digitos sin la letra)", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
	}
	
	

}
