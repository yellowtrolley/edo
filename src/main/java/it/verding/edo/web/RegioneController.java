package it.verding.edo.web;
import it.verding.edo.domain.Regione;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/regiones")
@Controller
@RooWebScaffold(path = "regiones", formBackingObject = Regione.class)
public class RegioneController {
}
