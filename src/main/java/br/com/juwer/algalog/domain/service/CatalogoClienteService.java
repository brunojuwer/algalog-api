package br.com.juwer.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.juwer.algalog.domain.exception.NegocioExeption;
import br.com.juwer.algalog.domain.model.Cliente;
import br.com.juwer.algalog.domain.repository.ClienteRepository;


@Service
public class CatalogoClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Transactional
  public Cliente salvar(Cliente cliente) {

    boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
      .stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

    if(emailEmUso) {
      throw new NegocioExeption("Email já cadastrado");
    }

    return clienteRepository.save(cliente);
  }

  @Transactional
  public void excluir(long id){
    clienteRepository.deleteById(id);
  }


}
