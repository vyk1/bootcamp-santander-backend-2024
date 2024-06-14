package com.bankoo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankooTest {

    @Test
    public void inicializaBancoComNome() {
        Banco banco = new Banco();
        banco.setNome("BankOO");

        assertEquals("BankOO", banco.getNome());
    }
}
