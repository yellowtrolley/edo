package it.verding.edo.repositories;
import it.verding.edo.model.Provincia;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Provincia.class)
public interface ProvinciaRepo {

    List<Provincia> findAll();
}
