package br.com.farmacia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
