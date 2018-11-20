package webservice.evento;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EventoServiceImpl implements EventoService {

	private final EventoRepository repository;

	@Autowired
	public EventoServiceImpl(final EventoRepository repository) {
		this.repository = repository;
	}

	public Evento getById(int id) {
		return repository.findOne(id);
	}

	public List<Evento> listAllEventos() {
		return repository.findAll();
	}

	@Transactional
	public Evento save(@NotNull @Valid final Evento evento) {

		Evento existing = repository.findOne(evento.getId());

		if (existing == null)
			return null;

		return repository.save(evento);
	}

	public EventoRepository getRepository() {
		return repository;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.delete(id);
	}
}
