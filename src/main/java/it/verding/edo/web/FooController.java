package it.verding.edo.web;
import it.verding.edo.model.Comune;
import it.verding.edo.model.Provincia;
import it.verding.edo.model.Regione;
import it.verding.edo.model.ZonaClimatica;
import it.verding.edo.repositories.ComuneRepo;
import it.verding.edo.repositories.ProvinciaRepo;
import it.verding.edo.repositories.RegioneRepo;
import it.verding.edo.repositories.ZonaClimaticaRepo;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * Prima http://localhost:8080/edo//populateZonaClimatica
 * Dopo http://localhost:8080/edo//populateComune
 */

@RequestMapping("/")
@Controller
public class FooController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired RegioneRepo regioneRepo;
	@Autowired ProvinciaRepo provinciaRepo;
	@Autowired ComuneRepo comuneRepo;
	@Autowired ZonaClimaticaRepo zonaClimaticaRepo;
	
	@RequestMapping("/populateZonaClimatica")
	public String generateZonaClimatica(HttpServletRequest request, Model model) throws IOException {
		ZonaClimatica zona = new ZonaClimatica("A", 600);
		zonaClimaticaRepo.save(zona);
		zona = new ZonaClimatica("B", 850);
		zonaClimaticaRepo.save(zona);
		zona = new ZonaClimatica("C", 110);
		zonaClimaticaRepo.save(zona);
		zona = new ZonaClimatica("D", 1400);
		zonaClimaticaRepo.save(zona);
		zona = new ZonaClimatica("E", 1700);
		zonaClimaticaRepo.save(zona);
		zona = new ZonaClimatica("F", 1800);
		zonaClimaticaRepo.save(zona);
		
		return "redirect:/";
	}
	
	@RequestMapping("/populateComune")
	public String readExcel(HttpServletRequest request, Model model) throws Exception {
		String filePath = request.getSession().getServletContext().getRealPath("excel/Foglio_demo_RAF_solo riscaldamento_rev5-2.xls");
	    File inputWorkbook = new File(filePath);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			
			// Get the zona climatica sheet
			Sheet sheet = w.getSheet(2);
			
			Regione regione = null;
			Provincia provincia = null;
			Comune comune = null;
			
			// loop from row 4 to 8132
			for(int i = 4 ; i < 8133; i++) {
				Cell regioneCell = sheet.getCell(0, i);
				
				if(StringUtils.isNotBlank(regioneCell.getContents())) {
					// Nuova regione
					regione = new Regione(WordUtils.capitalize(regioneCell.getContents().toLowerCase()), new HashSet<Provincia>());
					provincia = new Provincia(sheet.getCell(1, i+1).getContents(), new HashSet<Comune>());
					
					regione.getProvincie().add(provincia);
					regioneRepo.save(regione);
				} else {
					Cell provinciaCell = sheet.getCell(1, i);
					Cell comuneCell = sheet.getCell(2, i);
					Cell altSlmCell = sheet.getCell(3, i);
					Cell gradiGiornoCell = sheet.getCell(4, i);
					Cell zonaClimaticaCell = sheet.getCell(5, i);
				
					ZonaClimatica zona = zonaClimaticaRepo.findByNome(zonaClimaticaCell.getContents());
					comune = new Comune(comuneCell.getContents(), Integer.valueOf(altSlmCell.getContents()), Integer.valueOf(gradiGiornoCell.getContents()), zona);
					
					if(!provinciaCell.getContents().equals(provincia.getNome())) {
						// Nuova provincia
						provincia = new Provincia(provinciaCell.getContents(), new HashSet<Comune>());
						regione.getProvincie().add(provincia);
					}
					
					provincia.getComuni().add(comune);
					
					regioneRepo.save(regione);
				}
			}
		} catch (BiffException e) {
			log.debug(e.getMessage(), e);
		}
	    
		return "redirect:/";
	}
}
