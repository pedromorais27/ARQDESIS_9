package br.com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.Factory.ConnectionFactory;
import br.com.usjt.TO.LogTO;

public class LogDAO {

	public ArrayList<LogTO> selec(LogTO log){
		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<LogTO> resultadoPesquisa = new ArrayList<LogTO>();
		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("SELECT * FROM Log")) {	
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()){  					
					log.setCodigoItemLog(rs.getInt(1));
					log.setCodigoMovimento(rs.getInt(2));
					log.setOperacao(rs.getString(3));
					log.setValor((rs.getInt(4)));
					log.setConta((rs.getInt(5)));
					log.setAgencia((rs.getInt(6)));
					log.setCodigoCliente(rs.getInt(7));
					log.setDataOperacao(rs.getDate(8));

					resultadoPesquisa.add(log);
				}  
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return resultadoPesquisa;
	}
		
	public LogTO insert(LogTO logTO) {

		java.sql.Date dataMov = new java.sql.Date(logTO.getDataOperacao().getTime());

		try (Connection conn = new ConnectionFactory().connection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO Log (codigoDoMovimento, tipoOperacao, valor, Conta, agencia, "
						+ "codigoDoCliente,  dataOperacao) VALUES (?,?,?,?,?,?,?)");) {
			stm.setInt(1, logTO.getCodigoMovimento());    
			stm.setString(2, logTO.getOperacao());  
			stm.setDouble(3, logTO.getValor());
			stm.setInt(4, logTO.getConta());    
			stm.setInt(5, logTO.getAgencia());    
			stm.setInt(6, logTO.getCodigoCliente());
			stm.setDate(7, dataMov);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logTO ;
	}
}