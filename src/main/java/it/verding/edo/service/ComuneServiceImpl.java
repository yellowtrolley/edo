package it.verding.edo.service;

import it.verding.edo.domain.Comune;
import it.verding.edo.repositories.ProvinciaRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class ComuneServiceImpl implements ComuneService {
	@Autowired ProvinciaRepo provinciaRepo;
	
	@Override
	public Comune findComuneByNomeAndProvincia(String nome, String nomeProvincia) {
		return comuneRepo.findByNomeAndProvincia(nome, provinciaRepo.findByNome(nomeProvincia));
	}
	
	@Override
	public List<Comune> findComunesByNomeLike(String nome) {
		return comuneRepo.findByNomeStartingWithIgnoreCase(nome, new PageRequest(0, 15, Direction.ASC, "nome"));
	}
}
