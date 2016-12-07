package br.com.usjt.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.usjt.Cryptograrfia.LerConta;


public class Acesso{

	private int agencia, conta, senha, codigoDeAcesso;
	private boolean validar;
	private ResourceBundle idioma;

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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getCodigoDeAcesso() {
		return codigoDeAcesso;		
	}

	public void setCodigoDeAcesso(int codigoDeAcesso) {
		this.codigoDeAcesso = codigoDeAcesso;
	}

	public ResourceBundle getIdioma() {
		return idioma;
	}

	public void setIdioma(ResourceBundle idioma) {
		this.idioma = idioma;
	}

	public boolean validar(Conta conta){
		LerConta lerConta = new LerConta();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\"+ getConta()));
		} catch (FileNotFoundException e1) {
			validar = false;
		}
		List<Conta> listaConta = new ArrayList<Conta>();
		String linha;

		try {
			while ((linha = reader.readLine()) != null) {
				listaConta.add(lerConta.descriptografar(linha));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (Conta conta2 : listaConta) {
			if(conta2.getAgencia() == getAgencia() && conta2.getSenha() == getSenha()){		
				validar = true;
			
				if(conta2.getCodAcesso() == 0){
					validar = false;
					String codigoGerado =""; 
					for(int x = 0; x<3; x++){
						int i = (int)(0+ (Math.random()*9));
						codigoGerado += i;
					}
						conta.setCodAcesso(Integer.parseInt(codigoGerado));
				
				}else{
//					TelaEntrarComCodigo entCod = new TelaEntrarComCodigo(conta2);
					try{//verifica se nenhum idioma foi selecionado
//						entCod.internacionalizar(getIdioma());
					}catch(NullPointerException e){//se nenhum idioma for selecionado ele começa com padrão pelo português
//						entCod.internacionalizar(ResourceBundle.getBundle("projeto", new Locale("pt", "BR")));
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "Verifique as informações digitadas!");
			}
		}
		return validar;
	}
}