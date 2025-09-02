package com.sena.ecommerce_3063267.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce_3063267.model.Producto;
import com.sena.ecommerce_3063267.service.IProductoService;

@Controller
@RequestMapping("/")
public class HomeUsuarioController {
	
	// Instancia del logger
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(HomeUsuarioController.class);
	
	// instancia de producto service
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("producto", productoService.findAll());
		return"usuario/home";
	}
	
	// metodo que carga el producto del usuario con el id producto
	@GetMapping("productohome/{id}")
	public String productohome(@PathVariable Integer id, Model model ) {
		LOGGER.info("Id producto enviado como parametro {}");
		// variable de la clase producto
		Producto p = new Producto();
		Optional<Producto> op = productoService.get(id);
		//pasar el producto
		p = op.get();
		model.addAttribute("producto", p);
		return"usuario/productohome";
	}

}
