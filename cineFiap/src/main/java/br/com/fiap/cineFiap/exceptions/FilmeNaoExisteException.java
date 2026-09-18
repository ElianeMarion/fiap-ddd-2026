package br.com.fiap.cineFiap.exceptions;

public class FilmeNaoExisteException extends RuntimeException {
    public FilmeNaoExisteException(String message) {
        super(message);
    }
}
