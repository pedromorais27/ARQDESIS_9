package br.com.usjt.model;

import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.usjt.DAO.ContaDAO;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.MovimentoTO;
import br.com.usjt.TO.SaqueTO;

public class Saque extends Movimento {

	private Dispenser dispenser;
	private Double saque;

	public Saque() {
		dispenser = new Dispenser();
	}

	public Saque(Movimento movimento) {
		dispenser = new Dispenser();
	} 


	public Double getSaque() {
		return saque;
	}

	public void setSaque(Double saque) {
		this.saque = saque;
	}

	public boolean fazerSaque(Conta conta, double valorSacar) throws IOException {
		ContaDAO contaDAO = new ContaDAO();
		SaqueTO saqueTO = new SaqueTO();
		ContaTO contaTO = contaDAO.selectSaldo(conta.getNumConta());
		
		saqueTO.setSaque(contaTO.getSaldo());

		double saldoAtual = contaTO.getSaldo();

		boolean teste; //variavel para teste no junit
		if(saldoAtual >= valorSacar){
			
			dispenser.contarNotas(valorSacar);

			double novosaldo = saldoAtual - valorSacar;

			saqueTO.setSaque(novosaldo);
			contaTO.setNumConta(conta.getNumConta());

			contaDAO.updateSaque(contaTO, saqueTO);

			Date dataDeHoje = new Date(); 

			MovimentoTO movimentoTO = new MovimentoTO();
			movimentoTO.setDataDoMovimento(dataDeHoje);
			movimentoTO.setValorDaOperacao(valorSacar);

			contaTO.setAgencia(conta.getAgencia());
			contaTO.setNumConta(conta.getNumConta());

			ContaTO contaTODestino = new ContaTO();

			contaTODestino.setAgencia(conta.getAgencia());
			contaTODestino.setNumConta(conta.getNumConta());

			geraMovimento(contaTO, movimentoTO, contaTODestino, "Debito em Conta corrente");
			teste = true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque");
			teste = false;
		}
		return true;
	}
}