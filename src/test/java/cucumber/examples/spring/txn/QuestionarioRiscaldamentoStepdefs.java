package cucumber.examples.spring.txn;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.domain.TipoCombustibile;
import it.verding.edo.repositories.QuestionarioRiscaldamentoRepo;
import it.verding.edo.repositories.TipoCombustibileRepo;
import it.verding.edo.repositories.TipoEnteRepo;
import it.verding.edo.repositories.TipoGeneratoreRepo;
import it.verding.edo.service.ComuneService;
import it.verding.edo.service.QuestionarioRiscaldamentoService;
import it.verding.edo.util.Combustibili;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@WebAppConfiguration
@ContextConfiguration("classpath:cucumber.xml")
public class QuestionarioRiscaldamentoStepdefs {
//    @Autowired
//    private UserRepo userRepository;
	
	@Autowired
	private QuestionarioRiscaldamentoService questionarioRiscaldamentoService;
	
	@Autowired
	private TipoEnteRepo tipoEnteRepo;
	
	@Autowired
	private ComuneService comuneService;
	
    @Autowired 
    private TipoCombustibileRepo tipoCombustibileRepo;

    @Autowired 
    private TipoGeneratoreRepo tipoGeneratoreRepo;
    
    @Autowired
    private MockMvc mockMvc;
    
    private QuestionarioRiscaldamento questionarioRiscaldamento;
//    private User user;

    private ResultActions resultActions;

    @Given("^il questionario e compilato, combustibile: \"([^\"]*)\", m2: (\\d+), litri/anno: (\\d+), sistema termoregolazione: (true|false), piu di 10 anni: (true|false)$")
    public void il_questionario_e_compilato(Combustibili combustibile, int m2, int litriAnno, boolean isSistemaTermoregolazione, boolean isPiuDi10anni) {
    	TipoCombustibile tipoCombustibile = tipoCombustibileRepo.findByNome(combustibile.nome()); // String param \"([^\"]*)\"
    	
    	questionarioRiscaldamento = new QuestionarioRiscaldamento();
    	questionarioRiscaldamento.setTipoEnte(tipoEnteRepo.findByNome("Cittadino"));
    	questionarioRiscaldamento.setComune(comuneService.findComuneByNomeAndProvincia("Napoli", "NA"));
    	questionarioRiscaldamento.setLitriCombustibileAnno(litriAnno);
    	questionarioRiscaldamento.setTipoCombustibile(tipoCombustibile);
        questionarioRiscaldamento.setMetri2(m2);
        questionarioRiscaldamento.setIsSistemaTermoregolazione(isSistemaTermoregolazione);
        questionarioRiscaldamento.setIsPiuDi10anni(isPiuDi10anni);
        questionarioRiscaldamentoService.saveQuestionarioRiscaldamento(questionarioRiscaldamento);
    }

    @Given("^il questionario e inivato")
    public void il_questionario_e_inviato() throws Exception {
    	resultActions = mockMvc
                .perform(post("/riscaldamento").requestAttr("questionarioRiscaldamento", questionarioRiscaldamento))
                .andExpect(status().isOk());
    }

    @When("^il questionario e visualizzato$")
    public void il_questionario_e_visualizzato() throws Exception {
        resultActions = mockMvc
                .perform(get("/riscaldamento/" + questionarioRiscaldamento.getId().toString()))
                .andExpect(status().isOk());
    }

    @Then("^dovrei ottenere (\\d+) soluzioni$")
    public void dovrei_otenere_soluzioni(int numeroSoluzioni) throws Exception {
    	questionarioRiscaldamentoService.populateSoluzioni(questionarioRiscaldamento);
        assertThat(numeroSoluzioni, is(questionarioRiscaldamento.getSoluzioni().size()));
    }

}
