package Datos;

import java.util.ArrayList;
import java.util.List;

import Ventanas.VentanaCombinaciones;

public class Hotel implements Combinaciones{
	private String nombre;	//nombre del hotel
	private String codH;	//codigo del hotel
	private String dir;		//direccion del hotel
	private String ciudad;	//ciudad en la que se ubica el hotel
	private int estrellas;	//numero de estrellas del hotel
	private String tlfn;	//numero de telefono del hotel
	private int numHab;		//numero de habitaciones del hotel
	private int precio;		//precio por habitacion del hotel
	private int valoracion; //valoracion del hotel
	private String tipo;
	
	//Constructor de Hotel
	public Hotel() {
		super();
	}
	
	//Constructor de Hotel
	/**
	 * 
	 * @param nombre Nombre del hotel
	 * @param codH Codigo del hotel(Será único para cada hotel)
	 * @param dir Direccion del hotel
	 * @param ciudad Ciudad donde esta situado el hotel
	 * @param estrellas Estrellas del hotel
	 * @param tlfn Teléfono de comntacto del hotel
	 * @param numHab Número de habitaciones del hotel
	 * @param precio Precio de la habitación por noche
	 * @param valoracion Valoracion del hotel
	 * @param tipo Tipo de hotel
	 */
	public Hotel(String nombre, String codH, String dir, String ciudad, int estrellas, String tlfn, int numHab,
			int precio, int valoracion, String tipo) {
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
		this.tipo = tipo;
	}

	public Hotel(String nombre, String ciudad, int estrellas, int valoracion, int precio, int numHab, String tipo) {
		super();
		this.nombre = nombre;
		this.estrellas = estrellas;
		this.ciudad = ciudad;
		this.valoracion = valoracion;
		this.precio = precio;
		this.tipo = tipo;
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

	public void setEstrellas(int estrellas) {
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
	

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", codH=" + codH + ", dir=" + dir + ", ciudad=" + ciudad + ", estrellas="
				+ estrellas + ", tlfn=" + tlfn + ", numHab=" + numHab + ", precio=" + precio + ", valoracion="
				+ valoracion + ", tipo=" + tipo + "]";
	}
	String a = "Hotel";


	@Override
	public List<List<Integer>> combinacionesRecursivas(ArrayList<Integer> precios, int i) {
		// TODO Auto-generated method stub
		return null;
	}


}
