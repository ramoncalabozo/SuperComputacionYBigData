package model;

public class Item {
	/*Si queremos que json lo mapee automaticamente tenemis que ponerle
	 * los mismos nombres a los atributos de la clase del objeto que llegara*/
	private int idContacto;
	private String nombre;
	private String email;
	private int edad;
	
	public Item() {}
	
	public Item(int idContacto, String nombre, String email, int edad) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
