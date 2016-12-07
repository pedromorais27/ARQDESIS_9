package br.com.usjt.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import br.com.usjt.DAO.DispenserDAO;
import br.com.usjt.TO.DispenserTO;

public class DispenserDAOTest {
	DispenserDAO dispenserDAO;
	DispenserTO dispenserTO;

	/*
	 * Lembre-se de quando criar a tabela do dispenser de executar inicialmente os inserts com os nomes das notas
	 * INSERT INTO Dispenser (Nota) VALUES (20);
	 * INSERT INTO Dispenser (Nota) VALUES (10);
	 * INSERT INTO Dispenser (Nota) VALUES (50);
	 * */
	
	@Before
	public void setUp() throws Exception {
		dispenserDAO = new DispenserDAO();
		dispenserTO = new DispenserTO(20, 10);	
	}
	
	@Test
	public void resetarDispencher() {
		boolean reset = dispenserDAO.resetarDispencher();
		assertEquals("testa o nome do cliente que o innerJoin retorna", true , reset);
	}
	
	@Test
	public void recuperarNotas() {
		ArrayList<DispenserTO> reset = dispenserDAO.recuperarNotas();
		assertEquals("testa o nome do cliente que o innerJoin retorna", 3 , reset.size());
	}
	
	public void retirarNota() {
		assertEquals("testa o nome do cliente que o innerJoin retorna", true , dispenserDAO.retirarNota(dispenserDAO.recuperarNotas()));
	}	
}
