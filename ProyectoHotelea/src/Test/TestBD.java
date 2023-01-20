package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.BD;
import Datos.Cliente;
import Datos.Hotel;

public class TestBD {
	BD bd= new BD();
	Connection con= BD.initBD("Hotelea.db");
	
	@Before
	public void abrirConexion() {
		bd.initBD("Hotelea.db");
	}
	
	@After
	public void cerrarConexion() {
		bd.closeBD(con);
	}
	
	@Test
	public void testCrearTablaCliente() {
		assertTrue(bd.crearTablaCliente(con));
	}
	
	@Test
	public void testInsertarCliente() {
		assertTrue(bd.insertarCliente(con, "12345678S", "Jon", "Ayo Martin", "jon123", "1234"));
	}
	
	@Test
	public void testObtenerDatosCliente() {
		bd.insertarCliente(con, "12345678S", "Jon", "Ayo Martin", "jon123", "1234");
		assertEquals(bd.obtenerDatosCliente(con, "jon123").getUsuario(),"jon123");
		assertEquals(bd.obtenerDatosCliente(con, "jon123").getContrasenia(),"1234");
	}
	
	@Test
	public void creartablahotel() {
		assertTrue(bd.crearTablaHotel(con));
	}
	
	@Test
	public void creartablareservas() {
		assertTrue(bd.crearTablaReservas(con));
	}
	
	//comprobamos que se carguen los hoteles de nuestro fichero csv comprobando el tamaño(25)
	//y que el primer hotel es el barcelo
	@Test
	public void testcargarhotelescsv() {
		ArrayList<Hotel> hoteles=bd.cargarHotelesTablaCsv();
		assertEquals(25,hoteles.size());	
		assertEquals(hoteles.get(0).getNombre(),"Barcelo");
	}
	
	//@Test
	//public void testInsertarHotel() {
	//	assertFalse(bd.insertarHotel(con, "Barcelo", "Cuenca", 4, 9, 140, 300));
	//}
	
	//@Test
	//public void testObtenerListaHoteles() {
	//	ArrayList<Hotel> hoteles=bd.obtenerListaHoteles(con);
	//	assertEquals(25,hoteles.size());
	//}
	
	//@Test
	//public void testReservahotel() {
	//	assertFalse(bd.reservaHotel(con));
	//}
	
	//@Test
	//public void testInsertarBD() {
	//	List<Hotel> hoteles= new ArrayList<Hotel>();
	//	hoteles.add(new Hotel("Barcelo", "Cuenca", 3, 9, 340, 300));
	//	hoteles.add(new Hotel("Barcelo2", "bilbao", 4, 5, 100, 100));
 	//	assertFalse(bd.insertarBD(hoteles));
	//}
	
	@Test
	public void testModificarReserva() {
		bd.insertarReserva("Barcleo", "12/02/03", 1);
		assertTrue(bd.modificarReserva("Barcleo", "12/02/03"));
	}
	
	@Test
	public void testInsertarReserva() {
		assertTrue(bd.insertarReserva("Barcleo", "12/02/03", 1));
	}
	
	@Test
	public void testExistereserva() {
		bd.insertarReserva("Barcleo", "12/02/03", 1);
		assertTrue(bd.existeReserva("Barcleo", "12/02/03"));
	}

}
