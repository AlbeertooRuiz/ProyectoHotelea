package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSlider;

public class VentanaCombinaciones extends JFrame {

	private JPanel contentPane;
	private JTextField textPresupuesto;
	private JTable table;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCombinaciones frame = new VentanaCombinaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCombinaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPresupuesto = new JTextField();
		textPresupuesto.setBounds(45, 45, 96, 20);
		contentPane.add(textPresupuesto);
		textPresupuesto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("INDIQUE SU PRESUPUESTO");
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(23, 11, 194, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(180, 67, 82, 21);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 99, 416, 153);
		contentPane.add(table);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(296, 45, 96, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("INDIQUE EL TIPO DE HOTEL");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		lblNewLabel.setBounds(276, 7, 188, 45);
		contentPane.add(lblNewLabel);
	}
}
