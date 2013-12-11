package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class TipoCombustibile {
	private String nome;
	
	/*
	 * Costo (€/litro)
	 */
	private Double costo;
	
	/*
	 * Energia primaria (kWh/l o m3)
	 */
	private Double energiaPrimaria;
	
	/*
	 * Fattore di emissione (kgCO2/kWh)
	 */
	private Double fattoreDiEmissione;

	public TipoCombustibile() {}

	public TipoCombustibile(String nome, Double costo, Double energiaPrimaria,
			Double fattoreDiEmissione) {
		super();
		this.nome = nome;
		this.costo = costo;
		this.energiaPrimaria = energiaPrimaria;
		this.fattoreDiEmissione = fattoreDiEmissione;
	}
}
