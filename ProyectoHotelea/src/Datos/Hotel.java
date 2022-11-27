package Datos;

public class Hotel {
	private String nombre;	//nombre del hotel
	private String codH;	//codigo del hotel
	private String dir;		//direccion del hotel
	private String ciudad;	//ciudad en la que se ubica el hotel
	private int estrellas;	//numero de estrellas del hotel
	private String tlfn;	//numero de telefono del hotel
	private int numHab;		//numero de habitaciones del hotel
	private int precio;		//precio por habitacion del hotel
	private int valoracion; //valoracion del hotel
	
	public Hotel() {
		super();
	}

	public Hotel(String nombre, String codH, String dir, String ciudad, int estrellas, String tlfn, int numHab,
			int precio, int valoracion) {
		super();
		this.nombre = nombre;
		this.codH = codH;
		this.dir = dir;
		this.ciudad = ciudad;
		this.estrellas = estrellas;
		this.tlfn = tlfn;
		this.numHab = numHab;
		this.precio = precio;
		this.valoracion = valoracion;
	}

	public Hotel(String nombre, int estrellas, int precio, int valoracion) {
		super();
		this.nombre = nombre;
		this.estrellas = estrellas;
		this.precio = precio;
		this.valoracion = valoracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodH() {
		return codH;
	}

	public void setCodH(String codH) {
		this.codH = codH;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setNumEstr(int numEstr) {
		this.estrellas = estrellas;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ",codH=" + codH + ", dir=" + dir + ", ciudad=" + ciudad + ", estrellas=" + estrellas + ", tlfn=" + tlfn
				+ ", numHab=" + numHab + "]";
	}
}
