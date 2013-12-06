package it.verding.edo.model;

import java.util.Set;

import org.bson.types.ObjectId;
import org.pgg.mongo.mapping.Cascade;
import org.pgg.mongo.mapping.CascadeType;
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
	@Cascade(cascadeType = CascadeType.SAVE)
	private Set<Comune> comuni;
	
	public Provincia() {}

	public Provincia(String nome, Set<Comune> comuni) {
		super();
		this.nome = nome;
		this.comuni = comuni;
	}
}
