package br.com.farmacia.services;

import java.util.Optional;

import br.com.farmacia.entities.Usuario;

public interface UsuarioService {

	void validarEmail(String email);
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	Optional<Usuario> findById(Long id);
	
	
}
