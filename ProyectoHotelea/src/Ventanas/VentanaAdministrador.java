package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public VentanaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO A LA VENTANA DE ADMINISTRADORES");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 6, 438, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("La empresa Hotelea proporciona a sus administradores una serie de ");
		lblNewLabel_1.setBounds(6, 34, 438, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("datos y estadisticas mostrados a continuación para facilitar el uso");
		lblNewLabel_2.setBounds(6, 51, 438, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("de la plataforma");
		lblNewLabel_3.setBounds(6, 71, 161, 16);
		contentPane.add(lblNewLabel_3);
	}

}
