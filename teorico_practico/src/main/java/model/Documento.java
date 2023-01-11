package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documento")
public class Documento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddocumento;
	private int usuario;
	private String nombre;



	public int getIddocumento() {
		return iddocumento;
	}

	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
