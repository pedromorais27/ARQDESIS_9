package br.com.usjt.TO;

import java.util.Date;

public class MovimentoTO {
	private int codigoMovimento;
	private Date dataDoMovimento;
	private double valorDaOperacao;


	public int getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(int codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
	}

	public Date getDataDoMovimento() {
		return dataDoMovimento;
	}

	public void setDataDoMovimento(Date dataDoMovimento) {
		this.dataDoMovimento = dataDoMovimento;
	}

	public double getValorDaOperacao() {
		return valorDaOperacao;
	}

	public void setValorDaOperacao(double valorDaOperacao) {
		this.valorDaOperacao = valorDaOperacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoTO other = (MovimentoTO) obj;
		if (codigoMovimento != other.codigoMovimento)
			return false;
		if (dataDoMovimento == null) {
			if (other.dataDoMovimento != null)
				return false;
		} else if (!dataDoMovimento.equals(other.dataDoMovimento))
			return false;
		if (Double.doubleToLongBits(valorDaOperacao) != Double.doubleToLongBits(other.valorDaOperacao))
			return false;
		return true;
	}
}