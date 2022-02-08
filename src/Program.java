import java.util.Scanner;

import services.AgendamentoServices;
import services.ContatoServices;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Boolean repetir = true;
		int opcao;
		do {
			
			System.out.println("Digite uma das opções: ");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar Destino");
			System.out.println("2 - Mostrar viagens cadastradas");
			System.out.println("3 - Atualizar Destino");
			System.out.println("4 - Apagar Agendamento de Destino");
			System.out.println("5 - Cadastrar mensagem de contato");
			System.out.println("6 - Mostrar mensagens de contato");
			System.out.println("7 - Atualizar mensagem de contato");
			System.out.println("8 - Deletar mensagem de contato");
			
			opcao = Integer.parseInt(sc.nextLine());
					
			ContatoServices msg = new ContatoServices();
			AgendamentoServices agendamento = new AgendamentoServices();
			
			switch(opcao) {
				case 0:
					repetir = false;
					break;
				case 1:
					agendamento.save();
					break;
				case 2:
					agendamento.read();
					break;
				case 3:
					agendamento.update();
					break;
				case 4:
					agendamento.delete();
					break;
				case 5:
					msg.save();
					break;
				case 6:
					msg.read();
					break;
				case 7:
					msg.update();
					break;
				case 8:
					msg.delete();
					break;
				default:
					System.out.println("opção invalida!");
					break;
			}
		} while (repetir);
		
		System.out.println("Finalizado!");
		
		sc.close();
	}

}
