package hotelea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
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

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldContrasenia;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("\u00A1Bienvenido a Hotelea!");
		panelNorte.add(lblBienvenido);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		panelSur.add(btnIniciarSesion);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblRegistro = new JLabel("\u00BFNo tienes cuenta?");
		panelSur.add(lblRegistro);
		
		JButton btnNewButton = new JButton("\u00A1Registrate!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelSur.add(btnNewButton);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
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
		
		//Conexión con la base de datos
		Connection con = BD.initBD("hotelea.db");
		//Crear las tablas
		BD.crearTablas(con);
	}

}
