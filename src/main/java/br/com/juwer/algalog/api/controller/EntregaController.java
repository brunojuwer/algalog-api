package br.com.juwer.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.juwer.algalog.api.assembler.EntregaAssembler;
import br.com.juwer.algalog.api.model.EntregaModel;
import br.com.juwer.algalog.api.model.input.EntregaInput;
import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.repository.EntregaReposiroty;
import br.com.juwer.algalog.domain.service.FinalizacaoEntregaService;
import br.com.juwer.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
  
  private SolicitacaoEntregaService solicitacaoEntregaService;
  private EntregaReposiroty entregaReposiroty;
  private EntregaAssembler entregaAssembler;
  private FinalizacaoEntregaService finalizacaoEntregaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput){
    Entrega entregaEntity = entregaAssembler.toEntity(entregaInput);
    return entregaAssembler
            .toModel(solicitacaoEntregaService.solicitar(entregaEntity));
  }

  @PutMapping("/{entregaId}/finalizacao")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void finalizar(@PathVariable Long entregaId){
    finalizacaoEntregaService.finalizar(entregaId);
  }

  @GetMapping
  public List<EntregaModel> listar(){
    return entregaAssembler.toCollectionModel(entregaReposiroty.findAll());
  }

  @GetMapping("/{entregaId}")
  public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
    return entregaReposiroty.findById(entregaId)
            .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
            .orElse(ResponseEntity.notFound().build());
  }
}
