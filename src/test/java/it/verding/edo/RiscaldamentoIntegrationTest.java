package it.verding.edo;

import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;
import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.domain.Soluzione;
import it.verding.edo.repositories.TipoCombustibileRepo;
import it.verding.edo.repositories.TipoEnteRepo;
import it.verding.edo.repositories.TipoTerminaleRiscaldamentoRepo;
import it.verding.edo.service.ComuneService;
import it.verding.edo.service.QuestionarioRiscaldamentoService;
import it.verding.edo.util.Combustibili;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RiscaldamentoIntegrationTest extends BaseIntegration {

    public static String RISCALDAMENTO_URL = SERVER_URL + "/riscaldamento/{riscaldamentoId}";
    private String riscaldamentoId;
    private QuestionarioRiscaldamento questionarioRiscaldamento;
    
    @Autowired ComuneService comuneService;
    @Autowired TipoEnteRepo tipoEnteRepo;
	@Autowired TipoCombustibileRepo tipoCombustibileRepo;
	@Autowired TipoTerminaleRiscaldamentoRepo tipoTerminaleRiscaldamentoRepo;
	@Autowired QuestionarioRiscaldamentoService questionarioRiscaldamentoService;
	

    @Given("^Il formulario e compilato ed inviato con Utente: Cittadino, Comune: Roma, Combustibile: GPL, Terminali: Radiatori accaio, Consumo: 2300, m2: 150, Caldaia con piu' di 10 anni$")
    public void questionarioCompilatoEdInviato() {
    	questionarioRiscaldamento = new QuestionarioRiscaldamento();
    	questionarioRiscaldamento.setTipoEnte(tipoEnteRepo.findByNome("Cittadino"));
    	questionarioRiscaldamento.setComune(comuneService.findComuneByNomeAndProvincia("Napoli", "NA"));
    	questionarioRiscaldamento.setTipoCombustibile(tipoCombustibileRepo.findByNome(Combustibili.GPL.nome()));
    	questionarioRiscaldamento.setTipoTerminaleRiscaldamento(tipoTerminaleRiscaldamentoRepo.findByNome("Radiatori in acciaio"));
    	questionarioRiscaldamento.setMetri2(150);
    	questionarioRiscaldamento.setLitriCombustibileAnno(2300);
    	questionarioRiscaldamento.setIsPiuDi10anni(true);
    }


    @When("^si fanno i calcoli per ottenere le migliori soluzioni$")
    public void calcola() throws Exception {
/*
        Map<String, String> params = new HashMap<String, String>();
        params.put("studentID",  studentID);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("userAuth" , "abc123" );

        HttpEntity<Object> httpEntity = new HttpEntity<Object>( headers );

        ResponseEntity<StudentResponse> responseEntity =  restTemplate.exchange(STUDENT_URL, HttpMethod.GET,httpEntity,StudentResponse.class,params);
        response = responseEntity.getBody();
        */
    	
    	questionarioRiscaldamentoService.populateSoluzioni(questionarioRiscaldamento);
    }


    @Then("^costo acquisto + istallazione: 2140, nuovo consumo: 2029.412$")
    public void iRisultatiDovrebberoEssereQuelliQuaSu() {
//        assertThat(response.getStudents().size(),is(1));
    	
    	// Best risparmio
    	Collections.sort(questionarioRiscaldamento.getSoluzioni(), new Comparator<Soluzione>() {
			@Override
			public int compare(Soluzione s0, Soluzione s1) {
				return Double.compare(s1.getRisparmioAnnuo(), s0.getRisparmioAnnuo());
			}
    	});
    	Soluzione soluzione = questionarioRiscaldamento.getSoluzioni().get(0);
    			
    	assertEquals("I resultati non coincidono", 2140.00, soluzione.getCostoIntervento(), Math.abs(soluzione.getCostoIntervento()) / 1e3);
    }
}