package Datos;

public class Reserva {
	private String codH;		//codigo del hotel en el que se realiza la reserva
	private String dni;			//dni de la persona que reserva
	private String	fechaE;		//fecha de entreda	
	private String	fechaS;		//fecha de salida
	private int numHab;			//numero de habitaciones que se reservan
	
	public Reserva() {
		super();
	}

	public Reserva(String codH, String dni, String fechaE, String fechaS, int numHab) {
		super();
		this.codH = codH;
		this.dni = dni;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.numHab = numHab;
	}

	public String getCodH() {
		return codH;
	}

	public void setCodH(String codH) {
		this.codH = codH;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaE() {
		return fechaE;
	}

	public void setFechaE(String fechaE) {
		this.fechaE = fechaE;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	@Override
	public String toString() {
		return "Reserva [codH=" + codH + ", dni=" + dni + ", fechaE=" + fechaE + ", fechaS=" + fechaS + ", numHab="
				+ numHab + "]";
	}
}
