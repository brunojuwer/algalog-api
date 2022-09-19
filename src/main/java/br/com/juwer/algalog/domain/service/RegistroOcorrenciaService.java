package br.com.juwer.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
  
  private BuscaEntregaService buscaEntregaService;

  @Transactional
  public Ocorrencia registrar(Long entregaId, String descricao){
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    return entrega.adicionarOcorrencia(descricao);
  }
}
