package br.com.farmacia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farmacia.api.repositories.PedidoRepository;
import br.com.farmacia.entities.Pedido;
import br.com.farmacia.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow( () -> new ObjectNotFoundException("Pedido não encontrado. ID: " + id
				+ ", Tipo: " + Pedido.class.getName()));
	}
}
