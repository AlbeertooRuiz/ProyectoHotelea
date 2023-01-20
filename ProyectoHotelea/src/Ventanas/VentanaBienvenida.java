package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaBienvenida extends JFrame{
	
	private JFrame ventanaActual;
	
	public VentanaBienvenida() {
		ventanaActual = this;
		ventanaActual.setSize(550, 550);
		ventanaActual.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.setBounds(172, 416, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/jonayo/Downloads/hotelea.png"));
		lblNewLabel.setBounds(-353, 6, 903, 522);
		getContentPane().add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaInicio vi=new VentanaInicio() ;
				vi.setVisible(true);
				dispose();
			}
			
		});
	}

}
