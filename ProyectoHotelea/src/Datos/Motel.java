package Datos;

public class Motel extends Hotel{
	
	
	public Motel() {
		super();
	}
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
	 */
	public Motel(String nombre, String codH, String dir, String ciudad, int estrellas, String tlfn, int numHab,
			int precio, int valoracion) {
		super();
		
	}
	@Override
	public String toString() {
		return "Motel [getNombre()=" + getNombre() + ", getCodH()=" + getCodH() + ", getDir()=" + getDir()
				+ ", getCiudad()=" + getCiudad() + ", getEstrellas()=" + getEstrellas() + ", getTlfn()=" + getTlfn()
				+ ", getNumHab()=" + getNumHab() + ", getPrecio()=" + getPrecio() + ", getValoracion()="
				+ getValoracion() + "]";
	}
	
	
}
