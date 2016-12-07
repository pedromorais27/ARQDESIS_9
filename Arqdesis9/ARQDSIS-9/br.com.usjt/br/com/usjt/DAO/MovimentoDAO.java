package br.com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.usjt.Factory.ConnectionFactory;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.MovimentoTO;

public class MovimentoDAO {

	private PreparedStatement stm;

	public MovimentoDAO() {
		try {
			// instância a classe ConnectionFactory para poder fazer a conexão com o banco de dados
			stm = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement selec(int conta){
		Connection conn;
		try {
			conn = new ConnectionFactory().connection();
			stm = conn.prepareStatement( "select * from Movimento WHERE numConta = ?");
			stm.setInt(1, conta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}

	public int selecCodigo(int conta){

		MovimentoTO movimentoTO = new MovimentoTO();
		int codigo = 0;
		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("select codigoMovimento from Movimento WHERE numConta = ?");) {
			stm.setInt(1, conta);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()){
					codigo = rs.getInt(1);
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return codigo;
	}

	public PreparedStatement selecBetween(Date DataInicial, Date dataFinal){
		Connection conn;
		try {
			conn = new ConnectionFactory().connection();
			stm = conn.prepareStatement( "SELECT * FROM Movimento WHERE dataOperacao BETWEEN ? AND ?");
			stm.setDate(1, new java.sql.Date(DataInicial.getTime()));
			stm.setDate(2, new java.sql.Date(dataFinal.getTime()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}

	public void insert(ContaTO contaTO, MovimentoTO movimentoTO, ContaTO contaTODestino, String tipo) {
		try (Connection conn = new ConnectionFactory().connection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO Movimento(numConta,dataOperacao,valorOperacao,"
						+ "agenciaDestino,contaDestino,tipoMovimento) VALUES(?,?,?,?,?,?)");) {
			java.sql.Date dateMovimento = new java.sql.Date(movimentoTO.getDataDoMovimento().getTime());

			stm.setInt(1, contaTO.getNumConta());
			stm.setDate(2, dateMovimento);
			stm.setDouble(3, movimentoTO.getValorDaOperacao());
			stm.setInt(4, contaTODestino.getAgencia());
			stm.setInt(5, contaTODestino.getNumConta());
			stm.setString(6, tipo);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}