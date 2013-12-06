package it.verding.edo.repositories;
import it.verding.edo.model.TipoCombustibile;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = TipoCombustibile.class)
public interface TipoCombustibileRepo {

    List<TipoCombustibile> findAll();
}
