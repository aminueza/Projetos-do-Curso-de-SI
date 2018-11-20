package logica;
public class SistemasDeInformacao extends Curso {

	private long cargaHoraria;

	public SistemasDeInformacao(int idDoCurso, String nome, String area, long cargaHoraria) {
		super(idDoCurso, nome, area);
		this.cargaHoraria = cargaHoraria;
	}

	public void setCargaHoraria(long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
