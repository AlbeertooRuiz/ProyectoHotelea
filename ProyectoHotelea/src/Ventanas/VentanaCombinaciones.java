
package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Datos.BD;
import Datos.Combinaciones;
import Datos.Hotel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JCheckBox;

public class VentanaCombinaciones extends JFrame implements Combinaciones{

	private JPanel contentPane;
	private JTextField textPresupuesto;
	private JTable tabla;
	private DefaultTableModel modeloTablaHotel;
	private JComboBox<String> comboTipo;
	private JButton btnAceptar;

	public VentanaCombinaciones() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 400, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		textPresupuesto = new JTextField();
		textPresupuesto.setBounds(35, 45, 96, 20);
		contentPane.add(textPresupuesto);
		textPresupuesto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("INDIQUE SU PRESUPUESTO");
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(25, 13, 194, 36);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> comboTipo = new JComboBox<String>();
		comboTipo.setBounds(224, 45, 199, 20);
		comboTipo.addItem("Motel");
		comboTipo.addItem("Hotel");
		comboTipo.addItem("Hostel");
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(282, 74, 82, 21);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<List<Integer>> combinaciones = combinacionesRecursivas(BD.getPreciosEnFuncionDelTipo(String.valueOf(comboTipo.getSelectedItem())), Integer.parseInt(textPresupuesto.getText()));
				List<ArrayList<Hotel>> listaHoteles = BD.getHotelesEnFuncionDePrecios(combinaciones);{
				
				for (ArrayList<Hotel> hoteles : listaHoteles) {
					
					for(Hotel h : hoteles) {
						Object [] datos = {h.getNombre(), h.getCiudad(), h.getEstrellas(),h.getValoracion(), h.getPrecio(), h.getTipo()};
						modeloTablaHotel.addRow(datos);
					}
					Object [] datos2 = {};
					modeloTablaHotel.addRow(datos2);
					
				};
				
			}
		}});
		
		tabla = new JTable(modeloTablaHotel);
		tabla.setBounds(10, 99, 666, 282);
		contentPane.add(tabla);
		
		JLabel lblNewLabel = new JLabel("INTRODUZCA EL TIPO DE HOTEL");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		lblNewLabel.setBounds(229, 11, 247, 41);
		contentPane.add(lblNewLabel);
		
		
		contentPane.add(comboTipo);
		
		JCheckBox chckbxPrecio = new JCheckBox("");
		chckbxPrecio.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		chckbxPrecio.setBounds(587, 42, 29, 23);
		contentPane.add(chckbxPrecio);
		
		JLabel lblNewLabel_2 = new JLabel("ORDENAR POR PRECIO");
		lblNewLabel_2.setFont(new Font("Viner Hand ITC", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(527, 24, 125, 14);
		contentPane.add(lblNewLabel_2);
		


		
		modeloTablaHotel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabla = new JTable(modeloTablaHotel);
		
		String [] titulos = {"Nombre", "Ciudad", "Estrella(s)", "Valoracion", "Precio", "Tipo"};
		modeloTablaHotel.setColumnIdentifiers(titulos);
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		modeloTablaHotel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
	
	
	}
	
		
		@Override
		public List<List<Integer>> combinacionesRecursivas(ArrayList<Integer> precios, int i) {
			
			List<List<Integer>> combinaciones = new ArrayList<>();
	        if (i == 0) {
	            combinaciones.add(new ArrayList<>());
	            return combinaciones;
	        }
	        for (List<Integer> combinacion : combinacionesRecursivas(precios, i - 1)) {
	            for (int n : precios) {
	                if (!combinacion.contains(n) && (combinacion.stream().mapToInt(Integer::intValue).sum() + n <= i)) {
	                    List<Integer> newCombinacion = new ArrayList<>(combinacion);
	                    newCombinacion.add(n);
	                    combinaciones.add(newCombinacion);
	                }
	            }
	            
	        }
	       
	        return combinaciones;
	    
		};
		
		
}
		
	

