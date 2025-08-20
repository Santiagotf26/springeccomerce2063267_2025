package com.sena.ecommerce_3063267.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce_3063267.model.DetalleOrden;
import com.sena.ecommerce_3063267.repository.IDetalleOrdenRepository;

@Service
public class DetalleOrdenServiceIMPL implements IDetalleOrdenService{
	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;

	@Override
	public DetalleOrden save(DetalleOrden detalleorden) {
		// TODO Auto-generated method stub
		return detalleOrdenRepository.save(detalleorden);
	}
	
	

}
