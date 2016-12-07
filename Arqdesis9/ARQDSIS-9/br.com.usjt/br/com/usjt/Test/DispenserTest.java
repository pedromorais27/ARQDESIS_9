package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import br.com.usjt.DAO.DispenserDAO;
import br.com.usjt.model.Dispenser;

public class DispenserTest {
	Dispenser dispenser;
	DispenserDAO dispenserDAO;
	

	@Before
	public void setUp() throws Exception {
		dispenserDAO = new DispenserDAO();
		dispenser = new Dispenser();
	}

	@Test
	public void contarNotas() {
		dispenser.contarNotas(100);
		assertEquals("testa se o saldo da conta retornado é 20000.0", true, dispenser.contarNotas(100));
	}

	@Test
	public void consultarExtratoDeNotas() {
		assertEquals("testa se o saldo da conta retornado é 20000.0", 3, dispenser.consultarExtratoDeNotas().size());
	}
}
