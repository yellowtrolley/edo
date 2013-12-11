package it.verding.edo.web;
import it.verding.edo.domain.QuestionarioRiscaldamento;
import it.verding.edo.domain.Soluzione;
import it.verding.edo.domain.TipoCaldaia;
import it.verding.edo.domain.TipoCombustibile;
import it.verding.edo.util.Combustibili;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/riscaldamento")
@Controller
@RooWebScaffold(path = "riscaldamento", formBackingObject = QuestionarioRiscaldamento.class)
public class RiscaldamentoController {
	
	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new QuestionarioRiscaldamento());
        return "riscaldamento/create";
    }
	
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid QuestionarioRiscaldamento questionarioRiscaldamento, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, questionarioRiscaldamento);
            return "riscaldamento/create";
        }
        uiModel.asMap().clear();
        
        questionarioRiscaldamentoService.populateSoluzioni(questionarioRiscaldamento);
        questionarioRiscaldamentoService.saveQuestionarioRiscaldamento(questionarioRiscaldamento);

        return "redirect:/riscaldamento/" + encodeUrlPathSegment(questionarioRiscaldamento.getId().toString(), httpServletRequest);
    }
	
	
	void populateEditForm(Model uiModel, QuestionarioRiscaldamento questionarioRiscaldamento) {
        uiModel.addAttribute("questionarioRiscaldamento", questionarioRiscaldamento);
        uiModel.addAttribute("tipiEnte", questionarioRiscaldamentoService.findAllTipoEnte());
        uiModel.addAttribute("tipiCombustibile", questionarioRiscaldamentoService.findAllTipoCombustibile());
        uiModel.addAttribute("tipiTerminaleRiscaldamento", questionarioRiscaldamentoService.findAllTipoTerminaleRiscaldamento());
    }
}
