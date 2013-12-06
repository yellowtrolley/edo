package it.verding.edo.service;

import java.util.List;

import it.verding.edo.model.TipoCombustibile;
import it.verding.edo.model.TipoEnte;
import it.verding.edo.model.TipoTerminaleRiscaldamento;
import it.verding.edo.repositories.TipoCombustibileRepo;
import it.verding.edo.repositories.TipoEnteRepo;
import it.verding.edo.repositories.TipoTerminaleRiscaldamentoRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class QuestionarioRiscaldamentoServiceImpl implements QuestionarioRiscaldamentoService {
	@Autowired TipoEnteRepo tipoEnteRepo;
	@Autowired TipoCombustibileRepo tipoCombustibileRepo;
	@Autowired TipoTerminaleRiscaldamentoRepo tipoTerminaleRiscaldamentoRepo;
	
	@Override
	public List<TipoEnte> findAllTipoEnte() {
		return tipoEnteRepo.findAll();
	}
	@Override
	public List<TipoCombustibile> findAllTipoCombustibile() {
		return tipoCombustibileRepo.findAll();
	}
	@Override
	public List<TipoTerminaleRiscaldamento> findAllTipoTerminaleRiscaldamento() {
		return tipoTerminaleRiscaldamentoRepo.findAll();
	}
}
