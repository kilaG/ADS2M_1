package com.senac.mvc.app;



import com.senac.mvc.controller.PilhaController;
import com.senac.mvc.model.Pilha;



public class PilhaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilhaController pilha = new PilhaController();
		
	/*	Pilha palindromo = new Pilha();
		palindromo.push("t");
		palindromo.push("t");
		palindromo.push("t");
		palindromo.push("t");
		palindromo.push("t");
		palindromo.push("t");
		palindromo.push("t");		
		//pilha.verificaPalindromo(palindromo);
		pilha.mostraPalindromo(pilha.verificaPalindromo(palindromo));
		
		
		
		Pilha p1 = new Pilha();
		Pilha p2 = new Pilha();
		
		p1.push(50);
		pilha.conversaoBinaria(p1, p2);
		pilha.mostraBinario(p1,p2);*/
		
		String exp="4*2*3-3+8/4/(1+1)";
		Pilha p = new Pilha();
		
		/*System.out.println(pilha.infix2posfix(p, exp));*/
		
		System.out.println(pilha.infixaparaposfixa(p, exp));
		
		
		

	}

}
