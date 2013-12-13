package it.verding.edo.web;
import it.verding.edo.domain.TipoGeneratore;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tipocaldaias")
@Controller
@RooWebScaffold(path = "tipocaldaias", formBackingObject = TipoGeneratore.class)
public class TipoCaldaiaController {
}
