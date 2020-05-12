package br.com.farmacia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
