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
	private JFrame ventanaActual;
	
	
	public VentanaEstadisticasDias() {
		ventanaActual = this;
		ventanaActual.setSize(550, 550);
		ventanaActual.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
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
		
		JLabel lblmas = new JLabel("mayor");
		lblmas.setBounds(299, 43, 61, 16);
		getContentPane().add(lblmas);
		
		JLabel lblmenos = new JLabel("menor");
		lblmenos.setBounds(313, 71, 61, 16);
		getContentPane().add(lblmenos);
		
		JButton btnNewButton = new JButton("Mostrar gráfico");
		btnNewButton.setBounds(142, 111, 159, 21);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 144, 490, 338);
		getContentPane().add(panel);
		
		
		JButton btnvolver = new JButton("Volver");
		btnvolver.setBounds(147, 487, 117, 29);
		getContentPane().add(btnvolver);
		
		ArrayList<Reserva> reservas= BD.getReservas();
		ArrayList<Integer> dias=new ArrayList<>();
		for(Reserva r:reservas) {
			dias.add(r.getFechahoy());
		}
		
		
		for(Integer i:dias) {
			if(i==0) {
				domingo++;
			}else if(i==1) {
				lunes++;
			}else if(i==2) {
				martes++;
			}else if(i==3) {
				miercoles++;
			}else if(i==4) {
				jueves++;
			}else if(i==5) {
				viernes++;
			}else if(i==6) {
				sabado++;
			}
			
		}
		List<Integer>listadias= new ArrayList<>();
		listadias.add(lunes);
		listadias.add(martes);
		listadias.add(miercoles);
		listadias.add(jueves);
		listadias.add(viernes);
		listadias.add(sabado);
		listadias.add(domingo);
		
		int max=0;
		for(int i:listadias) {
			if(i>max) {
				max=i;
			}
		}
		if(lunes==max) {
			lblmas.setText("Lunes");
		}else if(martes==max) {
			lblmas.setText("Martes");
		}else if(miercoles==max) {
			lblmas.setText("Miercoles");
		}else if(jueves==max) {
			lblmas.setText("Jueves");
		}else if(viernes==max) {
			lblmas.setText("Viernes");
		}else if(sabado==max) {
			lblmas.setText("Sabado");
		}else if(domingo==max) {
			lblmas.setText("Domingo");
		}
		
		int min=lunes;
		if(martes<min) {
			min=martes;
		}else if(miercoles<min) {
			min=miercoles;
		}else if(jueves<min) {
			min=jueves;
		}else if(viernes<min) {
			min=viernes;
		}else if(sabado<min) {
			min=sabado;
		}else if(domingo<min) {
			min=domingo;
		}
		
		if(lunes==min) {
			lblmenos.setText("Lunes");
		}else if(martes==min) {
			lblmenos.setText("Martes");
		}else if(miercoles==min) {
			lblmenos.setText("Miercoles");
		}else if(jueves==min) {
			lblmenos.setText("Jueves");
		}else if(viernes==min) {
			lblmenos.setText("Viernes");
		}else if(sabado==min) {
			lblmenos.setText("Sabado");
		}else if(domingo==min) {
			lblmenos.setText("Domingo");
		}
		
		
		btnvolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaEstadisticas vi=new VentanaEstadisticas() ;
				vi.setVisible(true);
				dispose();
			}
			
		});
		
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
				panel2.setPreferredSize(panel.getSize());
				
				
				panel.add(panel2);
				panel.setVisible(true);
				pack();
				setBounds(100,100,600,650);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				repaint();
			};
		});
			
		
				
			
		
		
		
	}
	

}

