package br.com.farmacia.api.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farmacia.entities.Usuario;
import br.com.farmacia.services.exceptions.ErroAutenticacaoException;
import br.com.farmacia.services.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServiceImpl service;
	
	@GetMapping
	public ResponseEntity <List<Usuario>>findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <Optional<Usuario>> findById(@PathVariable Long id){
		Optional<Usuario> usuario = service.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity autenticar(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioAutenticado = service.autenticar(usuario.getEmail(), usuario.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		} catch(ErroAutenticacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
