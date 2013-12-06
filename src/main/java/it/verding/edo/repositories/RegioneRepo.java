package it.verding.edo.repositories;
import it.verding.edo.model.Regione;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Regione.class)
public interface RegioneRepo {

    List<Regione> findAll();
}
