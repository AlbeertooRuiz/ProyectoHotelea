package hotelea;

public class Cliente {
	private String dni;		//DNI del cliente
	private String nom;		//nombre del cliente
	private String dir;		//direccion del cliente
	private String email;	//email del cliente
	private String tlfn;	//telefono del cliente
	
	public Cliente() {
		super();
	}

	public Cliente(String dni, String nom, String dir, String email, String tlfn) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.dir = dir;
		this.email = email;
		this.tlfn = tlfn;
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

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nom=" + nom + ", dir=" + dir + ", email=" + email + ", tlfn=" + tlfn + "]";
	}
}
