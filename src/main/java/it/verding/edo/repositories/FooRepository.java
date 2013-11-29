package it.verding.edo.repositories;
import it.verding.edo.model.Foo;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Foo.class)
public interface FooRepository {

    List<Foo> findAll();
}
