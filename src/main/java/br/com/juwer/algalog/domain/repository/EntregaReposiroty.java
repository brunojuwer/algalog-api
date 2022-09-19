package br.com.juwer.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.juwer.algalog.domain.model.Entrega;

@Repository
public interface EntregaReposiroty extends JpaRepository<Entrega, Long> {
  
}
