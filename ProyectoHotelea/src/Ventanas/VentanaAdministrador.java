package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public VentanaAdministrador() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO A LA VENTANA DE ADMINISTRADORES");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 35, 438, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("La empresa Hotelea proporciona a sus administradores una serie de ");
		lblNewLabel_1.setBounds(6, 119, 438, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("opciones que espera que puedan aprovechar. ¿Qué desea hacer?");
		lblNewLabel_2.setBounds(6, 137, 438, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("<<Ver Estadisticas");
		btnNewButton.setBounds(0, 237, 154, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Añadir nuevo hotel>>");
		btnNewButton_1.setBounds(271, 237, 173, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VentanaAnyadirHotel va=new VentanaAnyadirHotel() ;
				va.setVisible(true);
				dispose();
			}
			
		});
		
		
	}
}
