package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Datos.Hostel;

public class TestHostel {
	
	Hostel h= new Hostel("Melia", "111", "Deusto", "Bilbao", 3, "678901234", 250, 40, 8,4);
	Hostel h2= new Hostel();
	
	@Test
	public void testgetcamasporhab() {
		assertEquals(4,h.getCamasPorHab());
	}
	
	@Test
	public void testsetcamasporhab() {
		h2.setCamasPorHab(3);
		assertEquals(3,h2.getCamasPorHab());
	}
	
	@Test
	public void testtostring() {
		assertEquals(h.toString(),"Hostel [camasPorHab=" + h.getCamasPorHab() + "]");
	}
	
	

}
