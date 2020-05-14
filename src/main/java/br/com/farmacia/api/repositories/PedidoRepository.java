package br.com.farmacia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
