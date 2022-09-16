package br.com.juwer.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juwer.algalog.domain.model.Cliente;
import br.com.juwer.algalog.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping
  public List<Cliente> listar(){
    return clienteRepository.findAll(); 
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente>  listarPorId(@PathVariable Long id){
      return clienteRepository.findById(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());

      // Optional<Cliente> cliente = clienteRepository.findById(id);

      // if(cliente.isPresent()){
      //   return ResponseEntity.ok(cliente.get());
      // }

      // return ResponseEntity.notFound().build();
  }
}
