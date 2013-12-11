package it.verding.edo.service;

import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.domain.Soluzione;
import it.verding.edo.domain.TipoCaldaia;
import it.verding.edo.domain.TipoCombustibile;
import it.verding.edo.domain.TipoEnte;
import it.verding.edo.domain.TipoTerminaleRiscaldamento;
import it.verding.edo.repositories.TipoCombustibileRepo;
import it.verding.edo.repositories.TipoEnteRepo;
import it.verding.edo.repositories.TipoTerminaleRiscaldamentoRepo;
import it.verding.edo.util.Combustibili;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class QuestionarioRiscaldamentoServiceImpl implements QuestionarioRiscaldamentoService {
	@Autowired TipoEnteRepo tipoEnteRepo;
	@Autowired TipoCombustibileRepo tipoCombustibileRepo;
	@Autowired TipoTerminaleRiscaldamentoRepo tipoTerminaleRiscaldamentoRepo;
	
	@Override
	public List<TipoEnte> findAllTipoEnte() {
		return tipoEnteRepo.findAll();
	}
	@Override
	public List<TipoCombustibile> findAllTipoCombustibile() {
		return tipoCombustibileRepo.findAll();
	}
	@Override
	public TipoCombustibile findTipoCombustibile(String nome) {
		return tipoCombustibileRepo.findByNome(nome);
	}
	@Override
	public List<TipoTerminaleRiscaldamento> findAllTipoTerminaleRiscaldamento() {
		return tipoTerminaleRiscaldamentoRepo.findAll();
	}
	
	@Override
	public void populateSoluzioni(QuestionarioRiscaldamento questionarioRiscaldamento) {
        List<Soluzione> soluzioni = new ArrayList<>();
        
        // Soluzione 1
        TipoCaldaia tipoCaldaia1 = new TipoCaldaia("NUOVO GENERATORE ALIMENTATO A GASOLIO", findTipoCombustibile(Combustibili.GASOLIO.nome()));
        soluzioni.add(getSoluzione("SOLUZIONE 1", tipoCaldaia1, questionarioRiscaldamento, 800, 0.053));
        
        TipoCaldaia tipoCaldaia2 = new TipoCaldaia("NUOVO GENERATORE ALIMENTATO A GPL", findTipoCombustibile(Combustibili.GPL.nome()));
        soluzioni.add(getSoluzione("SOLUZIONE 2", tipoCaldaia2, questionarioRiscaldamento, 900, 0.055));
        
        TipoCaldaia tipoCaldaia3 = new TipoCaldaia("NUOVO GENERATORE ALIMENTATO AD ARIA PROPANATA", findTipoCombustibile(Combustibili.PROPANO.nome()));
        soluzioni.add(getSoluzione("SOLUZIONE 3", tipoCaldaia3, questionarioRiscaldamento, 900, 0.055));
        
        TipoCaldaia tipoCaldaia4 = new TipoCaldaia("NUOVO GENERATORE ALIMENTATO A GAS NATURALE", findTipoCombustibile(Combustibili.GAS_NATURALE.nome()));
        soluzioni.add(getSoluzione("SOLUZIONE 4", tipoCaldaia4, questionarioRiscaldamento, 1100, 0.055));
        
        questionarioRiscaldamento.setSoluzioni(soluzioni);
        
        // Best risparmio & ritorno
        double bestRisparmio, secondBestRisparmio, bestRitorno, secondBestRitorno;
        
        Collections.sort(soluzioni, new Comparator<Soluzione>() {
							@Override
							public int compare(Soluzione s0, Soluzione s1) {
								return Double.compare(s1.getRisparmioAnnuo(), s0.getRisparmioAnnuo());
							}
		});
        bestRisparmio = soluzioni.get(0).getRisparmioAnnuo();
        secondBestRisparmio = soluzioni.get(1).getRisparmioAnnuo();
        
        Collections.sort(soluzioni, new Comparator<Soluzione>() {
			@Override
			public int compare(Soluzione s0, Soluzione s1) {
				return s0.getRecuperoInvestimento() != null && s0.getRecuperoInvestimento() > 0 
						? Double.compare(s0.getRecuperoInvestimento(), s1.getRecuperoInvestimento())
						: 1;
			}
        });
        
        bestRitorno = soluzioni.get(0).getRecuperoInvestimento();
        secondBestRitorno  = soluzioni.get(1).getRecuperoInvestimento();
        
        questionarioRiscaldamento.setBestRisparmio(bestRisparmio);
        questionarioRiscaldamento.setSecondBestRisparmio(secondBestRisparmio);
        questionarioRiscaldamento.setBestRitorno(bestRitorno);
        questionarioRiscaldamento.setSecondBestRitorno(secondBestRitorno);
	}
	
	
	// TODO DARE UN NOME A PARAM1 E PARAM2. Se sono relativi al tipo caldaia inserirli nel model
	private Soluzione getSoluzione(String nome, TipoCaldaia tipoCaldaia, QuestionarioRiscaldamento questionarioRiscaldamento,
			double param1, double param2) {
		// Dati di input
        int litriAnno = questionarioRiscaldamento.getLitriCombustibileAnno();
        TipoCombustibile combustibile = questionarioRiscaldamento.getTipoCombustibile();
        int m2 = questionarioRiscaldamento.getMetri2(); // TODO * massimo valore inputabile 450 m2 ???
        double fattoreSistTermoregolazione = questionarioRiscaldamento.getIsSistemaTermoregolazione() ? 1 : 0.9;
        double fattorePiuDi10anni = questionarioRiscaldamento.getIsPiuDi10anni() ? 0.75 : 0.85;
        double spesaAnnua = litriAnno * combustibile.getCosto();
        
		Soluzione soluzione = new Soluzione(nome, tipoCaldaia, litriAnno);
		
        double costoIntervento1 = (param1 + param2 * 3 * 35 * m2) * 1.21;
        
        // nuovo consumo
        double nuovoConsumo1 = litriAnno * tipoCaldaia.getTipoCombustibile().getEnergiaPrimaria() * fattorePiuDi10anni / (0.85 * combustibile.getEnergiaPrimaria()) * fattoreSistTermoregolazione;

        // risparmio annuo (€)
        double risparmioAnnuo = spesaAnnua - soluzione.getCostoAnnuoCombustibileNuovoImpianto();
        
        // riduzione CO2 (kg/anno)
        double riduzioneCO2 = combustibile.getFattoreDiEmissione() * litriAnno * combustibile.getEnergiaPrimaria() 
        		- tipoCaldaia.getTipoCombustibile().getFattoreDiEmissione() * soluzione.getNuovoConsumo() * tipoCaldaia.getTipoCombustibile().getEnergiaPrimaria();
        
        // TODO 0.5 o 0.65? Inserire nel model? eventuali agevolazioni economiche al 50% o al 65%  (€)
        double eventualiAgevolazioniEconomiche = costoIntervento1 * 0.5;

        soluzione.setCostoIntervento(costoIntervento1);
        soluzione.setNuovoConsumo(nuovoConsumo1);
        soluzione.setRisparmioAnnuo(risparmioAnnuo);
        soluzione.setRiduzioneCO2(riduzioneCO2);
        soluzione.setCostoAnnuoCombustibileNuovoImpianto(nuovoConsumo1 * tipoCaldaia.getTipoCombustibile().getCosto());
        soluzione.setRecuperoInvestimento(costoIntervento1 / risparmioAnnuo);
        soluzione.setEventualiAgevolazioniEconomiche(eventualiAgevolazioniEconomiche);
        soluzione.setRecuperoInvestimentoConAgevolazioniConDetrazioniFiscali(costoIntervento1 / (eventualiAgevolazioniEconomiche / 10 + risparmioAnnuo));
        soluzione.setRicavo10anniConDetrazioni(risparmioAnnuo * 10 + eventualiAgevolazioniEconomiche - costoIntervento1);
        
        return soluzione;
	}
}
