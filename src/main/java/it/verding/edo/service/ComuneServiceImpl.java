package it.verding.edo.service;

import it.verding.edo.model.Comune;

import java.util.List;

public class ComuneServiceImpl implements ComuneService {
	@Override
	public List<Comune> findComunesByNome(String nome) {
		return comuneRepo.findByNome(nome);
	}
}
