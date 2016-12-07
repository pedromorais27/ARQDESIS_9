package br.com.usjt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import br.com.usjt.DAO.LogDAO;
import br.com.usjt.TO.LogTO;

public class Log{
	private int codigoItemLog, agencia, conta, codigoCliente, codigoMovimento, agenciaDestino, contaDestino;
	private Date dataOperacao;
	private double valor;
	private String operacao;

	public int getCodigoItemLog() {
		return codigoItemLog;
	}
	public void setCodigoItemLog(int codigoItemLog) {
		this.codigoItemLog = codigoItemLog;
	}

	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public Date getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(int codMovimento) {
		this.codigoMovimento = codMovimento;
	}


	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}

	public int getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(int agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}

	public void incluir(){
		LogDAO logDAO = new LogDAO();
		LogTO logTO = new LogTO();
		
		logTO.setOperacao(getOperacao());
		logTO.setValor(getValor());
		logTO.setConta(getConta());
		logTO.setAgencia(getAgencia());
		logTO.setDataOperacao(getDataOperacao());
		logTO.setCodigoMovimento(getCodigoMovimento());
		logTO.setCodigoCliente(getCodigoCliente());

		logDAO.insert(logTO);
	}

	public ArrayList<LogTO> consultarestatisticas() {	
		LogDAO logDao = new LogDAO();
		LogTO logTO = new LogTO();
	
		return logDao.selec(logTO);
	}
}