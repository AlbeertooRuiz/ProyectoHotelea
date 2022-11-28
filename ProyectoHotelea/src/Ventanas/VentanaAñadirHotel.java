package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaAñadirHotel extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
		
		textField = new JTextField();
		textField.setBounds(67, 40, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 79, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(53, 126, 130, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad:");
		lblNewLabel_4.setBounds(6, 172, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(63, 167, 130, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion:");
		lblNewLabel_5.setBounds(6, 210, 73, 16);
		getContentPane().add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(73, 205, 130, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(236, 45, 61, 16);
		getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(297, 40, 130, 26);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Num Habitaciones:");
		lblNewLabel_7.setBounds(236, 84, 121, 16);
		getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(359, 79, 24, 26);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Terminar");
		btnNewButton.setBounds(163, 243, 117, 29);
		getContentPane().add(btnNewButton);
	}

}
