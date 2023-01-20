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
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class BD {

	// Metodo que realiza la conexion con la base de datos
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	// Metodo que cierra la conexion con la base de datos
	public static void closeBD(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Metodo que crea la tabla Cliente
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

	// Metodo que inserta un cliente dentro de la tabla Cliente
	public static void insertarCliente(Connection con, String DNI, String nombre, String apellidos, String usuario,
			String contrasenia) {
		String sql = "INSERT INTO Cliente VALUES('" + DNI + "','" + nombre + "','" + apellidos + "','" + usuario + "','"
				+ contrasenia + "')";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo que devuelve usuario y contrase�a de un cliente de la tabla Cliente
	// mediante la busqueda por usuario
	public static Cliente obtenerDatosCliente(Connection con, String usuario) {
		String sql = "SELECT * FROM Cliente WHERE usuario='" + usuario + "'";
		Cliente cliente = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
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

	// Metodo que crea la tabla Hotel
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
			e.printStackTrace();
			fail("No se han podido cargar los datos de el fichero" + input);
			return null;
		}

	}

	// Metodo que inserta un hotel dentro de la tabla Hotel
	public static void insertarHotel(Connection con, String nombre, String ciudad, int estrellas, int valoracion,
			int precio, int numHab) {

		String sql = "INSERT INTO Hotel VALUES('" + nombre + "','" + ciudad + "','" + estrellas + "','" + valoracion
				+ "','" + precio + "'" + numHab + "')";
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
			String linea = br.readLine();
			while (linea != br.readLine()) {
				linea = br.readLine();
				String[] elementos = linea.split(",");
				// Hotel hotel = new Hotel(elementos[0], elementos[1],
				// Integer.parseInt(elementos[2]),Integer.parseInt(elementos[3]),
				// Integer.parseInt(elementos[4]));

				String Nombre = elementos[0];
				String Ciudad = elementos[1];
				int Estrellas = Integer.parseInt(elementos[2]);
				int Valoracion = Integer.parseInt(elementos[3]);
				int Precio = Integer.parseInt(elementos[4]);

				// hoteles.add(hotel);
				// insertarHotel( con, Nombre, Ciudad, Estrellas, Valoracion, Precio);
			}
		} catch (IOException e1) {
			System.out.println("Falla fichero");

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
			e.printStackTrace();
		}
		return hoteles;

	}

	// Metodo que crea la tabla Reservas
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

	public static List<Hotel> importarCSV() {
		List<Hotel> Hoteles = new ArrayList<Hotel>();

		try {
			CsvReader leerHoteles = new CsvReader("Hoteles.csv");
			leerHoteles.readHeaders();

			while (leerHoteles.readRecord()) {
				String nombre = leerHoteles.get(0);
				String ciudad = leerHoteles.get(1);
				int estrellas = Integer.parseInt(leerHoteles.get(2));
				int valoracion = Integer.parseInt(leerHoteles.get(3));
				int precio = Integer.parseInt(leerHoteles.get(4));
				int numHab = Integer.parseInt(leerHoteles.get(5));

				Hoteles.add(new Hotel(nombre, ciudad, estrellas, valoracion, precio, numHab));
			}

			leerHoteles.close();

			System.out.println("LISTA DE Hoteles DEL CSV\n");
			for (Hotel user : Hoteles) {
				System.out.println(user.getNombre() + ", " + user.getCiudad() + ", " + user.getEstrellas() + ", "
						+ user.getValoracion() + ", " + user.getPrecio() + ", " + user.getNumHab());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Hoteles;

	}

	public static void insertarBD(List<Hotel> Hoteles) {
		System.out.println("\nSE VAN A INSERTA: " + Hoteles.size() + " REGISTROS\n");

		Connection con = initBD("Hotelea.db");

		String query = "INSERT INTO Hoteles(nombre, ciudad, estrellas, valoracion, precio, numHab) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);

			for (int i = 0; i < Hoteles.size(); i++) {
				ps.setString(1, Hoteles.get(i).getNombre());
				ps.setString(2, Hoteles.get(i).getCiudad());
				ps.setInt(3, Hoteles.get(i).getEstrellas());
				ps.setInt(4, Hoteles.get(i).getValoracion());
				ps.setInt(5, Hoteles.get(i).getPrecio());
				ps.setInt(6, Hoteles.get(i).getNumHab());

				ps.executeUpdate();

				System.out.println("Se ha insertado el elemento: " + (i + 1) + "/" + Hoteles.size());
			}
			ps.close();
			closeBD(con);
		} catch (SQLException e) {
		}
	}

	public static boolean existeReserva(String nom, String fecha) {
		boolean resul = false;
		String sql = "SELECT * FROM Reservas WHERE hotel='" + nom + "' AND fecha='" + fecha + "'";
		Connection con = initBD("Hotelea.db");
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				resul = true;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeBD(con);
		return resul;
	}

	public static void modificarReserva(String nom, String fecha) {
		String sql = "UPDATE Reservas SET reservas=reservas+1 WHERE hotel='" + nom + "' AND fecha='" + fecha + "'";
		Connection con = initBD("Hotelea.db");
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeBD(con);
	}

	// Metodo que inserta una reserva dentro de la tabla Reservas
	public static void insertarReserva(String hotel, String fecha, int reservas) {
		String sql = "INSERT INTO Reservas VALUES('" + hotel + "','" + fecha + "'," + reservas + ")";
		Connection con = initBD("Hotelea.db");
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeBD(con);
	}
}
