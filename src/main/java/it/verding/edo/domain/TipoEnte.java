package it.verding.edo.domain;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class TipoEnte {
	private String nome;
	
	public TipoEnte() {}

	public TipoEnte(String nome) {
		this.nome = nome;
	}
}
