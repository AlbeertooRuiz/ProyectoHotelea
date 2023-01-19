package Test;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.BD;

public class TestBD {
	BD bd= new BD();
	Connection con;
	
	@Before
	public void abrirConexion() {
		bd.initBD("Hotelea.db");
	}
	
	@After
	public void cerrarConexion() {
		bd.closeBD(con);
	}
	
	@Test
	public void test() {
		
	}

}
