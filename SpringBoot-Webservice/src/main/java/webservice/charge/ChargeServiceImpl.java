package webservice.charge;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ChargeServiceImpl implements ChargeService {

	private final ChargeRepository repository;

	@Autowired
	public ChargeServiceImpl(final ChargeRepository repository) {
		this.repository = repository;
	}

	public Charge getById(int id) {
		return repository.findOne(id);
	}

	public List<Charge> listAllCharges() {
		return repository.findAll();
	}

	@Transactional
	public Charge save(@NotNull @Valid final Charge charge) {

		Charge existing = repository.findOne(charge.getId());

		if (existing == null)
			return null;

		return repository.save(charge);
	}

	public ChargeRepository getRepository() {
		return repository;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.delete(id);
	}
}
