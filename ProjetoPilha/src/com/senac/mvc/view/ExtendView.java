package com.senac.mvc.view;

import com.senac.mvc.model.Pilha;

public class ExtendView {
	
	public void imprimeBinario(Pilha p){	
		System.out.println("EXERCICIO 2\n");
		while(!p.isEmpty()){
			System.out.println(p.pop());
		}
		System.out.println("----------");
	}
	
	public void imprimePalindromo(boolean b){
		System.out.println("EXERCICIO 1\n");
		if(b){
			System.out.println("è palindromo");
		}else{
			System.out.println("não é palindromo");
		}
		System.out.println("----------");
	}
	
	
	
}
