package com.senac.mvc.model;

public class Pessoa {
	
	private String nome;
	private String telefone;
	private String endereco;
	private Telefone t;
	
	
	
	public Telefone getT() {
		return t;
	}
	public void setT(Telefone t) {
		this.t = t;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
