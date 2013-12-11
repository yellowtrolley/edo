package it.verding.edo.service;
import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.domain.TipoCombustibile;
import it.verding.edo.domain.TipoEnte;
import it.verding.edo.domain.TipoTerminaleRiscaldamento;

import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { it.verding.edo.domain.QuestionarioRiscaldamento.class })
public interface QuestionarioRiscaldamentoService {
	List<TipoEnte> findAllTipoEnte();
	List<TipoCombustibile> findAllTipoCombustibile();
	TipoCombustibile findTipoCombustibile(String nome);
	List<TipoTerminaleRiscaldamento> findAllTipoTerminaleRiscaldamento();
	void populateSoluzioni(QuestionarioRiscaldamento questionarioRiscaldamento);
}
