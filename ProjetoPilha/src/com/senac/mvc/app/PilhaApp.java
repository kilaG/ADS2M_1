package com.senac.mvc.app;



import com.senac.mvc.controller.PilhaController;
import com.senac.mvc.model.Pilha;



public class PilhaApp {

	/**
	 * 
	 * BY GUILHERME KILA
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilhaController pilha = new PilhaController();
		
		Pilha palindromo = new Pilha();
		palindromo.push("o");
		palindromo.push("v");
		palindromo.push("o");
				
		//pilha.verificaPalindromo(palindromo);
		pilha.mostraPalindromo(pilha.verificaPalindromo(palindromo));
		
		
		
		Pilha p1 = new Pilha();
		Pilha p2 = new Pilha();
		
		p1.push(50);
		pilha.conversaoBinaria(p1, p2);
		pilha.mostraBinario(p1,p2);
		
	
		String exp="2*2+(2*2)";
		Pilha p = new Pilha();			
		
		pilha.postfixCalculator(p, pilha.infixaparaposfixa(p, exp));
		pilha.mostraExp(p);
		

	}

}
