package it.verding.edo.repositories;
import it.verding.edo.domain.QuestionarioRiscaldamento;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = QuestionarioRiscaldamento.class)
public interface QuestionarioRiscaldamentoRepo {

    List<QuestionarioRiscaldamento> findAll();
}
