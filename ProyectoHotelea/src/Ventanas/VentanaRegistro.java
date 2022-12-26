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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JFrame ventanaAnterior, ventanaActual;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;
	private JTextField textFieldDNI;
	Connection con;


	/**
	 * Create the frame.
	 */
	public VentanaRegistro(JFrame va) {
		ventanaActual = this;
		ventanaActual.setBounds(100, 100, 550, 550);
		ventanaActual.getContentPane().setLayout(new BorderLayout());
		ventanaActual.setLocationRelativeTo(null);
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panelSur.add(btnRegistrarse);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				ventanaActual.dispose();
			}
		});
		panelSur.add(btnVolver);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Introduce tus datos");
		panelNorte.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{253, 82, 0};
		gbl_panelCentro.rowHeights = new int[]{89, 89, 89, 89, 89, 0};
		gbl_panelCentro.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JLabel lblDNI = new JLabel("DNI (sin letra)");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.fill = GridBagConstraints.VERTICAL;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 0;
		panelCentro.add(lblDNI, gbc_lblDNI);
		
		textFieldDNI = new JTextField();
		textFieldDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char teclapresionada=arg0.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnRegistrarse.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldDNI = new GridBagConstraints();
		gbc_textFieldDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDNI.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDNI.gridx = 1;
		gbc_textFieldDNI.gridy = 0;
		panelCentro.add(textFieldDNI, gbc_textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panelCentro.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnRegistrarse.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		panelCentro.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.fill = GridBagConstraints.VERTICAL;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 2;
		panelCentro.add(lblApellidos, gbc_lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnRegistrarse.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellidos.gridx = 1;
		gbc_textFieldApellidos.gridy = 2;
		panelCentro.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 3;
		panelCentro.add(lblUsuario, gbc_lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnRegistrarse.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUsuario.gridx = 1;
		gbc_textFieldUsuario.gridy = 3;
		panelCentro.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasenia = new GridBagConstraints();
		gbc_lblContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblContrasenia.fill = GridBagConstraints.VERTICAL;
		gbc_lblContrasenia.insets = new Insets(0, 0, 0, 5);
		gbc_lblContrasenia.gridx = 0;
		gbc_lblContrasenia.gridy = 4;
		panelCentro.add(lblContrasenia, gbc_lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnRegistrarse.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldContrasenia = new GridBagConstraints();
		gbc_textFieldContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContrasenia.gridx = 1;
		gbc_textFieldContrasenia.gridy = 4;
		panelCentro.add(textFieldContrasenia, gbc_textFieldContrasenia);
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
									//Nos conectamos con la base de datos
									Connection con = BD.initBD("Hotelea.db");
									BD.insertarCliente(con, dni, nombre, apellidos, usuario, contrasenia);
									BD.closeBD(con);
									VentanaInicio vi= new VentanaInicio();
									vi.setVisible(true);
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos(Contrase�a - Letras y numeros)", "ERROR", JOptionPane.ERROR_MESSAGE);
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
