package com.sena.ecommerce_3063267.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce_3063267.model.Producto;
import com.sena.ecommerce_3063267.model.Usuario;
import com.sena.ecommerce_3063267.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	//instancia logger
	private final org.slf4j.Logger LOGGER = (org.slf4j.Logger) LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "producto/show";
	}
	
	
	@GetMapping("/save")	
	public String create() {
		return "producto/create";			
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("Este es el objeto del producto a guardar en la DB {}",producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.save(producto);
		return "redirect:/producto";
	}
	

}
