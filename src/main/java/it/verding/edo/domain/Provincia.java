package it.verding.edo.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Document
@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class Provincia {
	
	@Indexed
	private String nome;
	
	@DBRef
	private Regione regione;
	
	public Provincia() {}

	public Provincia(String nome, Regione regione) {
		super();
		this.nome = nome;
		this.regione = regione;
	}
}
