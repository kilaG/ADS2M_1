package com.senac.mvc.view;

public class ExtendView {
	
	public void imprimePessoa(String nome,String endereco){
		System.out.println("Nome: "+nome);
		System.out.println("Endereco: "+endereco);
		//System.out.println("Telefone: "+ telefone);
	}
	
	public void imprimeTelefone(String tipo, String telefone){
		System.out.println("Tipo: "+tipo+"\nTelefone: "+telefone);
	}
	

}
