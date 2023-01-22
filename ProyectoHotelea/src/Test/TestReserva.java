package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Datos.Reserva;

public class TestReserva {
	
	Reserva r= new Reserva("111", "12345678", "01/01/2023", "04/01/2023", 1, 2, 4,3);
	Reserva r2= new Reserva();
	
	@Test
	public void testgetCodH() {
		assertEquals(r.getCodH(), "111");
	}
	
	@Test
	public void testsetCodH() {
		r2.setCodH("222");
		assertEquals(r2.getCodH(), "222");
	}
	
	@Test
	public void testgetDni() {
		assertEquals(r.getDni(), "12345678");
	}
	
	@Test
	public void testsetDni() {
		r2.setDni("12345679");
		assertEquals(r2.getDni(), "12345679");
	}
	
	@Test
	public void testgetFechaEntrada() {
		assertEquals(r.getFechaE(), "01/01/2023");
	}
	
	@Test
	public void testsetFechaEntrada() {
		r2.setFechaE("01/01/2024");
		assertEquals(r2.getFechaE(), "01/01/2024");
	}
	
	@Test
	public void testgetFechaSalida() {
		assertEquals(r.getFechaS(), "04/01/2023");
	}
	
	@Test
	public void testsetFechaSalida() {
		r2.setFechaS("04/01/2024");
		assertEquals(r2.getFechaS(), "04/01/2024");
	}
	
	@Test
	public void testgetNumHab() {
		assertEquals(r.getNumHab(), 1);
	}
	
	@Test
	public void testsetNumHab() {
		r2.setNumHab(2);
		assertEquals(r2.getNumHab(), 2);
	}
	
	@Test
	public void testsetReservas() {
		r2.setReservas(1);
		assertEquals(1,r2.getReservas());
	}
	
	@Test
	public void testgetReservas() {
		assertEquals(r.getReservas(),2);
	}
	
	@Test
	public void testgetfechahoy() {
		assertEquals(4,r.getFechahoy());
	}
	
	@Test
	public void testsetfechahoy() {
		r2.setFechahoy(2);
		assertEquals(r2.getFechahoy(),2);
	}
	
	@Test
	public void testgetmes() {
		assertEquals(r.getMes(),3);
	}
	
	@Test
	public void testsetmes() {
		r2.setMes(1);
		assertEquals(r2.getMes(),1);
	}
	
	@Test
	public void testtoString() {
		assertEquals(r.toString(), "Reserva [codH=" + r.getCodH() + ", dni=" + r.getDni() + ", fechaE=" + r.getFechaE() + ", fechaS=" + r.getFechaS() + ", numHab="
				+ r.getNumHab() + "]");
	}

}
