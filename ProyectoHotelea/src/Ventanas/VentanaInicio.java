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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Font;

public class VentanaInicio extends JFrame implements Runnable {

	private JFrame ventanaActual;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldContrasenia;
	private JPanel panelNorte, panelSur, panelEste, panelOeste, panelCentro, panelArriba, panelAbajo;
	Connection con;
	private JPanel panelReloj;
	private JPanel panelBienvenido;
	private JLabel lblBienvenido;
	private JLabel lblReloj;
	
	String hora,minutos,segundos,ampm;
	Calendar calendario;    
	Thread h1;
	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		ventanaActual = this;
		ventanaActual.setSize(550, 550);
		ventanaActual.getContentPane().setLayout(new BorderLayout());
		ventanaActual.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Conexion con la base de datos
		con = BD.initBD("Hotelea.db");
		//Crear las tablas si no existen
		BD.crearTablaCliente(con);
		BD.crearTablaHotel(con);
		BD.crearTablaReservas(con);
		
		BD.cargarreservasTablaCsv();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = textFieldUsuario.getText();
				String c = textFieldContrasenia.getText();
				Cliente cliente = BD.obtenerDatosCliente(con, u);
				if(u.equals("admin") && c.equals("hotelea")) {
					BD.closeBD(con);
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
					VentanaUsuario vu= new VentanaUsuario(ventanaActual);
					vu.setVisible(true);
					ventanaActual.dispose();
				}
			}
		});
		
		JLabel lblRegistro = new JLabel("\u00BFNo tienes cuenta?");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("\u00A1Registrate!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		gbl_panelCentro.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 0;
		panelCentro.add(lblUsuario, gbc_lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContrasenia = new GridBagConstraints();
		gbc_lblContrasenia.anchor = GridBagConstraints.WEST;
		gbc_lblContrasenia.fill = GridBagConstraints.VERTICAL;
		gbc_lblContrasenia.insets = new Insets(0, 0, 0, 5);
		gbc_lblContrasenia.gridx = 1;
		gbc_lblContrasenia.gridy = 1;
		panelCentro.add(lblContrasenia, gbc_lblContrasenia);
		
		textFieldContrasenia = new JPasswordField();
		textFieldContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		panelNorte.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelReloj = new JPanel();
		panelNorte.add(panelReloj);
		
		lblReloj = new JLabel("Reloj");
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelReloj.add(lblReloj);
		
		panelBienvenido = new JPanel();
		panelNorte.add(panelBienvenido);
		
		lblBienvenido = new JLabel("\u00A1Bienvenido a Hotelea!");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBienvenido.add(lblBienvenido);
		
		h1 = new Thread(this);
		h1.start();
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread ct = Thread.currentThread();
		while(ct == h1) {   
			calcula();
			lblReloj.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		 }
	}

	public void calcula () {        
		Calendar calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();


		calendario.setTime(fechaHoraActual);
		ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

		if(ampm.equals("PM")){
		 int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
		 hora = h>9?""+h:"0"+h;
		}else{
			hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
		}
		minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
	}
	
	
}
