package com.sena.ecommerce_3063267.controller;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ecommerce_3063267.model.Producto;
import com.sena.ecommerce_3063267.model.Usuario;
import com.sena.ecommerce_3063267.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	// instancia logger
	private final org.slf4j.Logger LOGGER = (org.slf4j.Logger) LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;

	// metodo de listar productos
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "producto/show";
	}

	// metodo de redireccionamiento hacia el formulario de creacion de productos
	@GetMapping("/create")
	public String create() {
		return "producto/create";
	}

	// metodo de creacion de productos
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("Este es el objeto del producto a guardar en la DB {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.save(producto);
		return "redirect:/producto";
	}

	// metodo para el formulario de edicion de productos
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto p = new Producto();
		// retorna la busqueda de un objeto de tipo producto con el id
		Optional<Producto> op = productoService.get(id);
		p = op.get();
		LOGGER.warn("Busqueda de producto por id {}", p);
		model.addAttribute("producto", p);
		return "producto/edit";
	}

	// metodo de actualizacion de datos
	@PostMapping("/update")
	public String update(Producto producto) {
		LOGGER.info("Este es el objeto del producto a actualizar en la DB {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.update(producto);
		return "redirect:/producto";
	}

	// metodo para eliminar con id un producto
	@GetMapping("/delete/{id}")
	public String delet(@PathVariable Integer id) {
		productoService.delete(id);
		return "redirect:/producto";
	}

}
