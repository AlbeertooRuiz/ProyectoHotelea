package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Datos.BD;
import Datos.Hotel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tablaHotel;
	private DefaultTableModel modeloTablaHotel;
	private JScrollPane scrollTabla;
	private JTextField textFieldCiudad;
	private JTextField textFieldEstrellas;
	private JTextField textFieldCheckin;
	private JTextField textFieldCheckout;

	/**
	 * Create the frame.
	 */
	public VentanaUsuario() {
		Connection con = BD.initBD("hotelea.db");
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
		panelNorte.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelArriba = new JPanel();
		panelNorte.add(panelArriba);
		
		JPanel panelAbajo = new JPanel();
		panelNorte.add(panelAbajo);
		
		JLabel lblTitulo = new JLabel("Encuentra el hotel que mas se adapte a ti");
		panelArriba.add(lblTitulo);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel lblCiudad = new JLabel("Ciudad");
		panelAbajo.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		panelAbajo.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Estrellas");
		panelAbajo.add(lblNewLabel);
		
		textFieldEstrellas = new JTextField();
		panelAbajo.add(textFieldEstrellas);
		textFieldEstrellas.setColumns(10);
		
		JLabel lblCheckin = new JLabel("Check-in");
		panelAbajo.add(lblCheckin);
		
		textFieldCheckin = new JTextField();
		panelAbajo.add(textFieldCheckin);
		textFieldCheckin.setColumns(10);
		
		JLabel lblCheckout = new JLabel("Check-out");
		panelAbajo.add(lblCheckout);
		
		textFieldCheckout = new JTextField();
		panelAbajo.add(textFieldCheckout);
		textFieldCheckout.setColumns(10);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBuscar = new JButton("Buscar");
		panelSur.add(btnBuscar);
		
		modeloTablaHotel = new DefaultTableModel();
		String [] titulos = {};
		modeloTablaHotel.setColumnIdentifiers(titulos);
		
		ArrayList<Hotel> hoteles = BD.obtenerListaHoteles(con);
		for(Hotel h: hoteles) {
			Object [] datos = {h.getNombre(),h.getNumEstr(),h.getCiudad(), "Info adicional"};
			modeloTablaHotel.addRow(datos);
		}
		
		tablaHotel = new JTable(modeloTablaHotel);
		scrollTabla  = new JScrollPane(tablaHotel);
		
		scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTabla.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		contentPane.add(scrollTabla, BorderLayout.CENTER);
	}
}
