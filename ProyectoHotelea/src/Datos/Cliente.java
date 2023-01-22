package Datos;

public class Cliente {
	private String dni;				//DNI del cliente
	private String nom;				//nombre del cliente
	private String dir;				//direccion del cliente
	private String email;			//email del cliente
	private String tlfn;			//telefono del cliente
	private String usuario;			//usuario del cliente
	private String contrasenia;		//contrase�a del cliente
	
	//Constructor vacio de cliente
	/**
	 * 
	 */
	public Cliente() {
		super();
	}

	//Constructor de cliente
	/**
	 * 
	 * @param dni dni del cliente
	 * @param nom nombre del clente
	 * @param dir direccion del cliente
	 * @param email email del cliente
	 * @param tlfn telefono del cliente
	 * @param usuario nombre de usuario del cliente
	 * @param contrasenia contrasenia del cliente
	 */
	public Cliente(String dni, String nom, String dir, String email, String tlfn, String usuario, String contrasenia) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.dir = dir;
		this.email = email;
		this.tlfn = tlfn;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	/**
	 * 
	 * @param usuario nombre de usuario del cliente
	 * @param contrasenia contrasenia del cliente
	 */
	public Cliente(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nom=" + nom + ", dir=" + dir + ", email=" + email + ", tlfn=" + tlfn + "]";
	}
}
