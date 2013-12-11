package it.verding.edo.web;
import it.verding.edo.domain.ZonaClimatica;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/zonaclimaticas")
@Controller
@RooWebScaffold(path = "zonaclimaticas", formBackingObject = ZonaClimatica.class)
public class ZonaClimaticaController {
}
