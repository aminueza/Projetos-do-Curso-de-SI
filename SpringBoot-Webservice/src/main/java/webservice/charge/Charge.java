package webservice.charge;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="charge")
public class Charge implements Serializable {
	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "titulo", nullable = true, length = 500)
	private String titulo;
	@Column(name = "imagem", nullable = true)
	private String imagem;
	
	public Charge () {}

	public Charge(int id, String titulo, String imagem) {
		this.id = id;
		this.titulo = titulo;
		this.imagem = imagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
