package br.com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.usjt.Factory.ConnectionFactory;
import br.com.usjt.TO.DebitoAutomaticoTO;

public class DebitoAutomaticoDAO {
	private PreparedStatement stm;

	public DebitoAutomaticoDAO() {
		try {
			stm = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DebitoAutomaticoTO> selec(DebitoAutomaticoTO debitoAtutomaticoTO){
		//cria um arrayList para serem armazenado todas as informações do banco de dados
		ArrayList<DebitoAutomaticoTO> resultadoPesquisa = new ArrayList<DebitoAutomaticoTO>();
		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("select * from dedbitoAutomatico WHERE conta = ?")) {
			stm.setInt(1, debitoAtutomaticoTO.getNumConta());
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()){  
					debitoAtutomaticoTO.setCodDebito(rs.getInt(1));
					debitoAtutomaticoTO.setTipoDebito(rs.getString(2));
					debitoAtutomaticoTO.setOperadora(rs.getString(3));
					debitoAtutomaticoTO.setCodigoConsumidor(rs.getInt(4));
					debitoAtutomaticoTO.setDataDebito(rs.getDate(5));  
					debitoAtutomaticoTO.setValorDebito(rs.getDouble(6));
					debitoAtutomaticoTO.setNumConta(rs.getInt(7));
					resultadoPesquisa.add(debitoAtutomaticoTO);
				}  
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return resultadoPesquisa;
	}

	public DebitoAutomaticoTO insert(DebitoAutomaticoTO debitoAutomaticoTO){

		java.sql.Date dataBanco = new java.sql.Date(debitoAutomaticoTO.getDataDebito().getTime());

		try (Connection conn = new ConnectionFactory().connection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO dedbitoAutomatico(tipoDebito,operadora,codigoConsumidor,dataDebitol,valorDebito,conta) VALUES(?,?,?,?,?,?)");) {
			stm.setString(1, debitoAutomaticoTO.getTipoDebito());    
			stm.setString(2, debitoAutomaticoTO.getOperadora());  
			stm.setInt(3, debitoAutomaticoTO.getCodigoConsumidor());
			stm.setDate(4, dataBanco);    
			stm.setDouble(5, debitoAutomaticoTO.getValorDebito());    
			stm.setInt(6, debitoAutomaticoTO.getNumConta());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return debitoAutomaticoTO;
	}
}