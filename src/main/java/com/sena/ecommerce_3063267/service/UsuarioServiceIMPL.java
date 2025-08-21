package com.sena.ecommerce_3063267.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce_3063267.model.Usuario;
import com.sena.ecommerce_3063267.repository.IUsuarioRepository;
@Service

public class UsuarioServiceIMPL implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuariorepository;

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuariorepository.save(usuario);
	}

	@Override
	public Optional<Usuario> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return usuariorepository.findById(id);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		// TODO Auto-generated method stub
		return usuariorepository.findByEmail(email);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuariorepository.findAll();
	}

	@Override
	public Optional<Usuario> findByEmail(Integer email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
} 
