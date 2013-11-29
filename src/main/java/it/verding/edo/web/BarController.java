package it.verding.edo.web;
import it.verding.edo.model.Bar;

import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bars")
@Controller
//@RooWebScaffold(path = "bars", formBackingObject = Bar.class)
@RooWebJson(jsonObject = Bar.class)
public class BarController {
}
