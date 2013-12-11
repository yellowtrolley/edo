package it.verding.edo.web;
import it.verding.edo.domain.TipoCombustibile;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tipocombustibiles")
@Controller
@RooWebScaffold(path = "tipocombustibiles", formBackingObject = TipoCombustibile.class)
public class TipoCombustibileController {
}
