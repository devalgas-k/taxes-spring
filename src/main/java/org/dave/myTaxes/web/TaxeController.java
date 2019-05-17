package org.dave.myTaxes.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.dave.myTaxes.dao.EntrepriseRepository;
import org.dave.myTaxes.dao.TaxeRepository;
import org.dave.myTaxes.entities.Entreprise;
import org.dave.myTaxes.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TaxeController {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	
	/*@RequestMapping(value="/entreprises",method=RequestMethod.GET)
	public String index(Model model,int page,int size) {
		Page<Entreprise> pageEntreprises = entrepriseRepository.findAll(new PageRequest(page, size));
		model.addAttribute("listEntreprises",pageEntreprises.getContent());
		
		int [] pages = new int [(int) pageEntreprises.getTotalElements()];
		model.addAttribute("pages", pages);
		
		return "entreprises";
	}*/
	
	@RequestMapping(value = "/entreprises",method = RequestMethod.GET)
    public String index(Model model,
    		            @RequestParam(name = "motCle",defaultValue = "") String motCle,
                        @RequestParam(name = "page",defaultValue = "0") int p,
                        @RequestParam(name = "size",defaultValue = "15") int s){
        Page<Entreprise> pageEntreprises = entrepriseRepository.chercher("%"+motCle+"%",new PageRequest(p,s));
        model.addAttribute("listEntreprises",pageEntreprises.getContent());
        int [] pages = new int[pageEntreprises.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("motCle", motCle);
        return "entreprises";
    }
	@RequestMapping(value="/formEntreprise")
	public String formEntreprise(Model model) {
		model.addAttribute("entreprise", new Entreprise() );
		return "formEntreprise";
		
	}
	/*@RequestMapping(value="/saveEntreprise")
	public String saveEntreprise(Model model,Entreprise e) {
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
		
	}
	*/
	@RequestMapping(value="/saveEntreprise")
	public String saveEntreprise(Model model,
			                     @Valid Entreprise e,
			                     BindingResult bindingResult ) {
		if (bindingResult.hasErrors())
			return "formEntreprise";
		entrepriseRepository.save(e);
			return "redirect:/entreprises";
		
	}
	@RequestMapping(value="/taxes")
	public String taxe(Model model,@RequestParam(name="code",defaultValue="-1")Long code) {
		model.addAttribute("entreprises", entrepriseRepository.findAll());
		if (code==-1) {
		     model.addAttribute("taxes", new ArrayList<Taxe>());
			
		} else {
			Entreprise e = new Entreprise();
			e.setCode(code);
			model.addAttribute("taxes", taxeRepository.findByEntreprise(e));

		}
		
		
		return "taxes";
		
	}
	
	

}
