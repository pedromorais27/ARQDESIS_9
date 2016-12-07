package br.com.usjt.model;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;
import br.com.usjt.DAO.DispenserDAO;
import br.com.usjt.TO.DispenserTO;

public class Dispenser{

	private int nota, quantidade;

	public Dispenser(int nota, int quantidade) {
		this.nota = nota;
		this.quantidade = quantidade;
	}

	public Dispenser() {
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

	public boolean contarNotas(double valorRetirar){
		boolean testeUnitario = true; //variavel criada para testes do junit
		
		try{	
			DispenserDAO dispenserDAO = new DispenserDAO();

			dispenserDAO.recuperarNotas();

			int notas50 = dispenserDAO.recuperarNotas().get(2).getQuantidade();
			int notas20 = dispenserDAO.recuperarNotas().get(1).getQuantidade();
			int notas10 = dispenserDAO.recuperarNotas().get(0).getQuantidade();

			if(notas10  == 0 || notas20 == 0 || notas50 == 0){
				JOptionPane.showMessageDialog(null, "As notas disponiveis estao acabando. Favor consulte o administrador "
						+ " do sistema para que ele resete o dispenser");
			}

			notas50 -= valorRetirar / 50;

			if (notas50 < 0) {
				notas50 =  dispenserDAO.recuperarNotas().get(2).getQuantidade();
				valorRetirar -= (notas50 * 50);
				notas50 = 0;
			} else {
				valorRetirar %= 50;
			}

			notas20 -= valorRetirar / 20;

			if (notas20 < 0) {
				notas20 = dispenserDAO.recuperarNotas().get(1).getQuantidade();
				valorRetirar -= (notas20 * 20);
				notas20 = 0;
			} else {
				valorRetirar %= 20;
			}

			notas10 -= valorRetirar / 10;

			if (notas10 < 0) {
				throw new Exception();
			} else {
				valorRetirar %= 10;
			}

			dispenserDAO.recuperarNotas().get(2).setQuantidade(notas50);
			dispenserDAO.recuperarNotas().get(1).setQuantidade(notas20);
			dispenserDAO.recuperarNotas().get(0).setQuantidade(notas10);

			dispenserDAO.retirarNota(dispenserDAO.recuperarNotas());

			JOptionPane.showMessageDialog(null, "Nao emitimos comprovante para essa operacao");
			
			testeUnitario = true;
		}catch(Exception e){
			
		}
		return testeUnitario;
	}

	public ArrayList<DispenserTO> consultarExtratoDeNotas(){

		DispenserDAO dispenserDAO = new DispenserDAO();

		return dispenserDAO.recuperarNotas();
	}
}