package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.SaqueTO;
import br.com.usjt.model.Conta;

public class ContaTest {
	ContaDAO contaDAO;
	Conta conta;

	@Before
	public void setUp() throws Exception {
		contaDAO = new ContaDAO();
		conta = new Conta();
		conta.setNumConta(206107);
	}

	@Test
	public void consultarSaldo() {
		/*
		 * para dar certo os tesstes na contaDAO tem que ser feitos antes 
		 * */
		double saldo =  Double.parseDouble(conta.consultarSaldo());
		assertEquals("testa se o saldo da conta retornado é 20000.0", 20000,0, saldo);
	}

	@Test
	public void imprimir() throws IOException {
		assertEquals("testa se o saldo da conta retornado é 20000.0", true, conta.imprimir());
	}
}
