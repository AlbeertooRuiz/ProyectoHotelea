package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BD {
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
	
	public static void insertarHotel(Connection con, String nombre, String ciudad, int estrellas, int valoracion, int precio, int numHab) {
		String sql = "INSERT INTO Hotel VALUES('"+nombre+"','"+ciudad+"','"+estrellas+"','"+valoracion+"','"+precio+"', '"+numHab+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public static void reservaHotel(Connection con) {
		String sql = "UPDATE Hotel SET ";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
