package com.senac.mvc.view;

import com.senac.mvc.controller.PilhaController;
import com.senac.mvc.model.Pilha;

public class ExtendView {
	
	public void imprimeBinario(Pilha p){	
		System.out.println("Tarefa 2:\n----------\n");
		while(!p.isEmpty()){
			System.out.println(p.pop());
		}
		System.out.println("\n----------\n");
	}
	
	public void imprimePalindromo(boolean b){
		System.out.println("Tarefa 3:\n----------\n");
		if(b){
			System.out.println("è palindromo");
		}else{
			System.out.println("não é palindromo");
		}
		System.out.println("\n----------\n");
	}
	
	public void imprimeExp(Pilha p){
	
		System.out.println("Tarefa 4:\n----------\nresultado: "+p.pop().toString()+"\n----------\n");

	}
	
	
}
