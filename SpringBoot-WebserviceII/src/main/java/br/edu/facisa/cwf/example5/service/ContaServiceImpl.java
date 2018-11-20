package br.edu.facisa.cwf.example5.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.facisa.cwf.example5.domain.Conta;
import br.edu.facisa.cwf.example5.repository.ContaRepository;


@Service
@Validated
public class ContaServiceImpl implements ContaService{
	
	private ContaRepository contaRepository;
	
	@Autowired
	public ContaServiceImpl(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@Transactional
	public Conta save(@NotNull @Valid Conta conta) {
		Conta existing = contaRepository.findOne(conta.getId());

		if (existing != null)
			return null;

		return contaRepository.save(conta);
	}

	@Override
	public Conta getById(int id) {
		return contaRepository.findOne(id);
	}

	@Override
	public Conta getByName(String nome) {
		return contaRepository.findByName(nome);
	}

	@Override
	public List<Conta> listAllContas() {
		return contaRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		contaRepository.delete(id);
	}
	
	

}
