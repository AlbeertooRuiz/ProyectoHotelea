package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Datos.BD;

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

public class VentanaInicio extends JFrame {

	private JFrame ventanaActual;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldContrasenia;
	private JPanel panelNorte, panelSur, panelEste, panelOeste, panelCentro, panelArriba, panelAbajo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		ventanaActual = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("\u00A1Bienvenido a Hotelea!");
		panelNorte.add(lblBienvenido);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		panelCentro.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		panelCentro.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		panelCentro.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		panelCentro.add(lblContrasenia);
		
		textFieldContrasenia = new JPasswordField();
		panelCentro.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		//Conexi�n con la base de datos Cliente
		Connection con = BD.initBD("Hotelea.db");
		//Crear las tablas
		BD.crearTablaCliente(con);
		BD.crearTablaHotel(con);
	}

}
