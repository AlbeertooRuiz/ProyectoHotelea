package Datos;

public class Hostel extends Hotel{
	
	private int camasPorHab;
	
	//Constructor vacio de Hostel
	/**
	 * 
	 */
	public Hostel() {
		super();
	}
	
	//Constructor de Hostel
	/**
	 * 
	 * @param nombre nombre del hostel
	 * @param codH codigo del hostel
	 * @param dir direccion del hostel
	 * @param ciudad ciudad donde se situa el hostel
	 * @param estrellas estrellas que tiene el hostel
	 * @param tlfn telefono de contacto del hostel
	 * @param numHab numero de habitaciones del hostel
	 * @param precio precio por noche del hostel
	 * @param valoracion valoracion del hotel
	 * @param camasPorHab camas por habitacion por hotel
	 */
	public Hostel(String nombre, String codH, String dir, String ciudad, int estrellas, String tlfn, int numHab,
			int precio, int valoracion,int camasPorHab) {
		super();
		this.camasPorHab=camasPorHab;
	}

	public int getCamasPorHab() {
		return camasPorHab;
	}

	public void setCamasPorHab(int camasPorHab) {
		this.camasPorHab = camasPorHab;
	}

	@Override
	public String toString() {
		return "Hostel [camasPorHab=" + camasPorHab + "]";
	}
	

}
