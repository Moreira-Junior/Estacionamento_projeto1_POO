package atividade1;

/**
 * TSI - POO - Prof fausto Ayres
 * Aplicação para testar a classe Estacionamento
 */
public class AplicacaoConsole1 {

	public static void main(String[] args) {
		int vaga;
		String placa;
		
		Estacionamento estacionamento = new Estacionamento(10);	//10 vagas
		
		System.out.println("consultar vagas geral");
		for(String s : estacionamento.consultarGeral()) {
			System.out.println(s);
		}
		System.out.println("consultar vagas livres");
		for(int i : estacionamento.consultarLivre()) {
			System.out.println(i);
		}
		estacionamento.entrar("AAA1111",1);
		estacionamento.entrar("AAA2222",2);
		estacionamento.entrar("AAA5555",5);
		estacionamento.entrar("AAA6666",6);
		estacionamento.sair(1);
		estacionamento.entrar("BBB1111",1);
		estacionamento.sair(2);
		estacionamento.entrar("BBB2222",2);
		estacionamento.sair(6);
		estacionamento.entrar("BBB6666",6);
		estacionamento.sair(1);
		estacionamento.transferir(5,10);

		placa = estacionamento.consultarVaga(5);
		System.out.println("placa da vaga 5 = "+placa);
		
		placa = estacionamento.consultarVaga(10);
		System.out.println("placa da vaga 10 = "+placa);
		
		vaga = estacionamento.consultarPlaca("AAA5555");
		System.out.println("vaga da placa AAA5555 = "+vaga);
		
		System.out.println("consultar vagas geral");
		for(String s : estacionamento.consultarGeral()) {
			System.out.println(s);
		}
		System.out.println("consultar vagas livres");
		for(int i : estacionamento.consultarLivre()) {
			System.out.println(i);
		}

	}

}