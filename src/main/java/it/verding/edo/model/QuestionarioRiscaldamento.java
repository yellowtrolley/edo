package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class QuestionarioRiscaldamento {
	private TipoEnte tipoEnte;
	private Comune comune;
	private TipoCombustibile tipoCombustibile;
	private TipoTerminaleRiscaldamento tipoTerminaleRiscaldamento;
	private Integer metri2;
	private Integer litriCombustibileAnno;
	private Boolean isSistemaTermoregolazione;
	private Boolean isPiuDi10anni;
}
