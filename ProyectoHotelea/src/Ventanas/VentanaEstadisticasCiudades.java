package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class VentanaEstadisticasCiudades extends JFrame{
	private JTextField textField;
	public VentanaEstadisticasCiudades() {
		
		
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS POR CIUDAD\n");
		lblNewLabel.setBounds(116, 6, 247, 16);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 108, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(151, 146, 96, 26);
		getContentPane().add(btnNewButton);
		
		JPanel panela = new JPanel();
		panela.setBounds(102, 172, 207, 94);
		getContentPane().add(panela);
		
		JLabel lblNewLabel_1 = new JLabel("La ciudad con mas reservas es:");
		lblNewLabel_1.setBounds(6, 34, 255, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("La ciudad con menos reservas es:");
		lblNewLabel_2.setBounds(6, 62, 217, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(212, 34, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(235, 62, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Introduzca nombre de ciudad");
		lblNewLabel_5.setBounds(102, 90, 196, 16);
		getContentPane().add(lblNewLabel_5);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset datos=new DefaultCategoryDataset();
				
				
				JFreeChart grafico_barras=ChartFactory.createBarChart3D("Estadisticas por ciudad","Ciudades","Numero reservas",datos,PlotOrientation.VERTICAL,true,true,false);
				ChartPanel panel= new ChartPanel(grafico_barras);
				panel.setMouseWheelEnabled(true);
				panel.setPreferredSize(new Dimension(400,200));
				
				panela.setLayout(new BorderLayout());
				panela.add(panel,BorderLayout.NORTH);
				
				pack();
				repaint();
			}
			
		});
	}
}
