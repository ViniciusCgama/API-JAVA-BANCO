package org.acme.Models;

import org.acme.GlobalExceptionHandler.SaldoInsuficienteException;

public class ContaBancaria {
    private String numeroConta;
    private Double saldo;
    private Cliente titular;
    private static final double TAXA_DE_TRANSFERENCIA = 0.001;

    public ContaBancaria(String numeroConta, double saldo, Cliente titular) {
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido.");
        }
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("Valor de %.2f depositado na conta de número %s \n", valor, this.numeroConta);
    }

    public void transferir(ContaBancaria origem, ContaBancaria destino, double valor) {
        try {
            if (origem.getSaldo() < valor) {
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferência.");
            }
            origem.equals(origem.getSaldo() - valor - ( valor * TAXA_DE_TRANSFERENCIA ));
            destino.equals(destino.getSaldo() + valor);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getSaldo() {

        return 0;
    }

    public Object getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Object numeroConta) {
        this.numeroConta = (String) numeroConta;
    }
}
