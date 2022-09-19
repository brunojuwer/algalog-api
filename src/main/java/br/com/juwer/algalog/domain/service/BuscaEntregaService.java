package br.com.juwer.algalog.domain.service;

import org.springframework.stereotype.Service;

import br.com.juwer.algalog.domain.exception.EntidadeNaoEncontradaException;
import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
  
private EntregaReposiroty entregaReposiroty;

  public Entrega buscar(Long entregaId){
    return entregaReposiroty.findById(entregaId)
    .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
  }
}
