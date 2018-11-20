package logica;

public class Curso {

	private int idDoCurso;
	private String nome;
	private String area;

	
	public Curso(int idDoCurso, String nome, String area) {
		super();
		this.idDoCurso = idDoCurso;
		this.nome = nome;
		this.area = area;
	}

	public int getIdDoCurso() {
		return idDoCurso;
	}

	public String getNome() {
		return nome;
	}

	public String getArea() {
		return area;
	}

}
