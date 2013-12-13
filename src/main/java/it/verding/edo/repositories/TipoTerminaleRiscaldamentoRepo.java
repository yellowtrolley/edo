package it.verding.edo.repositories;
import it.verding.edo.domain.TipoTerminaleRiscaldamento;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = TipoTerminaleRiscaldamento.class)
public interface TipoTerminaleRiscaldamentoRepo {
    List<TipoTerminaleRiscaldamento> findAll();
    TipoTerminaleRiscaldamento findByNome(String nome);
}
