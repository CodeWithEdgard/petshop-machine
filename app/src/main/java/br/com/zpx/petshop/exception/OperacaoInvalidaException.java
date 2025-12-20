package br.com.zpx.petshop.exception;

public class OperacaoInvalidaException extends RuntimeException {

    public OperacaoInvalidaException(String msg) {
        super(msg);
    }
}
