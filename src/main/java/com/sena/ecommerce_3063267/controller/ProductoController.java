package com.sena.ecommerce_3063267.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sena.ecommerce_3063267.model.Producto;
import com.sena.ecommerce_3063267.model.Usuario;
import com.sena.ecommerce_3063267.service.IProductoService;
import com.sena.ecommerce_3063267.service.UploadFileService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	// instancia logger
	private final org.slf4j.Logger LOGGER = (org.slf4j.Logger) LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private UploadFileService upload;

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
	public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException{
		LOGGER.info("Este es el objeto del producto a guardar en la DB {}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		//validacion imagen del producto
		if (producto.getId()== null) {
			String nombreImagen = upload.saveImages(file, producto.getNombre());
			producto.setImagen(nombreImagen);
			
		}
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
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto del producto a actualizar en la DB {}", producto);
		Producto p =  new Producto();
		p = productoService.get(producto.getId()).get();
		if (file.isEmpty()) {
			producto.setImagen(p.getImagen());
			
		} else {
			if (!p.getImagen().equals("default.jpg")) {
				upload.deleteImage(p.getImagen());
			}
			String nombreImagen = upload.saveImages(file, p.getNombre());
			producto.setImagen(nombreImagen);
		}
		producto.setUsuario(p.getUsuario());
		productoService.update(producto);
		return "redirect:/producto";
	}

	// metodo para eliminar con id un producto
	@GetMapping("/delete/{id}")
	public String delet(@PathVariable Integer id) {
		Producto  p = new Producto();
		p = productoService.get(id).get();
		if (!p.getImagen().equals("default.jpg")) {
			upload.deleteImage(p.getImagen());
			
		}
		productoService.delete(id);
		return "redirect:/producto";
	}

}
