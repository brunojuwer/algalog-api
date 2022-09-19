package br.com.juwer.algalog.domain.service;


import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.juwer.algalog.domain.model.Cliente;
import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.model.StatusEntrega;
import br.com.juwer.algalog.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {
  
  private CatalogoClienteService catalogoClienteService;
  private EntregaReposiroty entregaReposiroty;

  @Transactional
  public Entrega solicitar(Entrega entrega){
    Cliente cliente = catalogoClienteService
      .buscar(entrega.getCliente().getId());
    
    entrega.setCliente(cliente);
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(OffsetDateTime.now());


    return entregaReposiroty.save(entrega);
  }
}
