package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCiudad;
	private JTextField textFieldEstrellas;
	private JTextField textFieldCheckin;
	private JTextField textFieldCheckout;
	private JTable tablaPersona;
	private DefaultTableModel modeloTablaPersona;
	private JScrollPane scrollTabla;

	/**
	 * Create the frame.
	 */
	public VentanaUsuario() {
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
				
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("ESCOJA LAS CARACTERISTICAS DEL HOTEL QUE BUSCA");
		panelNorte.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCiudad = new JLabel("Ciudad");
		panelCentro.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		panelCentro.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel lblEstrellas = new JLabel("Estrellas");
		panelCentro.add(lblEstrellas);
		
		textFieldEstrellas = new JTextField();
		panelCentro.add(textFieldEstrellas);
		textFieldEstrellas.setColumns(10);
		
		JLabel lblCheckin = new JLabel("Check-in");
		panelCentro.add(lblCheckin);
		
		textFieldCheckin = new JTextField();
		panelCentro.add(textFieldCheckin);
		textFieldCheckin.setColumns(10);
		
		JLabel lblCheckout = new JLabel("Check-out");
		panelCentro.add(lblCheckout);
		
		textFieldCheckout = new JTextField();
		panelCentro.add(textFieldCheckout);
		textFieldCheckout.setColumns(10);
		
		JButton btnNewButton = new JButton("RESULTADOS\n");
		panelSur.add(btnNewButton);
	}
}
