package com.sena.ecommerce_3063267.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ecommerce_3063267.model.Producto;


@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	
	
	
	
}