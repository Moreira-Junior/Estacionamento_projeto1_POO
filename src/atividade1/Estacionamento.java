package atividade1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

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
		String data = LocalDateTime.now().toString();
		String temp = "entrada;"+placa+";"+Integer.toString(vaga)+";"+data+"\n";
		
		try {
			File arquivo = new File("src/atividade1/historico.csv");
			FileWriter saida = new FileWriter(arquivo, true);			
			saida.write(temp);
			saida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sair (int vaga) {
		String data = LocalDateTime.now().toString();
		String temp = "saida;"+placas[vaga-1]+";"+Integer.toString(vaga)+";"+data+"\n";
		placas [vaga-1] = "Livre";
		try {
			File arquivo = new File("src/atividade1/historico.csv");
			FileWriter saida = new FileWriter(arquivo, true);			
			saida.write(temp);
			saida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			Scanner arquivo = new Scanner(new File("src/atividade1/placas.csv"));
			String cabecalho = arquivo.nextLine();
			String [] vagasOcupadas;
			String entrada;
			String [] partes;
			while(arquivo.hasNextLine()) {
				entrada = arquivo.nextLine();
				partes = entrada.split(";");
				System.out.println(partes[0]+" - "+partes[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gravarDados () {
		String temp = "vaga;placa\n";
		for (String placa : placas) {
			
			int vaga = this.consultarPlaca(placa);
			
			if(vaga != -1 && placa != "Livre") {
				temp += Integer.toString(vaga)+";"+placa+"\n";
			}
		}
		try {
			File arquivo = new File("src/atividade1/placas.csv");
			FileWriter saida = new FileWriter(arquivo, false);			
			saida.write(temp);
			saida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	

