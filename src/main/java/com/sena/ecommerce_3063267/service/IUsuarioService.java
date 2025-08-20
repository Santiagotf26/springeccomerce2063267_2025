package com.sena.ecommerce_3063267.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce_3063267.model.Usuario;

public interface IUsuarioService {
	
	public Usuario save(Usuario usuario);
	
	public Optional<Usuario> get(Integer id);
	
	public void update (Usuario usuario);
	
	public void delete (Usuario usuario);
	
	public Optional<Usuario> findById(Integer id);

	public Optional<Usuario> findByEmail(Integer email);
	
	List<Usuario> findAll();


	

}
