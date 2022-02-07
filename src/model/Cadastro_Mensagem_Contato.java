package model;

public class Cadastro_Mensagem_Contato {

	private Integer id_Msg;
	private String email;
	private String msg;
	private Boolean aceitaReceberNot;
	
	public Cadastro_Mensagem_Contato() {
		
	}
	
	public Cadastro_Mensagem_Contato(String email, String msg, Boolean aceitaReceberNot) {
		this.email = email;
		this.msg = msg;
		this.aceitaReceberNot = aceitaReceberNot;
	}
	
	public Integer getId_Msg() {
		return id_Msg;
	}
	
	public void setId_Msg(Integer id_Msg) {
		this.id_Msg = id_Msg;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Boolean getAceitaReceberNot() {
		return aceitaReceberNot;
	}
	
	public void setAceitaReceberNot(Boolean aceitaReceberNot) {
		this.aceitaReceberNot = aceitaReceberNot;
	}
	
}
