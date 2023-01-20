package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaEstadisticasMes extends JFrame{
	private JTextField textField;
	public VentanaEstadisticasMes() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS POR MES");
		lblNewLabel.setBounds(128, 6, 176, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("El mes en el que mas reservas hay es:");
		lblNewLabel_1.setBounds(6, 34, 245, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(251, 34, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("El mes en el que menos reservas hay es:");
		lblNewLabel_3.setBounds(6, 62, 254, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(272, 62, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Introduzca mes del año:\n");
		lblNewLabel_5.setBounds(138, 100, 166, 16);
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(169, 118, 110, 16);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(128, 168, 205, 104);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(184, 146, 84, 16);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset datos=new DefaultCategoryDataset();
				
				
				JFreeChart grafico_barras=ChartFactory.createBarChart3D("Estadisticas por mes","Meses","Numero reservas",datos,PlotOrientation.VERTICAL,true,true,false);
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