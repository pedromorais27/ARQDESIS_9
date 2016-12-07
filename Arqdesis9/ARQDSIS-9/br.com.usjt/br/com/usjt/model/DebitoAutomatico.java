package br.com.usjt.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import javax.swing.JOptionPane;
import br.com.usjt.DAO.DebitoAutomaticoDAO;
import br.com.usjt.TO.ContaTO;
import br.com.usjt.TO.DebitoAutomaticoTO;
import br.com.usjt.TO.MovimentoTO;

public class DebitoAutomatico{

	private int codigoConsumidor, codDebito;
	private String operadora, tipoDebito;
	private Date dataDebito;
	private double valorDebito;
	private int numConta, numAgencia;
	

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
	public void setDataDebito(Date dataDebito) throws ParseException {    
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
	
	private int getAgencia() {
		return numAgencia;
	}
	
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public ArrayList<DebitoAutomaticoTO> consultar() throws SQLException, ClassNotFoundException{

		DebitoAutomaticoDAO debitoAutomaticoDAO = new DebitoAutomaticoDAO();
		DebitoAutomaticoTO debitoAtutomaticoTO = new DebitoAutomaticoTO();

		debitoAtutomaticoTO.setNumConta(getNumConta());
		
		return debitoAutomaticoDAO.selec(debitoAtutomaticoTO);
	}

	public void gerarDebito(){
		
		DebitoAutomaticoDAO debitoAutomaticoDAO = new DebitoAutomaticoDAO();
		DebitoAutomaticoTO debitoAutomaticoTO = new DebitoAutomaticoTO();

		debitoAutomaticoTO.setTipoDebito(getTipoDebito());
		debitoAutomaticoTO.setOperadora(getOperadora());
		debitoAutomaticoTO.setCodigoConsumidor(getCodigoConsumidor());
		debitoAutomaticoTO.setDataDebito(getDataDebito());
		debitoAutomaticoTO.setValorDebito(getValorDebito());
		debitoAutomaticoTO.setNumConta(getNumConta());
		
		debitoAutomaticoDAO.insert(debitoAutomaticoTO);

		JOptionPane.showMessageDialog(null, "Debito automatico inserido com sucesso !!");
		
		MovimentoTO movimentoTO = new MovimentoTO();
		
		movimentoTO.setValorDaOperacao(getValorDebito());
		movimentoTO.setDataDoMovimento(getDataDebito());
		
		ContaTO contaTODestino = new ContaTO();
		ContaTO contaTO = new ContaTO();
		
		contaTO.setAgencia(contaTO.getAgencia());
		contaTO.setNumConta(contaTO.getNumConta());
		
		contaTODestino.setAgencia(0);
		contaTODestino.setNumConta(0);
		
		Movimento movimento = new Movimento();
		movimento.geraMovimento(contaTO, movimentoTO, contaTODestino, "Debito Automatico");
	}
}