package Datos;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BD {
	
	
	//Metodo que realiza la conexion con la base de datos
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	//Metodo que cierra la conexion con la base de datos
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//Metodo que crea la tabla Cliente
	public static void crearTablaCliente(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Cliente (DNI String, nombre String, apellidos String, usuario String, contrasenia String)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodo que inserta un cliente dentro de la tabla Cliente
	public static void insertarCliente(Connection con, String DNI, String nombre, String apellidos, String usuario, String contrasenia) {
		String sql = "INSERT INTO Cliente VALUES('"+DNI+"','"+nombre+"','"+apellidos+"','"+usuario+"','"+contrasenia+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodo que devuelve usuario y contraseña de un cliente de la tabla Cliente mediante la busqueda por usuario
	public static Cliente obtenerDatosCliente(Connection con, String usuario) {
		String sql = "SELECT * FROM Cliente WHERE usuario='"+usuario+"'";
		Cliente cliente = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String u = rs.getString("usuario");
				String contr = rs.getString("contrasenia");
				cliente = new Cliente(u, contr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	
	//Metodo que crea la tabla Hotel
	public static void crearTablaHotel(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Hotel (nombre String, ciudad String, estrellas int, valoracion int, precio int, numHab int)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Metodo que inserta un hotel dentro de la tabla Hotel
	public static void insertarHotel(Connection con, String nombre, String ciudad, int estrellas, int valoracion, int precio) {
		String sql = "INSERT INTO Hotel VALUES('"+nombre+"','"+ciudad+"','"+estrellas+"','"+valoracion+"','"+precio+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertarCSV(ActionEvent e) {
		ArrayList<Hotel> hoteles = new ArrayList<>();
	    Connection con = BD.initBD("Hotelea.db");
		try {
			BufferedReader br = new BufferedReader(new FileReader("Hoteles.csv"));
			String  linea = br.readLine();
				while(linea != br.readLine()) {
					linea= br.readLine();
					String []  elementos =  linea.split(",");
					//Hotel hotel = new Hotel(elementos[0], elementos[1], Integer.parseInt(elementos[2]),Integer.parseInt(elementos[3]), Integer.parseInt(elementos[4]));
					
					String Nombre = elementos[0];
					String Ciudad = elementos[1];
					int Estrellas = Integer.parseInt(elementos[2]);
					int Valoracion = Integer.parseInt(elementos[3]);
					int Precio = Integer.parseInt(elementos[4]);
					
					//hoteles.add(hotel);
					insertarHotel( con, Nombre, Ciudad, Estrellas, Valoracion, Precio);
				}
		} catch (IOException e1) {
			System.out.println("Falla fichero");
		
	}
}
	
	public void cargarBD(ActionEvent e) {
		String texto="";
		ArrayList<String> lista = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Hoteles"));
			String  linea = br.readLine();
				while(linea != br.readLine()) {
					texto=texto+linea+"\n";
					lista.add(linea);
					linea= br.readLine();
					
				}
		} catch (IOException e1) {
			System.out.println("Falla fichero");
		}	
	}
	
	public static ArrayList<Hotel> obtenerListaHoteles (Connection con) {
		ArrayList<Hotel> hoteles= new ArrayList<>();
		
		try {
			Statement st= con.createStatement();
			String sql= "SELECT * FROM Hotel";
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String ciudad = rs.getString("ciudad");
				int estrellas=rs.getInt("estrellas");
				int valoracion=rs.getInt("valoracion");
				int precio=rs.getInt("precio");
				int numHab = rs.getInt("numHab");
				Hotel h= new Hotel(nombre, ciudad, estrellas, valoracion, precio, numHab);
				hoteles.add(h);
			}
			rs.close();
			st.close();
			} catch(SQLException e) {
			e.printStackTrace();
		}
		return hoteles;
		
	}
	
	
	//Metodo que crea la tabla Reservas
	public static void crearTablaReservas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Reservas (hotel String, fecha String, reservas int)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodo que inserta una reserva dentro de la tabla Reservas
	public static void insertarReserva(Connection con, String hotel, String fecha, int reservas) {
		String sql = "INSERT INTO Reservas VALUES('"+hotel+"','"+fecha+"','"+reservas+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	public static void AumentarReserva(Connection con, String hotel, String fecha) {
		String sql = "UPDATE Reservas SET Hotel=" + hotel + "WHERE reservas=reservas+1";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
