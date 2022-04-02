package atividade1;
/**
 * TSI - POO - Prof fausto Ayres
 * Aplicação para testar a classe Estacionamento
 */
import java.util.Date;
import java.util.Scanner;

public class AplicacaoConsole3 {
	public static void main(String[] args) {
		//inicialização do programa
		Estacionamento estacionamento = new Estacionamento(10);	//10 vagas
		estacionamento.lerDados();

		String placa;
		int vaga;
		int op=-1;
		Scanner teclado = new Scanner(System.in);
	
		do{
			try {
				System.out.println("\n---------------------------------------------------");
				System.out.println("VALETINHO DO IFPB  - " + new Date().toString()	);
				System.out.println("---------------------------------------------------");
				System.out.println("Menu:");
				System.out.println("0 - terminar programa");
				System.out.println("1 - entrar na vaga");
				System.out.println("2 - sair da vaga");
				System.out.println("3 - transferir de vaga");
				System.out.println("4 - Consultar geral");
				System.out.println("5 - Consultar livre");
				System.out.print("==>");
				op = Integer.parseInt(teclado.nextLine());

				switch(op) {
				case 0 : 
					System.out.println("Volte sempre!!!"); 
					break;
				case 1 : 
					System.out.print("Qual a placa para entrar? ");
					placa = teclado.nextLine();
					System.out.print("Qual a vaga para entrar? ");
					vaga = Integer.parseInt(teclado.nextLine());
					estacionamento.entrar(placa, vaga); 
					System.out.println("entrou");
					break;
				case 2 : 
					System.out.print("Qual a vaga para sair? ");
					vaga = Integer.parseInt(teclado.nextLine());
					estacionamento.sair(vaga); 
					System.out.println("saiu");
					break;
				case 3 : 
					System.out.print("Qual a vaga origem? ");
					vaga = Integer.parseInt(teclado.nextLine());
					System.out.print("Qual a vaga destino? ");
					int vagadestino = Integer.parseInt(teclado.nextLine());
					estacionamento.transferir(vaga, vagadestino); 
					System.out.println("transferiu");
					break;
				case 4 : 
					System.out.println("consultar vagas geral");
					for(String s : estacionamento.consultarGeral()) {
						System.out.println(s);
					}
					break;
				case 5 : 
					System.out.println("consultar vagas livres");
					for(int i : estacionamento.consultarLivre()) {
						System.out.println(i);
					}
					break;
				default: 
					System.out.println("Opção Invalida!");;
				}

			}//try
			catch(NumberFormatException e) {
				System.out.println("Formato numerico invalido");
			}
			catch(Exception e) {
				System.out.println("Exceção:"+e.getMessage());
			}

		}while(op != 0);

		//finalização do programa
		estacionamento.gravarDados();
		teclado.close();
	}
}