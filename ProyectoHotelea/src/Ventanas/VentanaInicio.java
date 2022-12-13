package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Datos.BD;
import Datos.Cliente;
import Datos.Hotel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaInicio extends JFrame {

	private JFrame ventanaActual;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldContrasenia;
	private JPanel panelNorte, panelSur, panelEste, panelOeste, panelCentro, panelArriba, panelAbajo;
	Connection con;
	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		ventanaActual = this;
		ventanaActual.setBounds(100, 100, 550, 550);
		ventanaActual.getContentPane().setLayout(new BorderLayout());
		ventanaActual.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Conexion con la base de datos
		con = BD.initBD("Hotelea.db");
		//Crear las tablas si no existen
		BD.crearTablaCliente(con);
		BD.crearTablaHotel(con);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = textFieldUsuario.getText();
				String c = textFieldContrasenia.getText();
				Cliente cliente = BD.obtenerDatosCliente(con, u);
				if(u.equals("admin") && c.equals("hotelea")) {
					VentanaAdministrador va=new VentanaAdministrador() ;
					va.setVisible(true);
					dispose();
				}else if(cliente == null) {
					JOptionPane.showMessageDialog(null, "El nombre de usuario no es correcto");
				}else if(!cliente.getContrasenia().equals(c)) {
					JOptionPane.showMessageDialog(null, "La contrase�a no es correcta");
				}else {
					BD.closeBD(con);
					JOptionPane.showMessageDialog(null, "Bienvenido/a!!");
					VentanaUsuario vu= new VentanaUsuario();
					vu.setVisible(true);
					dispose();
				}
			}
		});
		
		JLabel lblRegistro = new JLabel("\u00BFNo tienes cuenta?");
		
		JButton btnNewButton = new JButton("\u00A1Registrate!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaRegistro(ventanaActual);
				ventanaActual.setVisible(false);
			}
		});
		
		panelArriba = new JPanel();
		panelArriba.add(btnIniciarSesion);
		
		panelSur.add(panelArriba);
		
		panelAbajo = new JPanel();
		panelAbajo.add(lblRegistro);
		panelAbajo.add(btnNewButton);
		
		panelSur.add(panelAbajo);
		
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{155, 80, 80, -45, 155, 0};
		gbl_panelCentro.rowHeights = new int[]{206, 206, 0};
		gbl_panelCentro.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 0;
		panelCentro.add(lblUsuario, gbc_lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnIniciarSesion.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.gridx = 2;
		gbc_textFieldUsuario.gridy = 0;
		panelCentro.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasenia = new GridBagConstraints();
		gbc_lblContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblContrasenia.fill = GridBagConstraints.VERTICAL;
		gbc_lblContrasenia.insets = new Insets(0, 0, 0, 5);
		gbc_lblContrasenia.gridx = 1;
		gbc_lblContrasenia.gridy = 1;
		panelCentro.add(lblContrasenia, gbc_lblContrasenia);
		
		textFieldContrasenia = new JPasswordField();
		textFieldContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnIniciarSesion.doClick();
				}
			}
		});
		GridBagConstraints gbc_textFieldContrasenia = new GridBagConstraints();
		gbc_textFieldContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContrasenia.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldContrasenia.gridx = 2;
		gbc_textFieldContrasenia.gridy = 1;
		panelCentro.add(textFieldContrasenia, gbc_textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("\u00A1Bienvenido a Hotelea!");
		panelNorte.add(lblBienvenido);
		
	}

}
