package com.bankoo;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;

@Data
public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<>();

	public void adicionarConta(Conta conta) {
		for (Conta c : contas) {
			if (c.getCliente().equals(conta.getCliente()) && c.getClass().equals(conta.getClass())) {
				throw new RuntimeException("Cliente já possui este tipo de conta no banco");
			}
		}
		contas.add(conta);
	}

}
