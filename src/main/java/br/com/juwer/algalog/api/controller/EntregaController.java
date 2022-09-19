package br.com.juwer.algalog.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
  
  @Autowired
  private SolicitacaoEntregaService solicitacaoEntregaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega solicitar(@Valid @RequestBody Entrega entrega){
    return solicitacaoEntregaService.solicitar(entrega);
  }
}
