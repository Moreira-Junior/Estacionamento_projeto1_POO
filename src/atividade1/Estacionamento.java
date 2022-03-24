package atividade1;

import java.util.ArrayList;

public class Estacionamento {
	private String [] placas;
	
	public Estacionamento(int numeroDeVagas) {
		placas = new String [numeroDeVagas];
		for (int i = 0; i < numeroDeVagas; i++) {
			placas [i] = "Livre";
		}
	}
	
	public void entrar (String placa, int vaga) {
		placas[vaga-1] = placa;
	}
	
	public void sair (int vaga) {
		placas [vaga-1] = "Livre";
	}
	
	public int consultarPlaca (String placa) {
		int tamanhoArray = placas.length;
		int vaga;
		for (int i = 0; i < tamanhoArray; i++) {
			if(placas [i] == placa) {
				vaga = i + 1;
				return vaga;
			}
		}
		return -1;
	}
	
	public String consultarVaga (int vaga) {
		return placas [vaga -1];
	}
	
	public void transferir (int vaga1, int vaga2) {
		String temp = placas [vaga2 - 1];
		placas [vaga2 - 1] = placas [vaga1 - 1];
		placas [vaga1 -1 ] = temp;
	}
	
	public String [] consultarGeral () {
		int tamanhoArray = placas.length;
		String [] temp = new String [tamanhoArray];
		for(int i = 0; i < tamanhoArray; i++) {
			if (placas [i] == "Livre") {
				temp [i] = "Livre";
			}
			else {
				temp[i] = "Ocupada";
			}
		}
		return temp;
	}
	
	public ArrayList<Integer> consultarLivre () {
		ArrayList<Integer> vagasLivres = new ArrayList<>();
		String [] temp = this.consultarGeral();
		int tamanhoArray = placas.length;
		for(int i = 0; i < tamanhoArray; i++) {
			if(temp[i] == "Livre") {
				vagasLivres.add(i+1);
			}
		}
		return vagasLivres;
	}
	
	public void lerDados () {
		
	}
	
	public void gravarDados () {
		
	}
}	

