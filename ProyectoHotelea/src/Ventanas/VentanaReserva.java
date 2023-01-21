package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.datatype.XMLGregorianCalendar;

import Datos.BD;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class VentanaReserva extends JFrame {

	private JPanel contentPane;
	private String nombreHotel;
	private JTextField textFieldNumPer;
	private JTextField textFieldCheckin;
	private JTextField textFieldCheckout;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Connection con;

	/**
	 * Create the frame.
	 */
	public VentanaReserva(String nombre) {
		this.nombreHotel = nombre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Conexion con la base de datos
		con = BD.initBD("Hotelea.db");
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblTexto = new JLabel("Introduce tus datos");
		panelNorte.add(lblTexto);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNumPer = new JLabel("Numero de personas");
		panelCentro.add(lblNumPer);
		
		textFieldNumPer = new JTextField();
		panelCentro.add(textFieldNumPer);
		textFieldNumPer.setColumns(10);
		
		JLabel lblCheckin = new JLabel("Check-in");
		panelCentro.add(lblCheckin);
		
		textFieldCheckin = new JTextField();
		panelCentro.add(textFieldCheckin);
		textFieldCheckin.setColumns(10);
		
		JLabel lblCheckout = new JLabel("Check-out");
		panelCentro.add(lblCheckout);
		
		textFieldCheckout = new JTextField();
		panelCentro.add(textFieldCheckout);
		textFieldCheckout.setColumns(10);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnConfirmarReserva = new JButton("Confirmar Reserva");
		btnConfirmarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumPer.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Debe introducir el numero de personas");
				} else {
					int numP = Integer.parseInt(textFieldNumPer.getText());
					if (numP>4) {
						JOptionPane.showMessageDialog(null, "El maximo de personas por habitacion es de 4");
					} else {
						String fechaE = textFieldCheckin.getText();
						if(textFieldCheckin.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Debe introducir la fecha de check-in");
						} else {
							String fechaS = textFieldCheckout.getText();
							if(textFieldCheckout.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Debe introducir la fecha de check-out");
							} else {
								String hotel = nombreHotel;
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								try {
									Date fe = sdf.parse(fechaE);
									Date fs = sdf.parse(fechaS);
									do{
										String fecha = sdf.format(fe);
										if(textFieldCheckin.getText().equals(textFieldCheckout.getText())) {
											if(BD.existeReserva(hotel, fecha)) {
												BD.modificarReserva(hotel, fecha);
												JOptionPane.showMessageDialog(null, "Su reserva se ha realizado correctamente");
											} else {
												BD.insertarReserva(hotel, fecha, 1, new Date(System.currentTimeMillis()).getDay());
												JOptionPane.showMessageDialog(null, "Su reserva se ha realizado correctamente");
											}
										}
										if(BD.existeReserva(hotel, fecha)) {
											BD.modificarReserva(hotel, fecha);
											JOptionPane.showMessageDialog(null, "Su reserva se ha realizado correctamente");
										}else {
											BD.insertarReserva(hotel, fecha, 1, new Date(System.currentTimeMillis()).getDay());
											JOptionPane.showMessageDialog(null, "Su reserva se ha realizado correctamente");
										}
										fe.setTime(fe.getTime()+24*60*60*1000);
									}while(!fe.equals(fs));
									String fecha = sdf.format(fe);
									if(BD.existeReserva(hotel, fecha)) {
										BD.modificarReserva(hotel, fecha);
										JOptionPane.showMessageDialog(null, "Su reserva se ha realizado correctamente");
									}else {
										BD.insertarReserva(hotel, fecha, 1,new Date(System.currentTimeMillis()).getDay());
										JOptionPane.showMessageDialog(null, "Su reserva se ha realizado correctamente");
									}
							
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				};
			}
		});
		panelSur.add(btnConfirmarReserva);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
	}

}
