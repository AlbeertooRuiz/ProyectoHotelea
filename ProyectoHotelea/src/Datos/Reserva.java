package Datos;

public class Reserva {
	private String codH;		//codigo del hotel en el que se realiza la reserva
	private String dni;			//dni de la persona que reserva
	private String	fechaE;		//fecha de entreda	
	private String	fechaS;		//fecha de salida
	private int numHab;			//numero de habitaciones que se reservan
	private int reservas;		//numero de reservas
	private int fechahoy;		//numero del dia de la semana de la reserva
	private int mes;			//numero del mes de la reserva
	
	//Constructor vacio de Reserva
	public Reserva() {
		super();
	}
	
	
	//Constructor de Reserva
	/**
	 * 
	 * @param codH codigo de hotel
	 * @param dni dni de la persona que reserva
	 * @param fechaE fecha de entreda
	 * @param fechaS fecha de salida
	 * @param numHab numero de habitaciones que se reservan
	 * @param reservas numero de reservas
	 * @param fechahoy numero del dia de la semana de la reserva
	 * @param mes numero del mes de la reserva
	 */
	public Reserva(String codH, String dni, String fechaE, String fechaS, int numHab, int reservas, int fechahoy, int mes) {
		super();
		this.codH = codH;
		this.dni = dni;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
		this.numHab = numHab;
		this.reservas = reservas;
		this.fechahoy = fechahoy;
		this.mes=mes;
	}
	/**
	 * 
	 * @param codH codigo de hotel
	 * @param fechaE fecha de entreda
	 * @param reservas numero de reservas
	 * @param fechahoy numero del dia de la semana de la reserva
	 * @param mes numero del mes de la reserva
	 */
	public Reserva(String codH,String fechaE,int reservas,int fechahoy, int mes) {
		super();
		this.codH=codH;
		this.fechaE = fechaE;
		this.reservas = reservas;
		this.fechahoy = fechahoy;
		this.mes= mes;
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
	
	

	public int getReservas() {
		return reservas;
	}

	public void setReservas(int reservas) {
		this.reservas = reservas;
	}

	public int getFechahoy() {
		return fechahoy;
	}

	public void setFechahoy(int fechahoy) {
		this.fechahoy = fechahoy;
	}
	
	
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Reserva [codH=" + codH + ", dni=" + dni + ", fechaE=" + fechaE + ", fechaS=" + fechaS + ", numHab="
				+ numHab + "]";
	}
}
