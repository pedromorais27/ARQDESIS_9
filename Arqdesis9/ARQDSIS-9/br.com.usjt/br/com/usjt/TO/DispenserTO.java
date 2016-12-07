package br.com.usjt.TO;

public class DispenserTO {

	private int nota, quantidade;
	
	public DispenserTO(int nota, int quantidade) {
		this.nota = nota;
		this.quantidade = quantidade;
	}
	
	public DispenserTO() {
	}

	public int getNota() {
		return nota;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispenserTO other = (DispenserTO) obj;
		if (nota != other.nota)
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}
	
}
