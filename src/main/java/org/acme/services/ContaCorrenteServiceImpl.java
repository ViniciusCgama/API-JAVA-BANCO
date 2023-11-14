package org.acme.services;


import org.acme.GlobalExceptionHandler.ContaInvalidaException;
import org.acme.GlobalExceptionHandler.SaldoInsuficienteException;
import org.acme.Models.ContaBancaria;
import org.acme.Models.ContaCorrente;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContaCorrenteServiceImpl implements ContaCorrenteService {
    private final List<ContaCorrente> contasCorrentes;
    private static final AtomicInteger contadorContas = new AtomicInteger(1);


    public ContaCorrenteServiceImpl(List<ContaCorrente> contasCorrentes) {
        this.contasCorrentes = contasCorrentes;
    }

    //Implementação da API Stream!
    @Override
    public ContaCorrente getContaPorNumero(String numeroConta) {
        return contasCorrentes.stream()
                .filter(conta -> conta.getNumeroConta().equals(numeroConta))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void transferir(String contaOrigem, String contaDestino, double valor) throws ContaInvalidaException, SaldoInsuficienteException {
        ContaBancaria origem = getContaPorNumero(contaOrigem);
        ContaBancaria destino = getContaPorNumero(contaDestino);

        if (origem == null || destino == null) {
            throw new ContaInvalidaException("Conta de origem ou destino inválida. Por favor, verifique os números das contas.");
        }
        if (origem.getSaldo() >= valor) origem.transferir(origem, destino, valor);
        else {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferência.");
        }
    }

    private String gerarNumeroContaUnico() {
        return String.format("%05d", contadorContas.getAndIncrement());
    }
}