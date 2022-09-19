package br.com.juwer.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.juwer.algalog.api.assembler.OcorrenciaAssembler;
import br.com.juwer.algalog.api.model.OcorrenciaModel;
import br.com.juwer.algalog.api.model.input.OcorrenciaInput;
import br.com.juwer.algalog.domain.model.Entrega;
import br.com.juwer.algalog.domain.model.Ocorrencia;
import br.com.juwer.algalog.domain.service.BuscaEntregaService;
import br.com.juwer.algalog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
  
  private BuscaEntregaService buscaEntregaService;
  private RegistroOcorrenciaService registroOcorrenciaService;
  private OcorrenciaAssembler ocorrenciaAssembler;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OcorrenciaModel registrar(@PathVariable Long entregaId, 
                    @Valid @RequestBody OcorrenciaInput ocorrenciaInput ){
                    
      Ocorrencia ocorrenciaRegistrada = 
        registroOcorrenciaService
        .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
  }

  @GetMapping
  public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
  }
}
