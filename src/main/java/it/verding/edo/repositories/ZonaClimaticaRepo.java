package it.verding.edo.repositories;
import it.verding.edo.domain.ZonaClimatica;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = ZonaClimatica.class)
public interface ZonaClimaticaRepo {

    List<ZonaClimatica> findAll();
    ZonaClimatica findByNome(String nome);
}
