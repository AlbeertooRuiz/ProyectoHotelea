package hotelea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
		String sql = "CREATE TABLE IF NOT EXISTS Cliente (nombre String, apellidos String, usuario String, contrase�a string)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertarCliente(Connection con, String nombre, String apellidos, String usuario, String contrasena) {
		String sql = "INSERT INTO Cliente VALUES('"+nombre+"','"+apellidos+"','"+usuario+"','"+contrasena+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void crearTablaHotel(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Hotel (nombre String, estrellas String, ciudad String)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertarHotel(Connection con, String nombre, String estrellas, String ciudad) {
		String sql = "INSERT INTO Hotel VALUES('"+nombre+"','"+estrellas+"','"+ciudad+"')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
