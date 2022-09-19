package br.com.juwer.algalog.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioExeption {

  private static final Long serialVersionUID = 1L;

  public EntidadeNaoEncontradaException(String message) {
    super(message);
  }
  
  
}
