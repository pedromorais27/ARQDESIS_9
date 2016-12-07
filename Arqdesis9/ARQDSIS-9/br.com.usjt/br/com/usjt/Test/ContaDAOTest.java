package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.SaqueTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaDAOTest {

	ContaDAO contaDAO;
	ContaTO contaTO;
	SaqueTO saqueTO;

	/*
	 * 
	 * Antes de rodar esse teste, rode o banco de dados e crie na tabela cliente execute os dois inserts que 
	 * estão logo a baixo dela no proprio script, importante criar a tabela conta tambem e fazer os dois inserts .
	 * Alem disso, a ordem de execução dos testes Ã© importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 * 
	 */	

	@Before
	public void setUp() throws Exception {
		contaDAO = new ContaDAO();
		contaTO = new ContaTO();
		saqueTO = new SaqueTO();
		contaTO.setNumConta(206107);
		contaTO.setNome("Anderson Santos");
		saqueTO.setSaque(20000.0);

	}

	@Test
	public void innerJoin() {
		/*
		 * Para funcionar é necessario o insert na tabela conta:
		 * INSERT INTO Conta (conta, codigoCliente, banco, agencia, saldo ) VALUES ("206107", "1", "1", "6234", "20000");
		 * e o insert na tabela cliente:
		 * INSERT INTO Cliente (codigoCliente, nomeCliente) VALUES ("1", "Anderson Santos"); 
		 * */

		String nomeRetorno = contaDAO.innerJoin(contaTO.getNumConta());
		assertEquals("testa o nome do cliente que o innerJoin retorna", contaTO.getNome() , nomeRetorno);
	}

	@Test
	public void selectCodigoCliente() {
		int codigoDoCliente = 1;
		int codigoRetorno = contaDAO.selectCodigoCliente(contaTO.getNumConta());
		assertEquals("testa se o coigo do cliente retorna 1", codigoDoCliente , codigoRetorno);
	}

	@Test
	public void updateSaque() {
		SaqueTO saqueTO  = contaDAO.updateSaque(contaTO, this.saqueTO);
		assertEquals("testa se o valor do saldo foi alterado", 20000,0 , saqueTO.getSaque());
	}

	@Test
	public void selectSaldo() {
		ContaTO contaSaldo = contaDAO.selectSaldo(contaTO.getNumConta());
		assertEquals("testa se retorna o saldo", contaSaldo.getSaldo() , contaSaldo.getSaldo());
	}
}