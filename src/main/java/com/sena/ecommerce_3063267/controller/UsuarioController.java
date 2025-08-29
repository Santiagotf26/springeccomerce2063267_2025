package com.sena.ecommerce_3063267.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce_3063267.service.IProductoService;

@Controller
@RequestMapping("/")
public class UsuarioController {
	
	// instancia de producto service
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("producto", productoService.findAll());
		return"usuario/home";
	}

}
