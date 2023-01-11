package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email")
public class Email {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idemail;
	private int usuario;
	private String destinatario;



	public int getIdemail() {
		return idemail;
	}

	public void setIdemail(int idemail) {
		this.idemail = idemail;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

}
