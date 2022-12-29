package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEstadisticasFechas extends JFrame{
	public VentanaEstadisticasFechas() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS POR FECHAS");
		lblNewLabel.setBounds(128, 16, 176, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("El mes en el que mas reservas hay es");
		lblNewLabel_1.setBounds(32, 58, 232, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(269, 58, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("El mes en el que menos reservas hay es");
		lblNewLabel_3.setBounds(32, 87, 254, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(289, 86, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("El dia de la semana en el que mas reservas hay es");
		lblNewLabel_5.setBounds(32, 115, 316, 16);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(350, 115, 61, 16);
		getContentPane().add(lblNewLabel_6);
	}

}
