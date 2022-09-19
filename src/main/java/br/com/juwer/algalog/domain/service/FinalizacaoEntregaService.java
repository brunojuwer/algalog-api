package br.com.juwer.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
  
  private EntregaReposiroty entregaReposiroty;
  private BuscaEntregaService buscaEntregaService;

  @Transactional
  public void finalizar(Long entregaId){
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    entrega.finalizar();

    entregaReposiroty.save(entrega);


  }

}
