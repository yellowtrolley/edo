package it.verding.edo.repositories;
import it.verding.edo.domain.Comune;
import it.verding.edo.domain.Provincia;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Comune.class)
public interface ComuneRepo {
    List<Comune> findAll();
    Comune findByNomeAndProvincia(String nome, Provincia provincia);
    List<Comune> findByNomeStartingWithIgnoreCase(String nome, Pageable pageable);
}
