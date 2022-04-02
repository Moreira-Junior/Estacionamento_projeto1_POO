package atividade1;
/**
 * TSI - POO - Prof fausto Ayres
 * Aplicação para testar a classe Estacionamento
 */
public class AplicacaoConsole2 {

	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento(10);	//10 vagas

		System.out.println("\n-------TESTE EXCEÇÕES LANÇADAS--------");
		try {
			estacionamento.entrar("AAA1111",1);
			estacionamento.entrar("XXX1111",1);
			System.out.println("*************1--->Nao lançou exceção para: entrar 1"); 
		}catch (Exception e) {System.out.println("exceção1--->"+e.getMessage());}

		try {
			estacionamento.sair(2);
			System.out.println("*************2--->Nao lançou exceção para: sair 2"); 
		}catch (Exception e) {System.out.println("exceção2--->"+e.getMessage());}

		try {
			estacionamento.consultarVaga(12);
			System.out.println("*************3--->Nao lançou exceção para: consultarVaga 12 "); 
		}catch (Exception e) {System.out.println("exceção3--->"+e.getMessage());}

		try {
			estacionamento.consultarPlaca("XXX0000");
			System.out.println("*************4--->Nao lançou exceção para: consultarPlaca XXX "); 
		}
		catch (Exception e) {System.out.println("exceção4--->"+e.getMessage());}

		try {
			estacionamento.transferir(1,1);
			System.out.println("*************5--->Nao lançou exceção para: transferir 1"); 
		}
		catch (Exception e) {System.out.println("exceção5--->"+e.getMessage());}

		try {
			estacionamento.transferir(2,1);
			System.out.println("*************6--->Nao lançou exceção para: transferir 2"); 
		}
		catch (Exception e) {System.out.println("exceção6--->"+e.getMessage());}

		try {
			estacionamento.transferir(3,2);
			System.out.println("*************7--->Nao lançou exceção para: transferir 3 "); 
		}
		catch (Exception e) {System.out.println("exceção7--->"+e.getMessage());}

		System.out.println("\n------------------------");
		System.out.println("consultar vagas geral");
		System.out.println("------------------------");
		for(String s : estacionamento.consultarGeral()) {
			System.out.println(s);
		}

	}

}