package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.usjt.model.Conta;
import br.com.usjt.model.Dispenser;
import br.com.usjt.model.Saque;

public class SaqueTest {
	Saque saque;
	Conta conta;
	Dispenser dispenser;

	@Before
	public void setUp() throws Exception {
		saque = new Saque();
		conta = new Conta();
		dispenser = new Dispenser();
		conta.setNumConta(206107);
		conta.setAgencia(6234);
	}

	@Test
	public void fazerSaque() throws IOException {
		assertEquals("testa se o saldo da conta retornado é 20000.0", true, saque.fazerSaque(conta, 200));
	}
}
