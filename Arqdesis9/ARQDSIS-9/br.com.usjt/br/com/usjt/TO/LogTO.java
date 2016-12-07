package br.com.usjt.TO;

import java.util.Date;

public class LogTO {

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + agenciaDestino;
		result = prime * result + codigoCliente;
		result = prime * result + codigoItemLog;
		result = prime * result + codigoMovimento;
		result = prime * result + conta;
		result = prime * result + contaDestino;
		result = prime * result + ((dataOperacao == null) ? 0 : dataOperacao.hashCode());
		result = prime * result + ((operacao == null) ? 0 : operacao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogTO other = (LogTO) obj;
		if (agencia != other.agencia)
			return false;
		if (agenciaDestino != other.agenciaDestino)
			return false;
		if (codigoCliente != other.codigoCliente)
			return false;
		if (codigoItemLog != other.codigoItemLog)
			return false;
		if (codigoMovimento != other.codigoMovimento)
			return false;
		if (conta != other.conta)
			return false;
		if (contaDestino != other.contaDestino)
			return false;
		if (dataOperacao == null) {
			if (other.dataOperacao != null)
				return false;
		} else if (!dataOperacao.equals(other.dataOperacao))
			return false;
		if (operacao == null) {
			if (other.operacao != null)
				return false;
		} else if (!operacao.equals(other.operacao))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
}
