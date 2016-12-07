package br.com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.Factory.ConnectionFactory;
import br.com.usjt.TO.DispenserTO;


public class DispenserDAO {

	private Connection connection;

	public boolean resetarDispencher() {
		try (Connection conn = new ConnectionFactory().connection();	
			PreparedStatement stm = conn.prepareStatement("UPDATE Dispenser SET QuantidadeDeNotas = 1000 WHERE nota = 10 or Nota = 20")) {
			stm.execute();
			PreparedStatement stm2 = conn.prepareStatement("UPDATE Dispenser SET QuantidadeDeNotas = 500 WHERE Nota = 50");
			stm2.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<DispenserTO> recuperarNotas() {
		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<DispenserTO> notas = new ArrayList<DispenserTO>();

		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM Dispenser")) {	
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()){  					
					notas.add(new DispenserTO(rs.getInt(1), rs.getInt(2)));
				}  

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return notas;
	}

	public boolean retirarNota(ArrayList<DispenserTO> arrayList){
		try {
			for (DispenserTO dispenserTO: arrayList) {
				PreparedStatement stmt = connection.prepareStatement("UPDATE dispenser SET QuantidadeDeNotas = ? WHERE Nota = ?");
				stmt.setInt(2, dispenserTO.getNota());
				stmt.setInt(1, dispenserTO.getQuantidade());
				stmt.execute();
			}
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}