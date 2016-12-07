package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import br.com.usjt.TO.SaqueTO;

public class SaqueTOTest {
	SaqueTO saqueTO;
	
	@Before
	public void setUp() throws Exception {
		saqueTO = new SaqueTO();
		saqueTO.setConta(206107);
		saqueTO.setAgencia(6234);
		saqueTO.setSaque(200.0);
	}
	
	@Test
	public void testGets() {
		assertEquals("getConta", saqueTO.getConta(), 206107);
		assertEquals("getAgencia", saqueTO.getAgencia(), 6234);
		assertEquals("getSaque", saqueTO.getSaque(), saqueTO.getSaque());
	}
	
	@Test
	public void testEquals(){
		SaqueTO saque = new SaqueTO();
		saque.setAgencia(saqueTO.getAgencia());
		saque.setConta(saqueTO.getConta());
		saque.setSaque(saqueTO.getSaque());
		assertEquals("teste contaTO é igual a Conta", saqueTO, saque);
	}
}