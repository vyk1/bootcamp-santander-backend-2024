package com.bankoo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankooTest {

    @Test
    public void aoInicializarBancoDeveTerZeroContas() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        assertEquals("BankOO", banco.getNome());
        assertEquals(0, banco.getContas().size());

    }

    @Test
    public void aoAdicionarContaDeveIncrementarNumeroDeContas() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        banco.adicionarConta(cc);

        assertEquals(1, banco.getContas().size());
    }

    @Test
    public void aoAdicionarContaDuplicadaDeveLancarExcecao() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        banco.adicionarConta(cc);

        assertThrows(RuntimeException.class, () -> banco.adicionarConta(cc));
    }

    @Test
    public void aoAdicionarContaDiferenteDeveIncrementarNumeroDeContas() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        assertEquals(2, banco.getContas().size());
    }

    @Test
    public void aoAdicionarContaDiferenteDevePermitirMesmoCliente() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        assertEquals(2, banco.getContas().size());
    }

    @Test
    public void aoSacarValorMaiorQueSaldoDeveLancarExcecao() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        banco.adicionarConta(cc);
        cc.depositar(100);

        assertThrows(RuntimeException.class, () -> cc.sacar(200));
    }

    @Test
    public void aoDepositarValorMaiorQueSaldoDeveLancarExcecao() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        banco.adicionarConta(cc);

        assertThrows(RuntimeException.class, () -> cc.depositar(-100));
    }

    @Test
    public void aoTransferirValorMaiorQueSaldoDeveLancarExcecao() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(100);

        assertThrows(RuntimeException.class, () -> cc.transferir(200, poupanca));
    }

    @Test
    public void aoTransferirValorMenorQueSaldoDeveDecrementarSaldo() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(100);
        cc.transferir(50, poupanca);

        assertEquals(50, cc.getSaldo());
    }

    @Test
    public void aoSacarValorMenorQueSaldoDeveDecrementarSaldo() {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        cc.depositar(100);
        cc.sacar(50);

        assertEquals(50, cc.getSaldo());
    }
}
