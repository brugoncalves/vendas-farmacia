package br.com.farmacia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
