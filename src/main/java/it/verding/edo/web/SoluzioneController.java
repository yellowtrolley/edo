package it.verding.edo.web;
import it.verding.edo.domain.Soluzione;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/soluziones")
@Controller
@RooWebScaffold(path = "soluziones", formBackingObject = Soluzione.class)
public class SoluzioneController {
}
