package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VentanaEstadisticasDias extends JFrame{
	public VentanaEstadisticasDias() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS POR DIA\n");
		lblNewLabel.setBounds(147, 6, 161, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("El dia en el que mas reservas se realizan es:");
		lblNewLabel_1.setBounds(6, 43, 295, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("El dia en el que menos reservas se realizan es:");
		lblNewLabel_2.setBounds(6, 71, 295, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(299, 43, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(313, 71, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Mostrar gráfico");
		btnNewButton.setBounds(142, 111, 159, 21);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(103, 151, 250, 115);
		getContentPane().add(panel);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset datos=new DefaultCategoryDataset();
				
				
				JFreeChart grafico_barras=ChartFactory.createBarChart3D("Estadisticas por dia","Dias","Numero reservas",datos,PlotOrientation.VERTICAL,true,true,false);
				ChartPanel panel2= new ChartPanel(grafico_barras);
				panel2.setMouseWheelEnabled(true);
				panel2.setPreferredSize(new Dimension(400,200));
				
				panel.setLayout(new BorderLayout());
				panel.add(panel,BorderLayout.NORTH);
				
				pack();
				repaint();
			}
			
		});
	}
	

}
