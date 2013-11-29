package it.verding.edo.repositories;
import it.verding.edo.model.Bar;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Bar.class)
public interface BarRepository {

    List<Bar> findAll();
}
