package webservice.informativo;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class InformativoServiceImpl implements InformativoService {

    private final InformativoRepository repository;

    @Autowired
    public InformativoServiceImpl(final InformativoRepository repository) {
        this.repository = repository;
    }
    
    public Informativo getById(int id) {    
    	return repository.findOne(id);
    }
    
	public List<Informativo> listAllInformativos() {
		return repository.findAll();
	}
	
    @Transactional
    public Informativo save(@NotNull @Valid final Informativo informativo) {
    	
        Informativo existing = repository.findOne(informativo.getId());
        
        if (existing == null)
            return null;
        
        return repository.save(informativo);
    }

	public InformativoRepository getRepository() {
		return repository;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.delete(id);
	}
}
