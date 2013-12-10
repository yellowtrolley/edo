package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class TipoTerminaleRiscaldamento {
	private String nome;

	public TipoTerminaleRiscaldamento() {}

	public TipoTerminaleRiscaldamento(String nome) {
		this.nome = nome;
	}
}
