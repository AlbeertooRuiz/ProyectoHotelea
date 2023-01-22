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
	/**
	 * 
	 * @param nombreBD El nombre de la Base de Datos
	 * @return
	 */
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			logger.log( Level.INFO, "Abriendo conexiÃ³n con " + nombreBD );
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
		} 

		return con;
	}

	// Metodo que cierra la conexion con la base de datos
	public static void closeBD(Connection con) {
		if (con != null) {
			try {
				logger.log( Level.INFO, "Cerrando conexiÃ³n" );
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log( Level.SEVERE, "ExcepciÃ³n", e );
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
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
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
			
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			return false;
		}
	}

	// Metodo que devuelve usuario y contraseï¿½a de un cliente de la tabla Cliente
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
			
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
		}
		return cliente;
	}

	// Metodo que crea la tabla Hotel
	public static boolean crearTablaHotel(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Hotel (nombre String, ciudad String, estrellas int, valoracion int, precio int, numHab int, tipo String)";
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement: " + sql );
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			return false;
		}

	}
	//Metodo que carga los datos de hoteles de prueba que hemos puesto en nuestro csv 
	//y nos devuelve una lista con ellos para luego meterlos en la BD
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
				String tipo = datos[6];
				
				Hotel h = new Hotel(nombre, ciudad, estrellas, valoracion, precio, numHab, tipo);
				hoteles.add(h);
			}
			br.close();
			return hoteles;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			fail("No se han podido cargar los datos de el fichero" + input);
			return null;
		}

	}







	// Metodo que crea la tabla Reservas
	public static boolean crearTablaReservas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Reservas (hotel String, fecha String, reservas int, fechahoy int, mes int)";
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			return false;
		}
	}
	
	//Metodo que nos dice si existe una reserva dandole un nombre de hotel
	//y una fecha y devuelve true si existe y false si no
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
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
		}
		closeBD(con);
		return resul;
	}
	
	//Metodo para modificar una reserva de la base de datos utilizando
	//el nombre del hotel y la fecha de la reserva
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
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			return false;
		}
		closeBD(con);
		return true;
	}

	// Metodo que inserta una reserva dentro de la tabla Reservas
	public static boolean insertarReserva(String hotel, String fecha, int reservas, int day, int mes) {
		String sql = "INSERT INTO Reservas VALUES('" + hotel + "','" + fecha + "'," + reservas + "," + day + "," + mes + ")";
		Connection con = initBD("Hotelea.db");
		
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			return false;
		}
		closeBD(con);
		return true;
	}
	//Metodo que devuelve todas las reservas almacenadas en la base de datos
	public static ArrayList<Reserva> getReservas() {
		Connection con = initBD("Hotelea.db");
		ArrayList<Reserva> ret = new ArrayList<>();
		try (Statement statement = con.createStatement()) {
			
			String sent = "select * from Reservas;";
			logger.log( Level.INFO, "Statement:", sent );
			ResultSet rs = statement.executeQuery( sent );
			while(rs.next()) {
				String hotel=rs.getString("hotel");
				String fecha=rs.getString("fecha");
				int reservas=rs.getInt("reservas");
				int fechahoy=rs.getInt("fechahoy");
				int mes=rs.getInt("mes");
				ret.add(new Reserva(hotel, fecha, reservas, fechahoy,mes));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
		}
		return ret;
		
	}
	
	//Metodo que devuelve una lista de precios dependiendo del tipo de hotel que estemos buscando
	public static ArrayList<Integer> getPreciosEnFuncionDelTipo(String tipo) {
		Connection con = initBD("Hotelea.db");
		try (Statement statement = con.createStatement()) {
			ArrayList<Integer> pre = new ArrayList<>();
			String sent = "select precio from Hotel where tipo = '"+tipo+"';";
			logger.log( Level.INFO, "Statement:", sent );
			ResultSet rs = statement.executeQuery( sent );
			while(rs.next()) {
				int precio=rs.getInt("precio");
				pre.add(precio);
			}
			return pre;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
		}
		return null;
		
	}
	
	//Metodo que carga los datos de reservas de prueba que hemos puesto en nuestro csv 
	//y los carga en la BD utilizando el metodo insertarreserva creado anteriormente
	public static void cargarreservasTablaCsv() {
		ArrayList<Reserva> reservas = new ArrayList<>();
		String input = "Reservas.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datos = line.split(",");
				String hotel = datos[0];
				String fecha = datos[1];
				int reserva = Integer.valueOf(datos[2]);
				int dia = Integer.valueOf(datos[3]);
				int mes = Integer.valueOf(datos[4]);
				
				
				Reserva r = new Reserva(hotel,fecha,reserva,dia,mes);
				reservas.add(r);
			}
			br.close();
			
			for(Reserva r:reservas) {
				insertarReserva(r.getCodH(),r.getFechaE(),r.getReservas(),r.getFechahoy(),r.getMes());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "ExcepciÃ³n", e );
			fail("No se han podido cargar los datos de el fichero" + input);
			
		}

	}
	
	//Metodo para que los administradores puedan añadir un hotel a la BD proporcionando
	//los datos del hotel que quieren insertar
	public static boolean insertarHotelAdmin(String nombre,String ciudad, int estrellas,int valoracion, int precio, int numHab, String tipo) {
		Connection con = initBD("Hotelea.db");
		String sql = "INSERT INTO Hotel VALUES('"+nombre+"','"+ciudad+"',"+estrellas+","+valoracion+","+precio+","+numHab+",'"+tipo+"')";
		
		try {
			Statement st = con.createStatement();
			logger.log( Level.INFO, "Statement:", sql );
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log( Level.SEVERE, "Excepcion:", e );
			return false;
			
		}
		}
		
	//Metodo que recibe una lista de listas en la que cada sublista esta rellena de precio
	//a partir de eso crea una lista de listas donde cada sublista es una lista de hoteles
		public static ArrayList<ArrayList<Hotel>> getHotelesEnFuncionDePrecios(List<List<Integer>> Combinaciones) {
			Connection con = initBD("Hotelea.db");
			try (Statement statement = con.createStatement()) {
				ArrayList<ArrayList<Hotel>> listaHoteles = new ArrayList<>();
				for(List<Integer> precios : Combinaciones) {
					
					ArrayList<Hotel> hoteles = new ArrayList<>();
					for (int precio : precios) {
						String sent = "select * from Hotel where precio = '"+precio+"';";
						logger.log( Level.INFO, "Statement:", sent );
						ResultSet rs = statement.executeQuery( sent );
						while(rs.next()) {
							String nombre=rs.getString("nombre");
							String ciudad=rs.getString("ciudad");
							int estrellas=rs.getInt("estrellas");
							int valoracion=rs.getInt("valoracion");
							int precioH = rs.getInt("precio");
							int numHab = rs.getInt("numHab");		
							String tipo= rs.getString("tipo");
							hoteles.add(new Hotel(nombre, ciudad, estrellas, valoracion, precioH, numHab, tipo));
							
						}
						listaHoteles.add(hoteles);
					}
					
			}
					
				return listaHoteles;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log( Level.SEVERE, "Excepción", e );
			}
			return null;
	

	}

	
	
	
	
	
	
}

