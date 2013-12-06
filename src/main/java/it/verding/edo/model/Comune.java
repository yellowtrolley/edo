package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;

@Document
@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
public class Comune {

    @Indexed
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
