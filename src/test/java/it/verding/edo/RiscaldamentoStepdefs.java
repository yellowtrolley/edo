package it.verding.edo;

import static org.junit.Assert.assertEquals;
import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.domain.Soluzione;
import it.verding.edo.service.ComuneService;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class RiscaldamentoStepdefs {
	/*
	public static final String SERVER_PORT = "9999";
    public static String SERVER_URL = "http://localhost:" + SERVER_PORT + "/edo";
    public static String RISCALDAMENTO_URL = SERVER_URL + "/riscaldamento/{riscaldamentoId}";
    
    @Autowired
    protected RestTemplate restTemplate;
    
    private String riscaldamentoId;
*/
//	@Autowired 
//	private ComuneService comuneService;
	@Autowired
    private MockMvc mockMvc;
	
	QuestionarioRiscaldamento questionarioRiscaldamento;
    
//    @Autowired private TipoEnteRepo tipoEnteRepo;
//	@Autowired private TipoCombustibileRepo tipoCombustibileRepo;
//	@Autowired private TipoTerminaleRiscaldamentoRepo tipoTerminaleRiscaldamentoRepo;
//	@Autowired private QuestionarioRiscaldamentoService questionarioRiscaldamentoService;
	
	/*
	@Given("^Il formulario e compilato ed inviato con Utente: Cittadino, Comune: Roma, Combustibile: GPL, Terminali: Radiatori accaio, Consumo: (\\d+), metri: (\\d+), Caldaia con piu' di dieci anni$")
	public void Il_formulario_e_compilato_ed_inviato_con_Utente_Cittadino_Comune_Roma_Combustibile_GPL_Terminali_Radiatori_accaio_Consumo_m_Caldaia_con_piu_di_anni(int consumo, int metri) throws Throwable {
	}
*/
	@Given("^Il formulario e compilato ed inviato$")
	public void Il_formulario_e_compilato_ed_inviato() throws Throwable {
		questionarioRiscaldamento = new QuestionarioRiscaldamento();
		questionarioRiscaldamento.setMetri2(150);
		questionarioRiscaldamento.setLitriCombustibileAnno(2300);
		questionarioRiscaldamento.setIsPiuDi10anni(true);
//    	questionarioRiscaldamento.setTipoEnte(tipoEnteRepo.findByNome("Cittadino"));
//    	questionarioRiscaldamento.setComune(comuneService.findComuneByNomeAndProvincia("Napoli", "NA"));
//    	questionarioRiscaldamento.setTipoCombustibile(tipoCombustibileRepo.findByNome(Combustibili.GPL.nome()));
//    	questionarioRiscaldamento.setTipoTerminaleRiscaldamento(tipoTerminaleRiscaldamentoRepo.findByNome("Radiatori in acciaio"));
	}
	
	@When("^si fanno i calcoli per ottenere le migliori soluzioni$")
	public void si_fanno_i_calcoli_per_ottenere_le_migliori_soluzioni() throws Throwable {
//		questionarioRiscaldamentoService.populateSoluzioni(questionarioRiscaldamento);
	}

	@Then("^costo acquisto + istallazione: (\\d+), nuovo consumo: (\\d+).(\\d+)$")
	public void costo_acquisto_istallazione_nuovo_consumo_(int arg1, int arg2, int arg3) throws Throwable {
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