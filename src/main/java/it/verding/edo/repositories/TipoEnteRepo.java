package it.verding.edo.repositories;
import it.verding.edo.domain.TipoEnte;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = TipoEnte.class)
public interface TipoEnteRepo {

    List<TipoEnte> findAll();
}
