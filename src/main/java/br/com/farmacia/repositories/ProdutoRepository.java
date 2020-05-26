package br.com.farmacia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}