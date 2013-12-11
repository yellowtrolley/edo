package it.verding.edo.web;
import it.verding.edo.domain.TipoTerminaleRiscaldamento;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tipoterminaleriscaldamentoes")
@Controller
@RooWebScaffold(path = "tipoterminaleriscaldamentoes", formBackingObject = TipoTerminaleRiscaldamento.class)
public class TipoTerminaleRiscaldamentoController {
}
