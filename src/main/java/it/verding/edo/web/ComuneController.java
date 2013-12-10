package it.verding.edo.web;
import it.verding.edo.model.Comune;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RooWebJson(jsonObject = Comune.class)
@Controller
@RequestMapping("/comuni")
public class ComuneController {
	// TODO SECURE or remove create, update, delete
	
	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson(@RequestParam("term") String nome) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Comune> result = comuneService.findComunesByNomeLike(nome);
        
        return new ResponseEntity<String>(Comune.toJsonArray(result), headers, HttpStatus.OK);
    }
}
