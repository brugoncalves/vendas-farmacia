package br.com.farmacia.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.farmacia.api.repositories.UsuarioRepository;
import br.com.farmacia.entities.Usuario;
import br.com.farmacia.services.UsuarioService;
import br.com.farmacia.services.exceptions.ValidacaoDeEmailException;

public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new ValidacaoDeEmailException("Já existe um usuário cadastrado com este e-mail");
		}
		
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
