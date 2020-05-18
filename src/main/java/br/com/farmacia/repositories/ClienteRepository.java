package br.com.farmacia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
