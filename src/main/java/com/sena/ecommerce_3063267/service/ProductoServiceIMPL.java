package com.sena.ecommerce_3063267.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce_3063267.model.Producto;
import com.sena.ecommerce_3063267.repository.IProductoRepository;

@Service

public class ProductoServiceIMPL implements IProductoService{
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}
	
}