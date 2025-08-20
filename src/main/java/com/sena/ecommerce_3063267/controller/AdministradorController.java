package com.sena.ecommerce_3063267.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")//solicitud de mappeo al diectorio administrador
public class AdministradorController {
	
	@GetMapping("")
	public String home() {
		return"administrador/home";
	}

}
