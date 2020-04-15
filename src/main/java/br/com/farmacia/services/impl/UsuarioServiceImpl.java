package br.com.farmacia.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.farmacia.api.repositories.UsuarioRepository;
import br.com.farmacia.entities.Usuario;
import br.com.farmacia.services.UsuarioService;
import br.com.farmacia.services.exceptions.ErroAutenticacaoException;
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
		Optional<Usuario> usuario = repository.findByEmail(email);
		if(!usuario.isPresent()) {
			throw new ErroAutenticacaoException("Email não encontrado na base de dados. Por favor, insira o e-mail correto.");
		}
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacaoException("Senha inválida");
		}
		return usuario.get();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
