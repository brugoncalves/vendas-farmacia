package br.com.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farmacia.api.repositories.CategoriaRepository;
import br.com.farmacia.entities.Categoria;
import br.com.farmacia.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow( () -> 
			new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
