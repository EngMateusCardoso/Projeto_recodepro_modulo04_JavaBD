package model;

public class Agendamento_Destinos {

	private Integer Id_Agendamento;
	private String nome;
	private String destino;
	private String telefone;
	private String formaPagamento;
	
	public Agendamento_Destinos() {
		
	}
	
	public Agendamento_Destinos(String nome, String destino, String telefone, String formaPagamento) {
		this.nome = nome;
		this.nome = destino;
		this.telefone = telefone;
		this.formaPagamento = formaPagamento;
	}

	public Integer getId_Agendamento() {
		return Id_Agendamento;
	}

	public void setId_Agendamento(Integer id_Agendamento) {
		Id_Agendamento = id_Agendamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
}
