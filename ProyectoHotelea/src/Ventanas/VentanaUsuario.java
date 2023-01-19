
package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Datos.BD;
import Datos.Hotel;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import java.awt.ScrollPane;

import java.awt.GridLayout;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tablaHotel;
	private DefaultTableModel modeloTablaHotel;
	private JScrollPane scrollTabla;
	private JTextField textFieldCiudad;
	private JTextField textFieldEstrellas;
	private JTextField textFieldValoracion;
	private TableRowSorter<DefaultTableModel> sorter;
	private ArrayList<Hotel> hoteles;
	private JFrame ventanaAnterior, ventanaActual;
	Connection con;
	/**
	 * Create the frame.
	 */
	public VentanaUsuario(JFrame va) {
		ventanaActual = this;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Conexion con la base de datos
		con = BD.initBD("Hotelea.db");
				
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelArriba = new JPanel();
		panelNorte.add(panelArriba);
		
		JPanel panelAbajo = new JPanel();
		panelNorte.add(panelAbajo);
		
		JLabel lblTitulo = new JLabel("Encuentra el hotel que mas se adapte a ti");
		panelArriba.add(lblTitulo);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel lblCiudad = new JLabel("Ciudad");
		panelAbajo.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		
		panelAbajo.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		textFieldCiudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filtrar();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Estrellas(min)");
		panelAbajo.add(lblNewLabel);
		
		textFieldEstrellas = new JTextField();
		
		panelAbajo.add(textFieldEstrellas);
		textFieldEstrellas.setColumns(10);
		
		JLabel lblValoracion = new JLabel("Valoracion(min)");
		panelAbajo.add(lblValoracion);
		
		textFieldValoracion = new JTextField();
		panelAbajo.add(textFieldValoracion);
		textFieldValoracion.setColumns(10);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		panelSur.add(btnCerrarSesion);
		
		textFieldValoracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnCerrarSesion.doClick();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				filtrar();			}
		});
		
		textFieldEstrellas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char teclapresionada=e.getKeyChar();
				if(teclapresionada==KeyEvent.VK_ENTER) {
					btnCerrarSesion.doClick();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				filtrar();
			}
		});
		
		modeloTablaHotel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tablaHotel = new JTable(modeloTablaHotel);
		
		String [] titulos = {"Nombre", "Ciudad", "Estrella(s)", "Valoracion", "Precio"};
		modeloTablaHotel.setColumnIdentifiers(titulos);
		
		tablaHotel.getTableHeader().setReorderingAllowed(false);
		
		//tablaHotel.setAutoCreateRowSorter(true);
		//sorter = new TableRowSorter<>(modeloTablaHotel);
		//tablaHotel.setRowSorter(sorter);			
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Hotel.csv"));
			String linea = br.readLine();
			ArrayList<Hotel> hoteles= new ArrayList<>();
			while(linea!=null) {
				String [] datos = linea.split(";");
				String nombre = datos[1];
				String ciudad = datos[2];
				int estrellas = Integer.parseInt(datos[3]);
				int valoracion = Integer.parseInt(datos[4]);
				int precio = Integer.parseInt(datos[5]);
				int numHab = Integer.parseInt(datos[6]);
				Hotel h= new Hotel(nombre, ciudad, estrellas, valoracion, precio, numHab);
				hoteles.add(h);
				linea = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		hoteles = BD.obtenerListaHoteles(con);
		for(Hotel h: hoteles) {
			Object [] datos = {h.getNombre(), h.getCiudad(), h.getEstrellas(),h.getValoracion(), h.getPrecio()};
			modeloTablaHotel.addRow(datos);
		}

		
		scrollTabla  = new JScrollPane(tablaHotel);
		
		scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTabla.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		contentPane.add(scrollTabla, BorderLayout.CENTER);
		
		tablaHotel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					int fila = tablaHotel.rowAtPoint(e.getPoint());
					System.out.println(fila);
					String nombre = (String)modeloTablaHotel.getValueAt(fila, 0);
					VentanaReserva vr = new VentanaReserva(nombre);
					vr.setVisible(true);
					ventanaActual.dispose();
				}
			}
		});
	}

	private void filtrar() {
		/*try {
			sorter.setRowFilter(RowFilter.regexFilter(textFieldCiudad.getText()));
		} catch (Exception e) {
			
		}*/
		while(modeloTablaHotel.getRowCount()>0) {
			modeloTablaHotel.removeRow(0);
		}
		for(Hotel h: hoteles) {
			//if(h.getCiudad().equals(textFieldCiudad.getText())) {
			int numEstr;
			int valoracion;
			if(textFieldEstrellas.getText().equals("")) {
				numEstr = 0;
			}else {
				numEstr = Integer.parseInt(textFieldEstrellas.getText());
			}
			if(textFieldValoracion.getText().equals("")) {
				valoracion = 0;
			}else {
				valoracion = Integer.parseInt(textFieldValoracion.getText());		
			}
			if(h.getCiudad().startsWith(textFieldCiudad.getText()) && h.getEstrellas()>=numEstr && h.getValoracion()>=valoracion) {
				Object [] datos = {h.getNombre(), h.getCiudad(), h.getEstrellas(),h.getValoracion(), h.getPrecio()};
				modeloTablaHotel.addRow(datos);
//				if( || h.getEstrellas()==ne) {
//					int ne = Integer.parseInt(textFieldEstrellas.getText());
//					Object [] datos = {h.getNombre(), h.getCiudad(), h.getEstrellas(),h.getValoracion(), h.getPrecio()};
//					modeloTablaHotel.addRow(datos);
//				}
			}
		}
	}
	
	}




