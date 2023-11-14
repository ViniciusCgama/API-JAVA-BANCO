package org.acme.services;

import org.acme.GlobalExceptionHandler.ContaInvalidaException;
import org.acme.GlobalExceptionHandler.SaldoInsuficienteException;
import org.acme.Models.ContaCorrente;

public interface ContaCorrenteService {
    //Implementação da API Stream!
    ContaCorrente getContaPorNumero(String numeroConta);

    void transferir(String contaOrigem, String contaDestino, double valor) throws ContaInvalidaException, SaldoInsuficienteException;
}
