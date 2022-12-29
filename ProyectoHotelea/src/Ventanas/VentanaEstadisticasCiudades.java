package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class VentanaEstadisticasCiudades extends JFrame{
	public VentanaEstadisticasCiudades() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS POR CIUDAD\n");
		lblNewLabel.setBounds(116, 16, 247, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("La ciudad con mas reservas es");
		lblNewLabel_1.setBounds(27, 60, 205, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(234, 60, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("La ciudad con menos reservas es");
		lblNewLabel_3.setBounds(27, 93, 207, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(244, 93, 61, 16);
		getContentPane().add(lblNewLabel_4);
	}
	

}
