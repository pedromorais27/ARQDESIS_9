package br.com.usjt.TO;

public class TransferenciaTO {

	private int agenciaDestino, contaDestino, conta;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agenciaDestino;
		result = prime * result + conta;
		result = prime * result + contaDestino;
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
		TransferenciaTO other = (TransferenciaTO) obj;
		if (agenciaDestino != other.agenciaDestino)
			return false;
		if (conta != other.conta)
			return false;
		if (contaDestino != other.contaDestino)
			return false;
		return true;
	}
}
