package Test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import Datos.Cliente;

public class TestCliente {
	
	Cliente c= new Cliente("12345678", "Paco", "Deusto", "paco@gmail.com", "678901234", "paco123", "hola");
	Cliente c2= new Cliente();
	
	@Test
	public void testgetDni() {
		assertEquals(c.getDni(),"12345678");
	}
	
	@Test
	public void testsetDni() {
		c2.setDni("09876543");
		assertEquals(c2.getDni(),"09876543");
	}
	
	@Test
	public void testgetNombre() {
		assertEquals(c.getNom(),"Paco");
	}
	
	@Test
	public void testsetNombre() {
		c2.setNom("Ander");
		assertEquals(c2.getNom(),"Ander");
	}
	
	@Test
	public void testgetDireccion() {
		assertEquals(c.getDir(),"Deusto");
	}
	
	@Test
	public void testsetDireccion() {
		c2.setDir("Indautxu");
		assertEquals(c2.getDir(),"Indautxu");
	}
	
	@Test
	public void testgetEmail() {
		assertEquals(c.getEmail(),"paco@gmail.com");
	}
	
	@Test
	public void testsetEmail() {
		c2.setEmail("ander@gmail.com");
		assertEquals(c2.getEmail(),"ander@gmail.com");
	}
	
	@Test
	public void testgetTelefono() {
		assertEquals(c.getTlfn(),"678901234");
	}
	
	@Test
	public void testsetTelefono() {
		c2.setTlfn("612345678");
		assertEquals(c2.getTlfn(),"612345678");
	}
	
	@Test
	public void testgetUsuario() {
		assertEquals(c.getUsuario(),"paco123");
	}
	
	@Test
	public void testsetUsuario() {
		c2.setUsuario("ander789");
		assertEquals(c2.getUsuario(),"ander789");
	}
	
	@Test
	public void testgetContrasenia() {
		assertEquals(c.getContrasenia(),"hola");
	}
	
	@Test
	public void testsetContrasenia() {
		c2.setContrasenia("adios");
		assertEquals(c2.getContrasenia(),"adios");
	}
	
	@Test
	public void testtoString() {
		assertEquals(c.toString(),"Cliente [dni=" + c.getDni() + ", nom=" + c.getNom() + ", dir=" + c.getDir() + ", email=" + c.getEmail() + ", tlfn=" + c.getTlfn() + "]");
	}

}
