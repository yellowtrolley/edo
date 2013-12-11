package it.verding.edo.model;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class Soluzione {
	/*
	 * Nome
	 */
	private String nome;
	
	/*
	 * litri / anno
	 */
	private int litriAnno;
	
	/*
	 * Tipo di Caldaia
	 */
	private TipoCaldaia tipoCaldaia;

	/*
	 * Costo intervento (€)
	 */
    private Double costoIntervento;
    
    /*
     * Nuovo consumo (litri o kg o  kWh)
     */
    private Double nuovoConsumo;
    
    /*
     * Costo annuo combustiobile nuovo impianto
     */
    private Double costoAnnuoCombustibileNuovoImpianto;
    
    /*
     * Risparmio annuo (€)
     */
    private Double risparmioAnnuo;
    
    /*
     * Recupero dell'investimento (anni)
     */
    private Double recuperoInvestimento;
    
    /*
     * Riduzione CO2 (kg/anno)
     */
    private Double riduzioneCO2;
    
    /*
     * Eventuali agevolazioni economiche al 50% o al 65%  (€)
     */
    private Double eventualiAgevolazioniEconomiche;
    
    /*
     * Eventuale agevoazione economica con conto termico (€)
     */
    private Double eventualiAgevolazioniEconomicheContoTermico;
    
    /*
     * Recupero investimento con agevolazioni con detrazioni fiscali (anni)
     */
    private Double recuperoInvestimentoConAgevolazioniConDetrazioniFiscali;
    
    /*
     * Recupero investimento con agevolazioni con conto termico (anni)
     */
    private Double recuperoInvestimentoConAgevolazioniConContoTermico; 
    
    /*
     * RICAVO DOPO 10 ANNI AL NETTO DELLA SPESA INIZIALE con detrazioni (€)
     */
    private Double ricavo10anniConDetrazioni;
    
    /*
     * RICAVO DOPO 10 ANNI AL NETTO DELLA SPESA INIZIALE con detrazioni (€)
     */
    private Double ricavo10anniConContoTermico;
    
    
    public Soluzione(String nome, TipoCaldaia tipoCaldaia, int litriAnno) {
    	this.nome = nome;
		this.tipoCaldaia = tipoCaldaia;
		this.litriAnno = litriAnno;
		this.tipoCaldaia = tipoCaldaia;
	}
}