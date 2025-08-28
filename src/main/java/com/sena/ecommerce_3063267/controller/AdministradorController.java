package com.sena.ecommerce_3063267.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce_3063267.model.Producto;
import com.sena.ecommerce_3063267.service.IProductoService;

@Controller
@RequestMapping("/administrador")//solicitud de mappeo al diectorio administrador
public class AdministradorController {
	
	// instancia logger
	private final org.slf4j.Logger LOGGER = (org.slf4j.Logger) LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;
		
	
	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos",productos);
		return"administrador/home";
	}

}
