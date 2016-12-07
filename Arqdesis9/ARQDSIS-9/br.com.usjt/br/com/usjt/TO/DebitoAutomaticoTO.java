package br.com.usjt.TO;

import java.util.Date;

public class DebitoAutomaticoTO {
	private int codigoConsumidor, codDebito;
	private String operadora, tipoDebito;
	private Date dataDebito;
	private double valorDebito;
	private int numConta;
	
	public int getCodDebito() {
		return codDebito;
	}

	public void setCodDebito(int codDebito) {
		this.codDebito = codDebito;
	}

	public String getTipoDebito() {
		return tipoDebito;
	}
	public void setTipoDebito(String tipoDebito) {
		this.tipoDebito = tipoDebito;

	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public int getCodigoConsumidor() {
		return codigoConsumidor;
	}
	public void setCodigoConsumidor(int codigoConsumidor) {
		this.codigoConsumidor = codigoConsumidor;
	}
	
	public Date getDataDebito() {
		return dataDebito;
	}
	public void setDataDebito(Date dataDebito){    
		this.dataDebito = dataDebito;
	}
	
	public double getValorDebito() {
		return valorDebito;
	}
	
	public void setValorDebito(double valorDebito) {
		this.valorDebito = valorDebito;
	}

	public int getNumConta() {
		return numConta;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codDebito;
		result = prime * result + codigoConsumidor;
		result = prime * result + ((dataDebito == null) ? 0 : dataDebito.hashCode());
		result = prime * result + numConta;
		result = prime * result + ((operadora == null) ? 0 : operadora.hashCode());
		result = prime * result + ((tipoDebito == null) ? 0 : tipoDebito.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDebito);
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
		DebitoAutomaticoTO other = (DebitoAutomaticoTO) obj;
		if (codDebito != other.codDebito)
			return false;
		if (codigoConsumidor != other.codigoConsumidor)
			return false;
		if (dataDebito == null) {
			if (other.dataDebito != null)
				return false;
		} else if (!dataDebito.equals(other.dataDebito))
			return false;
		if (numConta != other.numConta)
			return false;
		if (operadora == null) {
			if (other.operadora != null)
				return false;
		} else if (!operadora.equals(other.operadora))
			return false;
		if (tipoDebito == null) {
			if (other.tipoDebito != null)
				return false;
		} else if (!tipoDebito.equals(other.tipoDebito))
			return false;
		if (Double.doubleToLongBits(valorDebito) != Double.doubleToLongBits(other.valorDebito))
			return false;
		return true;
	}
}
