package it.verding.edo.repositories;
import it.verding.edo.domain.User;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = User.class)
public interface UserRepo {
    List<User> findAll();
}
