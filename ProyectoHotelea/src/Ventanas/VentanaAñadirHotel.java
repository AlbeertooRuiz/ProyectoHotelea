package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Datos.BD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaAñadirHotel extends JFrame{
	private static JTextField textFieldNombre;
	private static JTextField textFieldEstrellas;
	private static JTextField textFieldPrecio;
	private static JTextField textFieldCiudad;
	private static JTextField textFieldDireccion;
	private static JTextField textFieldTelefono;
	private static JTextField textFieldNumHab;
	private static JButton botonanyadir;
	public VentanaAñadirHotel() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INTRODUZCA LOS DATOS DEL HOTEL");
		lblNewLabel.setBounds(116, 6, 281, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:\n");
		lblNewLabel_1.setBounds(6, 45, 61, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estrellas:");
		lblNewLabel_2.setBounds(6, 84, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(6, 131, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(67, 40, 130, 26);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEstrellas = new JTextField();
		textFieldEstrellas.setBounds(67, 79, 130, 26);
		getContentPane().add(textFieldEstrellas);
		textFieldEstrellas.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(53, 126, 130, 26);
		getContentPane().add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad:");
		lblNewLabel_4.setBounds(6, 172, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setBounds(63, 167, 130, 26);
		getContentPane().add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion:");
		lblNewLabel_5.setBounds(6, 210, 73, 16);
		getContentPane().add(lblNewLabel_5);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(73, 205, 130, 26);
		getContentPane().add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(236, 45, 61, 16);
		getContentPane().add(lblNewLabel_6);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(297, 40, 130, 26);
		getContentPane().add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Num Habitaciones:");
		lblNewLabel_7.setBounds(236, 84, 121, 16);
		getContentPane().add(lblNewLabel_7);
		
		textFieldNumHab = new JTextField();
		textFieldNumHab.setBounds(359, 79, 24, 26);
		getContentPane().add(textFieldNumHab);
		textFieldNumHab.setColumns(10);
		
		JButton botonanyadir = new JButton("Añadir");
		botonanyadir.setBounds(163, 243, 117, 29);
		getContentPane().add(botonanyadir);
		
		
	}
	public static void insertarHotelAdmin(Connection con, String nombre, int estrellas, String ciudad, int precio) {
		nombre= textFieldNombre.getText();
		estrellas=Integer.parseInt(textFieldEstrellas.getText());
		ciudad= textFieldCiudad.getText();
		precio=Integer.parseInt(textFieldPrecio.getText());
		String sql = "INSERT INTO Hotel VALUES('"+nombre+"','"+estrellas+"','"+ciudad+"','"+precio+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	
	

	}
}
