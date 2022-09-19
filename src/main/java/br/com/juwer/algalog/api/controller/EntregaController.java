package br.com.juwer.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.juwer.algalog.api.model.EntregaModel;
import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.repository.EntregaReposiroty;
import br.com.juwer.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
  
  private SolicitacaoEntregaService solicitacaoEntregaService;
  private EntregaReposiroty entregaReposiroty;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega solicitar(@Valid @RequestBody Entrega entrega){
    return solicitacaoEntregaService.solicitar(entrega);
  }

  @GetMapping
  public List<Entrega> listar(){
    return entregaReposiroty.findAll();
  }

  @GetMapping("/{entregaId}")
  public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
    return entregaReposiroty.findById(entregaId)
            .map(entrega -> {
              EntregaModel entregaModel = new EntregaModel();
              return ResponseEntity.ok(entregaModel);
              
            }).orElse(ResponseEntity.notFound().build());
  }
  
}
