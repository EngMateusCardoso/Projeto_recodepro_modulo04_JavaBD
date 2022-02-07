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
			System.out.println("2 - Cadastrar mensagem de contato");
			
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
					msg.save();
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
