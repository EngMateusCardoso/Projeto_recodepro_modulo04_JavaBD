package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connector.ConexaoComBanco;
import model.Agendamento_Destinos;

public class AgendamentoServices {
	
	public void save() {
		
		Scanner sc = new Scanner(System.in);
		
		Agendamento_Destinos agendamento = new Agendamento_Destinos();
		
		System.out.println("Digite o seu nome: ");
		agendamento.setNome(sc.nextLine());
		
		System.out.println("Digite o seu destino: ");
		agendamento.setDestino(sc.nextLine());
		
		System.out.println("Digite o seu telefone: ");
		agendamento.setTelefone(sc.nextLine());
		
		System.out.println("Qual a sua forma de pagamento:");
		System.out.println("[1]Cart�o [2]Boleto [3]Dep�sito [4]PIX");
		int pag = Integer.parseInt(sc.nextLine());
		if (pag == 1) {
			agendamento.setFormaPagamento("Cart�o");
		}else if (pag == 2){
			agendamento.setFormaPagamento("Boleto");
		}else if (pag == 3){
			agendamento.setFormaPagamento("Dep�sito");
		}else{
			agendamento.setFormaPagamento("PIX");
		}
		
		
		String sql = "INSERT INTO Agendamento_Destinos(nome, destino, telefone, formaPagamento)VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, agendamento.getNome());
			pstm.setString(2, agendamento.getDestino());
			pstm.setString(3, agendamento.getTelefone());
			pstm.setString(4, agendamento.getFormaPagamento());
			
			pstm.execute();
			
			System.out.println("Agendamento executado com Sucesso!");
			
			conn.close();
			pstm.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
