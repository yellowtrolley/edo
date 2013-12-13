package it.verding.edo.repositories;
import it.verding.edo.domain.TipoGeneratore;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = TipoGeneratore.class)
public interface TipoGeneratoreRepo {
	List<TipoGeneratore> findAll();
	TipoGeneratore findByNome(String nome);	
}
