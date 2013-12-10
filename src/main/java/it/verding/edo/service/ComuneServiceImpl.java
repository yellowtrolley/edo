package it.verding.edo.service;

import it.verding.edo.model.Comune;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class ComuneServiceImpl implements ComuneService {
	@Override
	public List<Comune> findComunesByNome(String nome) {
		return comuneRepo.findByNome(nome);
	}
	
	@Override
	public List<Comune> findComunesByNomeLike(String nome) {
		return comuneRepo.findByNomeStartingWithIgnoreCase(nome, new PageRequest(0, 10, Direction.ASC, "nome"));
	}
}
