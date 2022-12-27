package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaReserva extends JFrame {

	private JPanel contentPane;
	private String nombreHotel;
	private JTextField textFieldNumPer;
	private JTextField textFieldCheckin;
	private JTextField textFieldCheckout;

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
				String hotel = nombre;
				String fecha = textFieldCheckin.getText();
				//Int reservas =
			}
		});
		panelSur.add(btnConfirmarReserva);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
	}

}
