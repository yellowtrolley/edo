package it.verding.edo.repositories;
import it.verding.edo.model.Comune;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Comune.class)
public interface ComuneRepository {

    List<Comune> findAll();
}
