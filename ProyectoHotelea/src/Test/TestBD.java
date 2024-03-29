package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
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
	

	
	@Test
	public void testModificarReserva() {
		bd.insertarReserva("Barcleo", "12/02/03", 1,new Date(System.currentTimeMillis()).getDay(), new Date(System.currentTimeMillis()).getMonth());
		assertTrue(bd.modificarReserva("Barcleo", "12/02/03"));
	}
	
	@Test
	public void testInsertarReserva() {
		assertTrue(bd.insertarReserva("Barcleo", "12/02/03", 1,new Date(System.currentTimeMillis()).getDay(),new Date(System.currentTimeMillis()).getMonth()));
	}
	
	@Test
	public void testExistereserva() {
		bd.insertarReserva("Barcleo", "12/02/03", 1,new Date(System.currentTimeMillis()).getDay(),new Date(System.currentTimeMillis()).getMonth());
		assertTrue(bd.existeReserva("Barcleo", "12/02/03"));
	}
	
	@Test
	public void testgetReservas() {
		
	}

}
