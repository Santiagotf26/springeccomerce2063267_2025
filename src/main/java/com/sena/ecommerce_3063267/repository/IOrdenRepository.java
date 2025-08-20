package com.sena.ecommerce_3063267.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ecommerce_3063267.model.Orden;
import com.sena.ecommerce_3063267.model.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
	
	List<Orden> findByUsuario(Usuario usuario);

}