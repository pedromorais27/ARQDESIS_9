package br.com.usjt.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.MovimentoTO;

public class Transferencia extends Movimento{

	private int agenciaDestino, contaDestino, conta;

	public Transferencia(Movimento movimento) {

	}

	public int getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(int agenciaDestino) {
		this.agenciaDestino = agenciaDestino;

	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}

	public void fazeTransferencia() throws SQLException, NumberFormatException, IOException, ClassNotFoundException{
		Double saldoTitular = 0.0;
		Double saldoContaTransferir = 0.0;

		FileReader txtConta = new FileReader (""+ getContaDestino());

		BufferedReader entrada = new BufferedReader(txtConta);

		ArrayList<Integer> linhasTxt = new ArrayList<Integer>();
		String texto;

		while((texto = entrada.readLine()) != null){

			linhasTxt.add(Integer.parseInt(texto, 16));//converte de hexadecimal para inteiro

		}

		int conta = linhasTxt.get(0);
		int agencia = linhasTxt.get(1);

		if(agencia == getAgenciaDestino() && conta == getContaDestino()){
			ContaDAO contaDAO = new ContaDAO();
			ContaTO contaTO = contaDAO.selectSaldo(getConta());
			
			saldoTitular = contaTO.getSaldo();
			
			contaTO = contaDAO.selectSaldo(getContaDestino());
			
			saldoContaTransferir = contaTO.getSaldo();

			double novoSaldoContaDestino =  saldoContaTransferir + getValorDaOperacao();
			double novoSaldoContaDebitada = saldoTitular - getValorDaOperacao();
			
			contaTO.setNumConta(getConta());
			contaTO.setSaldo(novoSaldoContaDebitada);			
			
			contaDAO.updateTransferencia(contaTO);
			
			contaTO.setNumConta(getContaDestino());
			contaTO.setSaldo(novoSaldoContaDestino);
			contaDAO.updateTransferencia(contaTO);
		
			Date dataHoje = new Date(); 

			MovimentoTO movimentoTO = new MovimentoTO();
			movimentoTO.setDataDoMovimento(dataHoje);
			movimentoTO.setValorDaOperacao(getValorDaOperacao());
			
			ContaTO contaTODestino = new ContaTO();
			contaTODestino.setAgencia(getAgenciaDestino());
			contaTODestino.setNumConta(getConta());
			
			geraMovimento(contaTO, movimentoTO, contaTODestino,"Debito em Conta corrente");
			
			JOptionPane.showMessageDialog(null, "Transferencia Realizada com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "favor verifique as informacoes da conta a ser creditada");
		}
	}
}