package it.verding.edo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Document
@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class Regione {
	
	@Indexed(unique = true)
	private String nome;
	
//	@DBRef
//	@Cascade(cascadeType = CascadeType.SAVE)
//	private Set<Provincia> provincie;

	public Regione() {}

	public Regione(String nome) {
		this.nome = nome;
	}

}
