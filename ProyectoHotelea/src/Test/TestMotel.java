package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Datos.Motel;

public class TestMotel {
	Motel m= new Motel("A", "001", "Deusto", "Bilbao", 4, "678901234", 30,
			340, 8);
	Motel m2= new Motel();
	
	@Test
	public void testtoString() {
		assertEquals(m.toString(), "Motel [getNombre()=" + m.getNombre() + ", getCodH()=" + m.getCodH() + ", getDir()=" + m.getDir()
		+ ", getCiudad()=" + m.getCiudad() + ", getEstrellas()=" + m.getEstrellas() + ", getTlfn()=" + m.getTlfn()
		+ ", getNumHab()=" + m.getNumHab() + ", getPrecio()=" + m.getPrecio() + ", getValoracion()="
		+ m.getValoracion() + "]");
	}

}
