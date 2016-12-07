package br.com.usjt.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.sql.SQLException;
import org.junit.Test;
import br.com.usjt.Factory.ConnectionFactory;


public class ConnectionFactoryTest {

	@Test
	public void testObterConexao() {
		try {
			assertNotNull("testa se a conexao nao e nula", ConnectionFactory.connection());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}
}