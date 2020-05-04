package br.com.farmacia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farmacia.api.repositories.CategoriaRepository;
import br.com.farmacia.entities.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElse(null);
	}
}
