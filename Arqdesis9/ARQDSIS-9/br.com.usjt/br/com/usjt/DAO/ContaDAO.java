package br.com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.usjt.Factory.ConnectionFactory;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.SaqueTO;

public class ContaDAO {
	private PreparedStatement stm;

	public ContaDAO() {
		try {
			stm = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String  innerJoin(int numConta) {

		String nome = "";

		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("SELECT nomeCliente from Cliente inner join Conta on Conta.codigoCliente = Cliente.codigoCliente where conta = ?")) {
			stm.setInt(1, numConta);

			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()){  
					nome = rs.getString(1);
				}  

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return nome;
	}

	public int  selectCodigoCliente(int numConta){
		int codigoCliente = 0;
	
		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("SELECT codigoCliente FROM Conta WHERE conta.conta = ?")) {
				stm.setInt(1, numConta);
				
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()){  
					codigoCliente = rs.getInt(1);
				}  
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return codigoCliente;
	}

	public ContaTO selectSaldo(int numConta){
		ContaTO contaTO = new ContaTO();

		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("SELECT saldo FROM Conta WHERE conta.conta = ?")) {
			stm.setInt(1, numConta);

			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()){  
					contaTO.setSaldo(rs.getDouble(1));
				}  

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return contaTO;
	}

	public SaqueTO updateSaque(ContaTO contaTO, SaqueTO saqueTO){

		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("update Conta set saldo = ? where conta = ?")) {
			stm.setDouble(1, saqueTO.getSaque());
			stm.setInt(2, contaTO.getNumConta());
			stm.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saqueTO;
	}
	
	public ContaTO updateTransferencia(ContaTO contaTO){

		try (Connection conn = new ConnectionFactory().connection();	
				PreparedStatement stm = conn.prepareStatement("update Conta set saldo = ? where conta = ?")) {
			stm.setDouble(1, contaTO.getSaldo());
			stm.setInt(2, contaTO.getNumConta());
			stm.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contaTO;
	}
}