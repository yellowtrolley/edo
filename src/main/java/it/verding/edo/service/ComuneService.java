package it.verding.edo.service;
import it.verding.edo.model.Comune;

import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { it.verding.edo.model.Comune.class })
public interface ComuneService {
	List<Comune> findComunesByNome(String nome);
	List<Comune> findComunesByNomeLike(String nome);
}
