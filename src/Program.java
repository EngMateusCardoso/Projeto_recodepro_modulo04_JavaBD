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
			System.out.println("1 - Cadastrar Destino (Create)");
			System.out.println("2 - Mostrar viagens cadastradas (Read)");
			System.out.println("3 - Atualizar Destino (Update)");
			System.out.println("4 - Cadastrar mensagem de contato (Create)");
			System.out.println("5 - Mostrar mensagens de contato (Read)");
			System.out.println("6 - Atualizar mensagem de contato (Update)");
			
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
					msg.save();
					break;
				case 5:
					msg.read();
					break;
				case 6:
					msg.update();
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
