package Ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaEstadisticas extends JFrame{
	private JFrame ventanaActual;
	public VentanaEstadisticas() {
		
		
		ventanaActual = this;
		ventanaActual.setSize(550, 550);
		ventanaActual.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATOS/ESTADISTICAS");
		lblNewLabel.setBounds(145, 6, 204, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Desde la empresa Hotelea facilitamos unos datos/estadisticas que ");
		lblNewLabel_1.setBounds(6, 43, 438, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("esperemos que puedan ser de maxima utilidad para los/las ");
		lblNewLabel_2.setBounds(6, 63, 438, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("administradores/as:");
		lblNewLabel_3.setBounds(6, 83, 156, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Consultar datos por:");
		lblNewLabel_4.setBounds(145, 103, 204, 16);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Fechas ");
		btnNewButton_1.setBounds(354, 133, 117, 29);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dias de la semana con mas reservas");
		btnNewButton_2.setBounds(18, 131, 264, 29);
		getContentPane().add(btnNewButton_2);
		
		JButton btnvolver = new JButton("Volver");
		btnvolver.setBounds(191, 297, 117, 29);
		getContentPane().add(btnvolver);
		
		//metodo para volver a ventana anterior pulsando el boton
		btnvolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAdministrador vi=new VentanaAdministrador() ;
				vi.setVisible(true);
				dispose();
			}
			
		});
		
		//metodo para ir a ver las estadisticas por mes
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaEstadisticasMes va=new VentanaEstadisticasMes() ;
				va.setVisible(true);
				dispose();
			}
			
		});
		
		//metodo para ir a ver las estadisticas por dia
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaEstadisticasDias va=new VentanaEstadisticasDias() ;
				va.setVisible(true);
				dispose();
			}
			
		});
		
		
	}
	
	
}
