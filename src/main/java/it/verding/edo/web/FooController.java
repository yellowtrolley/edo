package it.verding.edo.web;
import it.verding.edo.domain.Comune;
import it.verding.edo.domain.Provincia;
import it.verding.edo.domain.Regione;
import it.verding.edo.domain.TipoCombustibile;
import it.verding.edo.domain.TipoEnte;
import it.verding.edo.domain.TipoGeneratore;
import it.verding.edo.domain.TipoTerminaleRiscaldamento;
import it.verding.edo.domain.ZonaClimatica;
import it.verding.edo.repositories.ComuneRepo;
import it.verding.edo.repositories.ProvinciaRepo;
import it.verding.edo.repositories.RegioneRepo;
import it.verding.edo.repositories.TipoCombustibileRepo;
import it.verding.edo.repositories.TipoEnteRepo;
import it.verding.edo.repositories.TipoGeneratoreRepo;
import it.verding.edo.repositories.TipoTerminaleRiscaldamentoRepo;
import it.verding.edo.repositories.ZonaClimaticaRepo;
import it.verding.edo.util.Combustibili;

import java.io.File;
import java.io.IOException;

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
	@Autowired TipoCombustibileRepo tipoCombustibileRepo;
	@Autowired TipoEnteRepo tipoEnteRepo;
	@Autowired TipoTerminaleRiscaldamentoRepo tipoTerminaleRiscaldamentoRepo;
	@Autowired TipoGeneratoreRepo tipoGeneratoreRepo;
	
	@RequestMapping("/populate")
	public String populate(HttpServletRequest request, Model model) throws IOException {
		// Zona Climatica 
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
		
		// Chi sei?
		tipoEnteRepo.save(new TipoEnte("Cittadino"));
		tipoEnteRepo.save(new TipoEnte("Impresa"));
		tipoEnteRepo.save(new TipoEnte("Pubblica Amministrazione"));
		
		// Che combustibile usi? 
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a gasolio", Double.valueOf(1.30), Double.valueOf(10), Double.valueOf(0.267)));
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a GPL", Double.valueOf(1.10), Double.valueOf(6.6), Double.valueOf(0.227)));
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a aria propanata", Double.valueOf(1.50), Double.valueOf(6), Double.valueOf(0.227)));
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a gas naturale", Double.valueOf(0.85), Double.valueOf(9.59), Double.valueOf(0.202)));
		
		// Come sono i tuoi terminali di riscaldamento? 
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Radiatori in ghisa"));
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Radiatori in acciaio"));
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Pannelli radianti a pavimento"));
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Ventilconvettori"));
		
		// Tipi Generatore
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato a gasolio", tipoCombustibileRepo.findByNome(Combustibili.GASOLIO.nome())));
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato a GPL", tipoCombustibileRepo.findByNome(Combustibili.GPL.nome())));
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato ad aria propanata", tipoCombustibileRepo.findByNome(Combustibili.PROPANO.nome())));
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato a gas naturale", tipoCombustibileRepo.findByNome(Combustibili.GAS_NATURALE.nome())));
		/*
		Generatore alimentato a pellet idro
		Generatore alimentato a legna idro
		Caldaia a condensazione
		Pompa di calore aria/acqua
		Pompa di calore geotermica
		Pompa di calore a metano
		Pompa di calore a gpl
		 */
		
		return "redirect:/";
	}
	
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
	
	@RequestMapping("/populateTipoEnte")
	public String populateTipoEnte(HttpServletRequest request, Model model) throws IOException {
		// Chi sei?
		tipoEnteRepo.save(new TipoEnte("Cittadino"));
		tipoEnteRepo.save(new TipoEnte("Impresa"));
		tipoEnteRepo.save(new TipoEnte("Pubblica Amministrazione"));
		
		return "redirect:/";
	}
	
	@RequestMapping("/populateCombustibile")
	public String populateCombustibile(HttpServletRequest request, Model model) throws IOException {
		
		// Che combustibile usi? 
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a gasolio", Double.valueOf(1.30), Double.valueOf(10), Double.valueOf(0.267)));
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a GPL", Double.valueOf(1.10), Double.valueOf(6.6), Double.valueOf(0.227)));
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a aria propanata", Double.valueOf(1.50), Double.valueOf(6), Double.valueOf(0.227)));
		tipoCombustibileRepo.save(new TipoCombustibile("Alimentato a gas naturale", Double.valueOf(0.85), Double.valueOf(9.59), Double.valueOf(0.202)));
		
		return "redirect:/";
	}

	@RequestMapping("/populateTerminali")
	public String populateTerminali(HttpServletRequest request, Model model) throws IOException {
		// Come sono i tuoi terminali di riscaldamento? 
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Radiatori in ghisa"));
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Radiatori in acciaio"));
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Pannelli radianti a pavimento"));
		tipoTerminaleRiscaldamentoRepo.save(new TipoTerminaleRiscaldamento("Ventilconvettori"));
		
		return "redirect:/";
	}
	
	@RequestMapping("/populateGeneratore")
	public String populateGeneratore(HttpServletRequest request, Model model) throws IOException {
		// Tipi Generatore
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato a gasolio", tipoCombustibileRepo.findByNome(Combustibili.GASOLIO.nome())));
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato a GPL", tipoCombustibileRepo.findByNome(Combustibili.GPL.nome())));
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato ad aria propanata", tipoCombustibileRepo.findByNome(Combustibili.PROPANO.nome())));
		tipoGeneratoreRepo.save(
				new TipoGeneratore("Nuovo generatore alimentato a gas naturale", tipoCombustibileRepo.findByNome(Combustibili.GAS_NATURALE.nome())));
		/*
		Generatore alimentato a pellet idro
		Generatore alimentato a legna idro
		Caldaia a condensazione
		Pompa di calore aria/acqua
		Pompa di calore geotermica
		Pompa di calore a metano
		Pompa di calore a gpl
		 */
		
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
					regione = new Regione(WordUtils.capitalize(regioneCell.getContents().toLowerCase()));
					provincia = new Provincia(sheet.getCell(1, i+1).getContents(), regione);
					regioneRepo.save(regione);
					provinciaRepo.save(provincia);
				} else {
					Cell provinciaCell = sheet.getCell(1, i);
					Cell comuneCell = sheet.getCell(2, i);
					Cell altSlmCell = sheet.getCell(3, i);
					Cell gradiGiornoCell = sheet.getCell(4, i);
					Cell zonaClimaticaCell = sheet.getCell(5, i);
				
					if(!provinciaCell.getContents().equals(provincia.getNome())) {
						// Nuova provincia
						provincia = new Provincia(provinciaCell.getContents(), regione);
						provinciaRepo.save(provincia);
					}

					ZonaClimatica zona = zonaClimaticaRepo.findByNome(zonaClimaticaCell.getContents());
					comune = new Comune(comuneCell.getContents(), Integer.valueOf(altSlmCell.getContents()), Integer.valueOf(gradiGiornoCell.getContents()), zona, provincia);
					comuneRepo.save(comune);
					log.debug("Comune salvato: " + comune + ", Provincia: " + comune.getProvincia() + "Regione: " + comune.getProvincia().getRegione());
				}
			}
		} catch (BiffException e) {
			log.debug(e.getMessage(), e);
		}
	    
		return "redirect:/";
	}
}
