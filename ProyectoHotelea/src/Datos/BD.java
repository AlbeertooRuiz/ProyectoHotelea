package Datos;

import static org.junit.Assert.fail;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BD {
	
	private static Logger logger = Logger.getLogger( "BD" );
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	// Metodo que realiza la conexion con la base de datos
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			logger.log( Level.INFO, "Abriendo conexión con " + nombreBD );
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			logger.log( Level.SEVERE, "Excepción", e );
		} 

		return con;
	}

	// Metodo que cierra la conexion con la base de datos
	public static void closeBD(Connection con) {
		if (con != null) {
			try {
				logger.log( Level.INFO, "Cerrando conexión" );
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log( Level.SEVERE, "Excepción", e );
			}
		}
	}

	// Metodo que crea la tabla Cliente
	public static boolean crearTablaCliente(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Cliente (DNI String, nombre String, apellidos String, usuario String, contrasenia String)";
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement: " + sql );
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
			
		}
	}

	// Metodo que inserta un cliente dentro de la tabla Cliente
	public static boolean insertarCliente(Connection con, String DNI, String nombre, String apellidos, String usuario,
			String contrasenia) {
		String sql = "INSERT INTO Cliente VALUES('" + DNI + "','" + nombre + "','" + apellidos + "','" + usuario + "','"
				+ contrasenia + "')";
		logger.log( Level.INFO, "Statement: " + sql );
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
		}
	}

	// Metodo que devuelve usuario y contrase�a de un cliente de la tabla Cliente
	// mediante la busqueda por usuario
	public static Cliente obtenerDatosCliente(Connection con, String usuario) {
		String sql = "SELECT * FROM Cliente WHERE usuario='" + usuario + "'";
		Cliente cliente = null;
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement: " + sql );
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String u = rs.getString("usuario");
				String contr = rs.getString("contrasenia");
				cliente = new Cliente(u, contr);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			logger.log( Level.SEVERE, "Excepción", e );
		}
		return cliente;
	}

	// Metodo que crea la tabla Hotel
	public static boolean crearTablaHotel(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Hotel (nombre String, ciudad String, estrellas int, valoracion int, precio int, numHab int)";
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement: " + sql );
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
		}

	}

	public static ArrayList<Hotel> cargarHotelesTablaCsv() {
		ArrayList<Hotel> hoteles = new ArrayList<>();
		String input = "Hoteles.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datos = line.split(",");
				String nombre = datos[0];
				String ciudad = datos[1];
				int estrellas = Integer.valueOf(datos[2]);
				int valoracion = Integer.valueOf(datos[3]);
				int precio = Integer.valueOf(datos[4]);
				int numHab = Integer.valueOf(datos[5]);

				Hotel h = new Hotel(nombre, ciudad, estrellas, valoracion, precio, numHab);
				hoteles.add(h);
			}
			br.close();
			return hoteles;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			fail("No se han podido cargar los datos de el fichero" + input);
			return null;
		}

	}



	public void cargarBD(ActionEvent e) {
		String texto = "";
		ArrayList<String> lista = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Hoteles"));
			String linea = br.readLine();
			while (linea != br.readLine()) {
				texto = texto + linea + "\n";
				lista.add(linea);
				linea = br.readLine();

			}
		} catch (IOException e1) {
			System.out.println("Falla fichero");
		}
	}

	public static ArrayList<Hotel> obtenerListaHoteles(Connection con) {
		ArrayList<Hotel> hoteles = new ArrayList<>();

		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Hotel";
			logger.log( Level.INFO, "Statement:", sql );
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String ciudad = rs.getString("ciudad");
				int estrellas = rs.getInt("estrellas");
				int valoracion = rs.getInt("valoracion");
				int precio = rs.getInt("precio");
				int numHab = rs.getInt("numHab");
				Hotel h = new Hotel(nombre, ciudad, estrellas, valoracion, precio, numHab);
				hoteles.add(h);
			}
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			logger.log( Level.SEVERE, "Excepción", e );
		}
		return hoteles;

	}

	// Metodo que crea la tabla Reservas
	public static boolean crearTablaReservas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Reservas (hotel String, fecha String, reservas int, fechahoy int)";
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
		}
	}
	

	public static boolean existeReserva(String nom, String fecha) {
		boolean resul = false;
		String sql = "SELECT * FROM Reservas WHERE hotel='" + nom + "' AND fecha='" + fecha + "'";
		Connection con = initBD("Hotelea.db");
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				resul = true;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
		}
		closeBD(con);
		return resul;
	}

	public static boolean modificarReserva(String nom, String fecha) {
		String sql = "UPDATE Reservas SET reservas=reservas+1 WHERE hotel='" + nom + "' AND fecha='" + fecha + "'";
		Connection con = initBD("Hotelea.db");
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			st.executeUpdate(sql);
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
		}
		closeBD(con);
		return true;
	}

	// Metodo que inserta una reserva dentro de la tabla Reservas
	public static boolean insertarReserva(String hotel, String fecha, int reservas, int day) {
		String sql = "INSERT INTO Reservas VALUES('" + hotel + "','" + fecha + "'," + reservas + "," + day + ")";
		Connection con = initBD("Hotelea.db");
		
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
			return false;
		}
		closeBD(con);
		return true;
	}
	
	public static ArrayList<Reserva> getReservas() {
		Connection con = initBD("Hotelea.db");
		try (Statement statement = con.createStatement()) {
			ArrayList<Reserva> ret = new ArrayList<>();
			String sent = "select * from Reservas;";
			logger.log( Level.INFO, "Statement:", sent );
			ResultSet rs = statement.executeQuery( sent );
			while(rs.next()) {
				String hotel=rs.getString("hotel");
				String fecha=rs.getString("fecha");
				int reservas=rs.getInt("reservas");
				int fechahoy=rs.getInt("fechahoy");
				ret.add(new Reserva(hotel, fecha, reservas, fechahoy));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepción", e );
		}
		return null;
		
	}
	
	
}
