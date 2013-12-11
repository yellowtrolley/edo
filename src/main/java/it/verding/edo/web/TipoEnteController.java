package it.verding.edo.web;
import it.verding.edo.domain.TipoEnte;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tipoentes")
@Controller
@RooWebScaffold(path = "tipoentes", formBackingObject = TipoEnte.class)
public class TipoEnteController {
}
