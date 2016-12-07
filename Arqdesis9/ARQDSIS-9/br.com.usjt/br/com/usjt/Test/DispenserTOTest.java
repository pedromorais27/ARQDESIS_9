package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import br.com.usjt.TO.DispenserTO;

public class DispenserTOTest {
	DispenserTO dispenserTO;
	
	@Before
	public void setUp() throws Exception {
		dispenserTO = new DispenserTO();
		dispenserTO.setNota(20);
		dispenserTO.setQuantidade(1000);
	}
	
	@Test
	public void testGets() {
		assertEquals("getNota", dispenserTO.getNota(), 20);
		assertEquals("getQuantidade", dispenserTO.getQuantidade(), 1000);
	}
	
	@Test
	public void testEquals(){
		DispenserTO dispenser = new DispenserTO();
		dispenser.setNota(dispenserTO.getNota());
		dispenser.setQuantidade(dispenserTO.getQuantidade());
		assertEquals("teste contaTO é igual a Conta", dispenserTO, dispenser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispenserTOTest other = (DispenserTOTest) obj;
		if (dispenserTO == null) {
			if (other.dispenserTO != null)
				return false;
		} else if (!dispenserTO.equals(other.dispenserTO))
			return false;
		return true;
	}
}