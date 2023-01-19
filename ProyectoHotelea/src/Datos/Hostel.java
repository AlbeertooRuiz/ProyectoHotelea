package Datos;

public class Hostel extends Hotel{
	
	private int camasPorHab;
	
	public Hostel() {
		super();
	}
	
	public Hostel(String nombre, String codH, String dir, String ciudad, int estrellas, String tlfn, int numHab,
			int precio, int valoracion,int camasPorHab) {
		super();
		this.camasPorHab=camasPorHab;
	}
	

}
