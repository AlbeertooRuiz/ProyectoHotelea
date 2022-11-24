package Datos;

public class Hotel {
	private String nombre;
	private String codH;	//codigo del hotel
	private String dir;		//direccion del hotel
	private String ciudad;	//ciudad en la que se ubica el hotel
	private int numEstr;	//numero de estrellas del hotel
	private String tlfn;	//numero de telefono del hotel
	private int numHab;		//numero de habitaciones del hotel
	
	public Hotel() {
		super();
	}

	public Hotel(String nombre,String codH, String dir, String ciudad, int numEstr, String tlfn, int numHab) {
		super();
		this.nombre=nombre;
		this.codH = codH;
		this.dir = dir;
		this.ciudad = ciudad;
		this.numEstr = numEstr;
		this.tlfn = tlfn;
		this.numHab = numHab;
	}
	
	public Hotel(String nombre, int numEstr, String ciudad) {
		super();
		this.nombre=nombre;
		this.numEstr = numEstr;
		this.ciudad = ciudad;
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

	public int getNumEstr() {
		return numEstr;
	}

	public void setNumEstr(int numEstr) {
		this.numEstr = numEstr;
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
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ",codH=" + codH + ", dir=" + dir + ", ciudad=" + ciudad + ", numEstr=" + numEstr + ", tlfn=" + tlfn
				+ ", numHab=" + numHab + "]";
	}
}
