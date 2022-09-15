package br.com.juwer.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
  
  private long id;
  private String nome;
  private String email;
  private String telefone;

}
