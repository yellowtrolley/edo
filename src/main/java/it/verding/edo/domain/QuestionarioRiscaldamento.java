package it.verding.edo.domain;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class QuestionarioRiscaldamento {
	@DBRef private TipoEnte tipoEnte;
	@DBRef private Comune comune;
	@DBRef private TipoCombustibile tipoCombustibile;
	@DBRef private TipoTerminaleRiscaldamento tipoTerminaleRiscaldamento;
	private Integer metri2;
	private Integer litriCombustibileAnno;
	private Boolean isSistemaTermoregolazione;
	private Boolean isPiuDi10anni;
	private Double bestRisparmio;
	private Double secondBestRisparmio;
	private Double bestRitorno;
	private Double secondBestRitorno;
	private List<Soluzione> soluzioni;
}
