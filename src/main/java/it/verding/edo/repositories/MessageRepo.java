package it.verding.edo.repositories;
import it.verding.edo.domain.Message;

import java.util.List;

import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Message.class)
public interface MessageRepo {
    List<Message> findAll();
}
