package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	public void read() {
		
		Connection conn = null;
		try {
			conn = ConexaoComBanco.createConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Cadastro_Mensagem_Contato");
			
			while (rs.next()) {
				System.out.println(rs.getInt("id_Msg") + " - " + rs.getString("email") + " - " + rs.getString("msg") + " - " + rs.getBoolean("aceitaReceberNot"));
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public void update() {
		
		Scanner sc = new Scanner(System.in);
		
		Cadastro_Mensagem_Contato msg = new Cadastro_Mensagem_Contato();
		
		System.out.println("Digite o ID que deseja atualizar: ");
		msg.setId_Msg(Integer.parseInt(sc.nextLine()));
		
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
		
		String sql ="UPDATE Cadastro_Mensagem_Contato set email = ?, msg = ?, aceitaReceberNot=? where id_Msg = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoComBanco.createConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, msg.getEmail());
			pstm.setString(2, msg.getMsg());
			pstm.setBoolean(3, msg.getAceitaReceberNot());
			pstm.setInt(4, msg.getId_Msg());
			
			pstm.execute();
			
			System.out.println("Mensagem Atualizada com Sucesso!");
			
			conn.close();
			pstm.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}