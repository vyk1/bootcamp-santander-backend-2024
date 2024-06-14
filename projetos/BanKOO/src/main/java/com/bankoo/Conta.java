package com.bankoo;

import lombok.Data;

@Data
public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected boolean isBloqueada;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		validarSaldo(valor);
		saldo -= valor;
	}

	public void validarSaldo(double valor) {
		validarContaBloqueada();
		if (valor <= 0) {
			throw new RuntimeException("Valor inválido");
		}

		if (this.saldo < valor) {
			throw new RuntimeException("Saldo insuficiente");
		}

		if (saldo - valor < 0) {
			throw new RuntimeException("Saldo insuficiente");
		}
	}

	@Override
	public void depositar(double valor) {
		validarContaBloqueada();
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public void validarContaBloqueada() {
		if (isBloqueada) {
			throw new RuntimeException("Conta bloqueada");
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
