package it.verding.edo.web;
import it.verding.edo.model.QuestionarioRiscaldamento;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/riscaldamento")
@Controller
@RooWebScaffold(path = "riscaldamento", formBackingObject = QuestionarioRiscaldamento.class)
public class RiscaldamentoController {
	
	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new QuestionarioRiscaldamento());
        return "riscaldamento/create";
    }
	
	
	void populateEditForm(Model uiModel, QuestionarioRiscaldamento questionarioRiscaldamento) {
        uiModel.addAttribute("questionarioRiscaldamento", questionarioRiscaldamento);
        uiModel.addAttribute("tipiEnte", questionarioRiscaldamentoService.findAllTipoEnte());
        uiModel.addAttribute("tipiCombustibile", questionarioRiscaldamentoService.findAllTipoCombustibile());
        uiModel.addAttribute("tipiTerminaleRiscaldamento", questionarioRiscaldamentoService.findAllTipoTerminaleRiscaldamento());
    }
}
