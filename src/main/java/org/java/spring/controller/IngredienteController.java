package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Ingrediente;
import org.java.spring.db.serve.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping("/ingredients")
    public String createDiscount(Model model) {
        

        List<Ingrediente> ingrediente = ingredienteService.findAll();
        
        model.addAttribute("ingrediente", ingrediente);
        
        return "/";
    }
}
