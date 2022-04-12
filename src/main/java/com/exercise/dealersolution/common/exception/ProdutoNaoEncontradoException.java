package com.exercise.dealersolution.common.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

  public ProdutoNaoEncontradoException() {
    super("Produto não encontrado");
  }
}
