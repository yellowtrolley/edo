package it.verding.edo.repositories;
import it.verding.edo.model.TipoTerminaleRiscaldamento;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = TipoTerminaleRiscaldamento.class)
public interface TipoTerminaleRiscaldamentoRepo {

    List<TipoTerminaleRiscaldamento> findAll();
}
