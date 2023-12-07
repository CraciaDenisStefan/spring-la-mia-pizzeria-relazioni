package org.java.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.db.dto.PizzaOfferteDTO;
import org.java.spring.db.pojo.OffertaSpeciale;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serve.OffertaSpecialeService;
import org.java.spring.db.serve.Pizzeriaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferteController {

	@Autowired
	private Pizzeriaservice pizzeriaService;
	
	@Autowired
	private OffertaSpecialeService offertaSpecialeService;
	
	@GetMapping("/pizza/offerte")
	public String getOfferteForm(Model model) {
		
		List<Pizza> pizze = pizzeriaService.findAll();
		model.addAttribute("pizze", pizze);
		
		return "offerte-form";
	}
	@PostMapping("/pizza/offerte")
	public String storeOfferte(
			@ModelAttribute PizzaOfferteDTO pizzaOfferteDTO
		) {
		
		Pizza pizza = pizzeriaService.findById(pizzaOfferteDTO.getPizza_id());
		
		OffertaSpeciale offertaSpeciale = new OffertaSpeciale(
				  LocalDate.now(),
				  LocalDate.now(),
				  pizzaOfferteDTO.getTitolo(),
		         pizza	
				);
		
		offertaSpecialeService.save(offertaSpeciale);
		
		return "redirect:/";
	}
}
