package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class Comune {
    private String nome;
    private Integer altSLM;
    private Integer gradiGiorno; // Gradi giorno
    @DBRef
    private ZonaClimatica zonaClimatica;
    

    public Comune() {
	}

	public Comune(String nome, Integer altSLM, Integer gg, ZonaClimatica zonaClimatica) {
		this.nome = nome;
		this.altSLM = altSLM;
		this.gradiGiorno = gg;
		this.zonaClimatica = zonaClimatica;
	}
}
