package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Datos.BD;
import Datos.Reserva;

public class VentanaEstadisticasDias extends JFrame{
	int lunes=0;
	int martes=0;
	int miercoles=0;
	int jueves=0;
	int viernes=0;
	int sabado=0;
	int domingo=0;
	
	
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
		
		ArrayList<Reserva> reservas= BD.getReservas();
		Map<Integer, Reserva> mapafechareserva= new HashMap<>();
		
		for(Reserva r:reservas) {
			mapafechareserva.putIfAbsent(r.getFechahoy(), null);
			mapafechareserva.put(r.getFechahoy(), r);
		}
		
		for(Entry<Integer, Reserva> e:mapafechareserva.entrySet()) {
			if(e.getKey()==0) {
				domingo++;
			}else if(e.getKey()==1) {
				lunes++;
			}else if(e.getKey()==2) {
				martes++;
			}else if(e.getKey()==3) {
				miercoles++;
			}else if(e.getKey()==4) {
				jueves++;
			}else if(e.getKey()==5) {
				viernes++;
			}else if(e.getKey()==6) {
				sabado++;
			}
		}
		
		
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultCategoryDataset datos=new DefaultCategoryDataset();
				
				datos.setValue(lunes, "Dias", "Lunes");
				datos.setValue(martes, "Dias", "Martes");
				datos.setValue(miercoles, "Dias", "Miercoles");
				datos.setValue(jueves, "Dias", "Jueves");
				datos.setValue(viernes, "Dias", "Viernes");
				datos.setValue(sabado, "Dias", "Sabado");
				datos.setValue(domingo, "Dias", "Domingo");
				
				
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
