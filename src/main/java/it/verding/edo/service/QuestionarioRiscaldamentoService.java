package it.verding.edo.service;
import it.verding.edo.model.QuestionarioRiscaldamento;
import it.verding.edo.model.TipoCombustibile;
import it.verding.edo.model.TipoEnte;
import it.verding.edo.model.TipoTerminaleRiscaldamento;

import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { it.verding.edo.model.QuestionarioRiscaldamento.class })
public interface QuestionarioRiscaldamentoService {
	List<TipoEnte> findAllTipoEnte();
	List<TipoCombustibile> findAllTipoCombustibile();
	TipoCombustibile findTipoCombustibile(String nome);
	List<TipoTerminaleRiscaldamento> findAllTipoTerminaleRiscaldamento();
	void populateSoluzioni(QuestionarioRiscaldamento questionarioRiscaldamento);
}
