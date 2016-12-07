package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import br.com.usjt.TO.ContaTO;

public class ContaTOTest {
	ContaTO contaTO;
	
	@Before
	public void setUp() throws Exception {
		contaTO = new ContaTO();
		contaTO.setAgencia(154);
		contaTO.setNumConta(655070);
		contaTO.setNome("Gabrielle Castelo");
		contaTO.setSaldo(30000.0);
	}
	
	@Test
	public void testGets() {
		assertEquals("getAgencia", contaTO.getAgencia(), 154);
		assertEquals("getNumConta", contaTO.getNumConta(), 655070);
		assertEquals("getNome", contaTO.getNome(), "Gabrielle Castelo");
		assertEquals("getSaldo", contaTO.getSaldo(), contaTO.getSaldo());
	}
	
	@Test
	public void testEquals(){
		ContaTO conta = new ContaTO();
		conta.setAgencia(contaTO.getAgencia());
		conta.setNumConta(contaTO.getNumConta());
		conta.setNome(contaTO.getNome());
		conta.setSaldo(contaTO.getSaldo());
		assertEquals("teste contaTO é igual a Conta", contaTO, conta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaTOTest other = (ContaTOTest) obj;
		if (contaTO == null) {
			if (other.contaTO != null)
				return false;
		} else if (!contaTO.equals(other.contaTO))
			return false;
		return true;
	}
}
