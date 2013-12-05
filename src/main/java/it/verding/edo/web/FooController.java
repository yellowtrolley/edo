package it.verding.edo.web;
import it.verding.edo.model.Bar;
import it.verding.edo.model.Comune;
import it.verding.edo.model.Foo;
import it.verding.edo.model.ZonaClimatica;
import it.verding.edo.repositories.ComuneRepository;
import it.verding.edo.repositories.ZonaClimaticaRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/foos")
@Controller
@RooWebScaffold(path = "foos", formBackingObject = Foo.class)
@RooWebJson(jsonObject = Foo.class)
public class FooController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired ComuneRepository comuneRepository;
	@Autowired ZonaClimaticaRepository zonaClimaticaRepository;
	
	@RequestMapping("/populateZonaClimatica")
	public String generateZonaClimatica(HttpServletRequest request, Model model) throws IOException {
		ZonaClimatica zona = new ZonaClimatica("A", 600);
		zonaClimaticaRepository.save(zona);
		zona = new ZonaClimatica("B", 850);
		zonaClimaticaRepository.save(zona);
		zona = new ZonaClimatica("C", 110);
		zonaClimaticaRepository.save(zona);
		zona = new ZonaClimatica("D", 1400);
		zonaClimaticaRepository.save(zona);
		zona = new ZonaClimatica("E", 1700);
		zonaClimaticaRepository.save(zona);
		zona = new ZonaClimatica("F", 1800);
		zonaClimaticaRepository.save(zona);
		
		return "redirect:/";
	}
	
	@RequestMapping("/populateComune")
	public String readExcel(HttpServletRequest request, Model model) throws IOException {
//		String filePath = request.getSession().getServletContext().getRealPath("excel");
	    File inputWorkbook = new File("/home/pablo/backups/persistence/Docs/proyectos/EDO/Foglio_demo_RAF_solo riscaldamento_rev5-2.xls");
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			
			// Get the zona climatica sheet
			Sheet sheet = w.getSheet(2);
			
			// loop from row 5 to 8132
			for(int i = 5 ; i < 8133; i++) {
				
				Cell comune = sheet.getCell(2, i);
				Cell altSlm = sheet.getCell(3, i);
				Cell gradiGiorno = sheet.getCell(4, i);
				Cell zonaClimatica = sheet.getCell(5, i);
				
				if(StringUtils.isNotBlank(comune.getContents())) {
					log.debug("Comune: " + comune.getContents());
					log.debug("altSlm: " + altSlm.getContents());
					log.debug("gradiGiorno: " + gradiGiorno.getContents());
					log.debug("Zona climatica: " + zonaClimatica.getContents());
					
					ZonaClimatica zona = zonaClimaticaRepository.findByNome(zonaClimatica.getContents());
					if(zona != null) {
						Comune c = new Comune(comune.getContents(), Integer.valueOf(altSlm.getContents()), Integer.valueOf(gradiGiorno.getContents()), zona);
						c = comuneRepository.save(c);
						log.debug("saved comune " + c);
					}
					
				}
			}
		} catch (BiffException e) {
			log.debug(e.getMessage(), e);
		}
	    
		return "redirect:/";
	}
	
	
	@RequestMapping("/testCascade")
	public String testCascade(HttpServletRequest request, Model model) throws IOException {
		Bar aBar = new Bar();
    	aBar.setBirra("menabrea");
    	
    	Bar anotherBar = new Bar();
    	anotherBar.setBirra("peroni");
    	
    	Foo aFoo = new Foo();
    	aFoo.setBar(aBar);
    	
//    	aFoo.setBarlist(new ArrayList<Bar>());
//    	aFoo.getBarlist().add(aBar);
//    	aFoo.getBarlist().add(anotherBar);
//    	aFoo.setBarset(new HashSet<Bar>());
//    	aFoo.getBarset().add(aBar);
//    	aFoo.getBarset().add(anotherBar);
    	
    	fooService.saveFoo(aFoo);
    	
    	log.debug("aFoo was saved with id: " + aFoo.getId());
    	log.debug("aBar was cascade saved with id: " + aBar.getId());
    	log.debug("anotherBar was cascade saved with id: " + anotherBar.getId());
    	log.debug("Number of Bars found in db: " + barService.findAllBars().size());
    	
    	fooService.deleteFoo(aFoo);

    	log.debug("aFoo was deleted. Foos found on DB: " + fooService.findAllFoos().size());
    	log.debug("Number of Bars found in db: " + barService.findAllBars().size());
    	
		
		return "redirect:/";
	}
}
