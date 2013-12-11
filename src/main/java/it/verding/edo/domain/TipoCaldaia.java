package it.verding.edo.domain;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class TipoCaldaia {
	/*
	 * Nome
	 */
	private String nome;
	
	/*
	 * Tipo combustibile
	 */
	private TipoCombustibile tipoCombustibile;

	public TipoCaldaia(String nome, TipoCombustibile tipoCombustibile) {
		super();
		this.nome = nome;
		this.tipoCombustibile = tipoCombustibile;
	}
	
}
