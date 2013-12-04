package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class ZonaClimatica {
	private String nome;
	private Integer valoreDaContoTermico;

	public ZonaClimatica(String nome, Integer valoreDaContoTermico) {
		this.nome = nome;
		this.valoreDaContoTermico = valoreDaContoTermico;
	}

	public ZonaClimatica() {
	}
}
