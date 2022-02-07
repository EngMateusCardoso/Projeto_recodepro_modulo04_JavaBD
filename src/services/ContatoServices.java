package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connector.ConexaoComBanco;
import model.Cadastro_Mensagem_Contato;

public class ContatoServices {
	
	public void save() {
		
		Scanner sc = new Scanner(System.in);
		
		Cadastro_Mensagem_Contato msg = new Cadastro_Mensagem_Contato();
		
		System.out.println("Digite o seu email: ");
		msg.setEmail(sc.nextLine());
		
		System.out.println("Digite a sua mensagem: ");
		msg.setMsg(sc.nextLine());
		
		System.out.println("Você aceita receber notificações por email?");
		System.out.println("[1]Sim [0]Não");
		int not = Integer.parseInt(sc.nextLine());
		if (not == 1) {
			msg.setAceitaReceberNot(true);
		}else {
			msg.setAceitaReceberNot(false);
		}
		
		
		String sql = "INSERT INTO Cadastro_Mensagem_Contato(email, msg, aceitaReceberNot)VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, msg.getEmail());
			pstm.setString(2, msg.getMsg());
			pstm.setBoolean(3, msg.getAceitaReceberNot());
			
			pstm.execute();
			
			System.out.println("Mensagem enviada com Sucesso!");
			
			conn.close();
			pstm.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}