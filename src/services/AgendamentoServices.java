package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import connector.ConexaoComBanco;
import model.Agendamento_Destinos;
import model.Cadastro_Mensagem_Contato;

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
		System.out.println("[1]Cartão [2]Boleto [3]Depósito [4]PIX");
		int pag = Integer.parseInt(sc.nextLine());
		if (pag == 1) {
			agendamento.setFormaPagamento("Cartão");
		}else if (pag == 2){
			agendamento.setFormaPagamento("Boleto");
		}else if (pag == 3){
			agendamento.setFormaPagamento("Depósito");
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
	
	public void read() {
		
		Connection conn = null;
		try {
			conn = ConexaoComBanco.createConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Agendamento_Destinos");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id_Agendamento") + " - " + rs.getString("nome") + " - "  + rs.getString("destino") + " - " + rs.getString("telefone") + " - " + rs.getString("formaPagamento"));
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void update() {
		
		Scanner sc = new Scanner(System.in);
		
		Agendamento_Destinos agendamento = new Agendamento_Destinos();
		
		System.out.println("Digite o ID que deseja atualizar: ");
		agendamento.setId_Agendamento(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Digite o seu nome: ");
		agendamento.setNome(sc.nextLine());
		
		System.out.println("Digite o seu destino: ");
		agendamento.setDestino(sc.nextLine());
		
		System.out.println("Digite o seu telefone: ");
		agendamento.setTelefone(sc.nextLine());
		
		System.out.println("Qual a sua forma de pagamento:");
		System.out.println("[1]Cartão [2]Boleto [3]Depósito [4]PIX");
		int pag = Integer.parseInt(sc.nextLine());
		if (pag == 1) {
			agendamento.setFormaPagamento("Cartão");
		}else if (pag == 2){
			agendamento.setFormaPagamento("Boleto");
		}else if (pag == 3){
			agendamento.setFormaPagamento("Depósito");
		}else{
			agendamento.setFormaPagamento("PIX");
		}
		
		String sql ="UPDATE Agendamento_Destinos set nome = ?, destino = ?, telefone = ?, formaPagamento = ? where Id_Agendamento = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, agendamento.getNome());
			pstm.setString(2, agendamento.getDestino());
			pstm.setString(3, agendamento.getTelefone());
			pstm.setString(4, agendamento.getFormaPagamento());
			pstm.setInt(5, agendamento.getId_Agendamento());
			
			pstm.execute();
			
			System.out.println("Agendamento Atualizado com Sucesso!");
			
			conn.close();
			pstm.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
