package br.com.farmacia.services;

import br.com.farmacia.entities.Usuario;

public interface UsuarioService {

	void validarEmail(String email);
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	
}
