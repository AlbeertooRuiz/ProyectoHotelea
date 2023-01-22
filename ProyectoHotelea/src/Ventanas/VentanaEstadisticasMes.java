package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Datos.BD;
import Datos.Reserva;

import javax.swing.JPanel;

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

public class VentanaEstadisticasMes extends JFrame{
	private JFrame ventanaActual;
	int enero=0;
	int febrero=0;
	int marzo=0;
	int abril=0;
	int mayo=0;
	int junio=0;
	int julio=0;
	int agosto=0;
	int septiembre=0;
	int octubre=0;
	int noviembre=0;
	int diciembre=0;
	public VentanaEstadisticasMes() {
		ventanaActual = this;
		ventanaActual.setSize(550, 550);
		ventanaActual.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS POR MES");
		lblNewLabel.setBounds(208, 6, 176, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("El mes en el que mas reservas hay es:");
		lblNewLabel_1.setBounds(6, 34, 245, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblmayor = new JLabel("mayor");
		lblmayor.setBounds(251, 34, 61, 16);
		getContentPane().add(lblmayor);
		
		JLabel lblNewLabel_3 = new JLabel("El mes en el que menos reservas hay es:");
		lblNewLabel_3.setBounds(6, 62, 254, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblmenor = new JLabel("menor");
		lblmenor.setBounds(272, 62, 61, 16);
		getContentPane().add(lblmenor);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 168, 484, 260);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Mostrar grafico");
		btnNewButton.setBounds(226, 132, 126, 24);
		getContentPane().add(btnNewButton);
		
		JButton btnvolver = new JButton("Volver");
		btnvolver.setBounds(235, 458, 117, 29);
		getContentPane().add(btnvolver);
		
		ArrayList<Reserva> reservas= BD.getReservas();
		Map<Integer, Reserva> mapafechareserva= new HashMap<>();
		
		for(Reserva r:reservas) {
			mapafechareserva.put(r.getMes(), r);
		}
		
		for(Entry<Integer,Reserva> e:mapafechareserva.entrySet()) {
			if(e.getKey()==0) {
				enero++;
			}else if(e.getKey()==1) {
				febrero++;
			}else if(e.getKey()==2) {
				marzo++;
			}else if(e.getKey()==3) {
				abril++;
			}else if(e.getKey()==4) {
				mayo++;
			}else if(e.getKey()==5) {
				junio++;
			}else if(e.getKey()==6) {
				julio++;
			}else if(e.getKey()==7) {
				agosto++;
			}else if(e.getKey()==8) {
				septiembre++;
			}else if(e.getKey()==9) {
				octubre++;
			}else if(e.getKey()==10) {
				noviembre++;
			}else if(e.getKey()==11) {
				diciembre++;
			}
		}
		
		List<Integer> listameses=new ArrayList<>();
		listameses.add(enero);
		listameses.add(febrero);
		listameses.add(marzo);
		listameses.add(abril);
		listameses.add(mayo);
		listameses.add(junio);
		listameses.add(julio);
		listameses.add(agosto);
		listameses.add(septiembre);
		listameses.add(octubre);
		listameses.add(noviembre);
		listameses.add(diciembre);
		
		int max=0;
		for(int i:listameses) {
			if(i>max) {
				max=i;
			}
		}
		if(enero==max) {
			lblmayor.setText("Enero");
		}else if(febrero==max) {
			lblmayor.setText("Febrero");
		}else if(marzo==max) {
			lblmayor.setText("Marzo");
		}else if(abril==max) {
			lblmayor.setText("Abril");
		}else if(mayo==max) {
			lblmayor.setText("Mayo");
		}else if(junio==max) {
			lblmayor.setText("Junio");
		}else if(julio==max) {
			lblmayor.setText("Julio");
		}else if(agosto==max) {
			lblmayor.setText("Agosto");
		}else if(septiembre==max) {
			lblmayor.setText("Septiembre");
		}else if(octubre==max) {
			lblmayor.setText("Octubre");
		}else if(noviembre==max) {
			lblmayor.setText("Noviembre");
		}else if(diciembre==max) {
			lblmayor.setText("Diciembre");
		}
		
		int min=enero;
		if(febrero<min) {
			min=febrero;
		}else if(marzo<min) {
			min=marzo;
		}else if(abril<min) {
			min=abril;
		}else if(mayo<min) {
			min=mayo;
		}else if(junio<min) {
			min=junio;
		}else if(julio<min) {
			min=julio;
		}else if(agosto<min) {
			min=agosto;
		}else if(septiembre<min) {
			min=septiembre;
		}else if(octubre<min) {
			min=octubre;
		}else if(noviembre<min) {
			min=noviembre;
		}else if(diciembre<min) {
			min=diciembre;
		}
		
		if(enero==min) {
			lblmenor.setText("Enero");
		}else if(febrero==min) {
			lblmenor.setText("Febrero");
		}else if(marzo==min) {
			lblmenor.setText("Marzo");
		}else if(abril==min) {
			lblmenor.setText("Abril");
		}else if(mayo==min) {
			lblmenor.setText("Mayo");
		}else if(junio==min) {
			lblmenor.setText("Junio");
		}else if(julio==min) {
			lblmenor.setText("Julio");
		}else if(agosto==min) {
			lblmenor.setText("Agosto");
		}else if(septiembre==min) {
			lblmenor.setText("Septiembre");
		}else if(octubre==min) {
			lblmenor.setText("Octubre");
		}else if(noviembre==min) {
			lblmenor.setText("Noviembre");
		}else if(diciembre==min) {
			lblmenor.setText("Diciembre");
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
				
				datos.setValue(enero, "Meses", "Enero");
				datos.setValue(febrero, "Meses", "Febrero");
				datos.setValue(marzo, "Meses", "Marzo");
				datos.setValue(abril, "Meses", "Abril");
				datos.setValue(mayo, "Meses", "Mayo");
				datos.setValue(junio, "Meses", "Junio");
				datos.setValue(julio, "Meses", "Julio");
				datos.setValue(agosto, "Meses", "Agosto");
				datos.setValue(septiembre, "Meses", "Septiembre");
				datos.setValue(octubre, "Meses", "Octubre");
				datos.setValue(noviembre, "Meses", "Noviembre");
				datos.setValue(diciembre, "Meses", "Diciembre");
				
				
				
				JFreeChart grafico_barras=ChartFactory.createBarChart3D("Estadisticas por mes","Meses","Numero reservas",datos,PlotOrientation.VERTICAL,true,true,false);
				ChartPanel panel2= new ChartPanel(grafico_barras);
				panel2.setMouseWheelEnabled(true);
				panel2.setPreferredSize(panel.getSize());
				
				
				panel.add(panel2);
				panel.setVisible(true);
				pack();
				setBounds(100,100,600,650);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				repaint();
			}
			});
	}

}

