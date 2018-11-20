package logica;
public class JogosDigitais extends Curso {

	private long cargaHoraria;

	public JogosDigitais(int idDoCurso, String nome, String area, long cargaHoraria) {
		super(idDoCurso, nome, area);
		this.cargaHoraria = cargaHoraria;
	}
	
	public long getCargaHoraria() {
		return cargaHoraria;
	}

}
