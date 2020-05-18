package br.com.farmacia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farmacia.entities.Cliente;
import br.com.farmacia.repositories.ClienteRepository;
import br.com.farmacia.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado. ID : " + id
				+ ", Tipo : " + Cliente.class.getName()));
	}
}
