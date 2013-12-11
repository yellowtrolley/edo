package it.verding.edo.web;
import it.verding.edo.domain.Provincia;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/provincias")
@Controller
@RooWebScaffold(path = "provincias", formBackingObject = Provincia.class)
public class ProvinciaController {
}
