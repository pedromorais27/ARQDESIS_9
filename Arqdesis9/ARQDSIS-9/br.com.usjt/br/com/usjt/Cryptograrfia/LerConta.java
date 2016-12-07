package br.com.usjt.Cryptograrfia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import br.com.usjt.model.Conta;


public class LerConta {

	public boolean incluirConta(Conta conta) throws Exception {
		String linhaInlcuir = cryptoConta(conta);
		new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy" +conta.getNumConta()+"").delete();
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\"+conta.getNumConta()));
		writer.write(linhaInlcuir);
		writer.close();
		return true;
	}
	
	public String cryptoConta(Conta conta) throws Exception {
		Crypto crypto = new Crypto();

		String addNoTexto = "";
		byte[] byt;

		byt = (conta.getAgencia() + "").getBytes();
		crypto.geraCifra(byt, new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		addNoTexto += new String(crypto.getTextoCifrado()) + " ";

		byt = (conta.getNumConta() + "").getBytes();
		crypto.geraCifra(byt, new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		addNoTexto += new String(crypto.getTextoCifrado()) + " ";

		byt = (conta.getSenha() + "").getBytes();
		crypto.geraCifra(byt, new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		addNoTexto += new String(crypto.getTextoCifrado()) + " ";

		byt = (conta.getCodAcesso() + "").getBytes();
		crypto.geraCifra(byt, new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		addNoTexto += new String(crypto.getTextoCifrado()) + " ";

		return addNoTexto;

	}
	
	public Conta descriptografar(String linha) throws Exception {
		Conta retorno = new Conta();
		Crypto crypto = new Crypto();
		String dado[] = linha.split(" ");

		crypto.geraDecifra(dado[0].getBytes(), new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		retorno.setAgencia(Integer.parseInt(new String(crypto
				.getTextoDecifrado())));

		crypto.geraDecifra(dado[1].getBytes(), new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		retorno.setNumConta(Integer.parseInt(new String(crypto.getTextoDecifrado())));

		crypto.geraDecifra(dado[2].getBytes(), new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		retorno.setSenha(Integer.parseInt(new String(crypto.getTextoDecifrado())));

		crypto.geraDecifra(dado[3].getBytes(), new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"));
		retorno.setCodAcesso(Integer.parseInt(new String(crypto
				.getTextoDecifrado())));
		return retorno;
	}

	public Conta buscarConta(List<Conta> listaConta, int i, int f, Conta conta) {
		if (i > f)
			return null;

		int meio = (i + f) / 2;

		if (listaConta.get(meio).equals(conta))
			return listaConta.get(meio);

		if (listaConta.get(meio).compareTo(conta) > 0)
			return buscarConta(listaConta, i, meio - 1, conta);
		else
			return buscarConta(listaConta, meio + 1, f, conta);

	}
	
	
	public boolean substituirConta(Conta conta) throws Exception {

		String arquivo ="C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\chave.dummy"+ conta.getNumConta();
		String arquivoTmp = "C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\Projeto_ARQDSIS\\registroConta-tmp.txt";

		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		String linha;

		while ((linha = reader.readLine()) != null) {
			Conta contaAUX = descriptografar(linha);
			
			if(contaAUX.equals(conta)){
				writer.write(cryptoConta(conta) + "\n");
			}else{
				writer.write(cryptoConta(contaAUX) + "\n");
			}
		}

		writer.close();
		reader.close();

		new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\CaixaEletronico\\"+arquivo).delete();
		new File(arquivoTmp).renameTo(new File("C:\\Users\\Anderson\\OneDrive\\Faculdade\\3ª Ano\\Workspace\\CaixaEletronico\\" + arquivo));
		return true;
	}
}