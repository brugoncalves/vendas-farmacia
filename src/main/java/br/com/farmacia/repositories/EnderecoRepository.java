package br.com.farmacia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
