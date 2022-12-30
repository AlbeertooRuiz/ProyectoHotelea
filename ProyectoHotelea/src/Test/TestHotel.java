package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Datos.Hotel;

public class TestHotel {
	
	Hotel h= new Hotel("Melia", "111", "Deusto", "Bilbao", 3, "678901234", 250, 40, 8);
	Hotel h2= new Hotel();
	
	@Test
	public void testgetNombre() {
		assertEquals(h.getNombre(), "Melia");
	}
	
	@Test
	public void testsetNombre() {
		h2.setNombre("Gran Bilbao");
		assertEquals(h2.getNombre(), "Gran Bilbao");
	}
	
	@Test
	public void testgetCodH() {
		assertEquals(h.getCodH(), "111");
	}
	
	@Test
	public void testsetCodH() {
		h2.setCodH("222");
		assertEquals(h2.getCodH(), "222");
	}
	
	@Test
	public void testgetDireccion() {
		assertEquals(h.getDir(), "Deusto");
	}
	
	@Test
	public void testsetDireccion() {
		h2.setDir("Indautxu");
		assertEquals(h2.getDir(), "Indautxu");
	}
	
	@Test
	public void testgetCiudad() {
		assertEquals(h.getCiudad(), "Bilbao");
	}
	
	@Test
	public void testsetCiudad() {
		h2.setCiudad("Bilbo");
		assertEquals(h2.getCiudad(), "Bilbo");
	}
	
	@Test
	public void testgetEstrellas() {
		assertEquals(h.getEstrellas(), 3);
	}
	
	@Test
	public void testsetEstrellas() {
		h2.setEstrellas(2);
		assertEquals(h2.getEstrellas(), 2);
	}
	
	@Test
	public void testgetTelefono() {
		assertEquals(h.getTlfn(), "678901234");
	}
	
	@Test
	public void testsetTelefono() {
		h2.setTlfn("612345678");
		assertEquals(h2.getTlfn(), "612345678");
	}
	
	@Test
	public void testgetNumHabitaciones() {
		assertEquals(h.getNumHab(), 250);
	}
	
	@Test
	public void testsetNumHab() {
		h2.setNumHab(300);
		assertEquals(h2.getNumHab(), 300);
	}
	
	@Test
	public void testgetPrecio() {
		assertEquals(h.getPrecio(), 40);
	}
	
	@Test
	public void testsetPrecio() {
		h2.setPrecio(50);
		assertEquals(h2.getPrecio(), 50);
	}
	
	@Test
	public void testgetValoracion() {
		assertEquals(h.getValoracion(), 8);
	}
	
	@Test
	public void testsetValoracion() {
		h2.setValoracion(9);
		assertEquals(h2.getValoracion(), 9);
	}
	
	@Test
	public void testtoString() {
		assertEquals(h.toString(), "Hotel [nombre=" + h.getNombre() + ",codH=" + h.getCodH() + ", dir=" + h.getDir() + ", ciudad=" + h.getCiudad() + ", estrellas=" + h.getEstrellas() + ", tlfn=" + h.getTlfn()
				+ ", numHab=" + h.getNumHab() + "]");
	}
	

}
