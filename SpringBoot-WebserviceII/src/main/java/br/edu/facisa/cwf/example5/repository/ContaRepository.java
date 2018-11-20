package br.edu.facisa.cwf.example5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.facisa.cwf.example5.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	public Conta findById(int id);
	public Conta findByName(String name);

}
