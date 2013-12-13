package it.verding.edo.service;
import it.verding.edo.domain.Comune;

import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { it.verding.edo.domain.Comune.class })
public interface ComuneService {
	Comune findComuneByNomeAndProvincia(String nome, String nomeProvincia);
	List<Comune> findComunesByNomeLike(String nome);
}
