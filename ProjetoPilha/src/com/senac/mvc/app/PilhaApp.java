package com.senac.mvc.app;



import com.senac.mvc.controller.PilhaController;
import com.senac.mvc.model.Pilha;



public class PilhaApp {

	/**
	 * 
	 * BY GUILHERME KILA
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PilhaController pilha = new PilhaController();
		
		Pilha palindromo = new Pilha();
		palindromo.push("o");
		palindromo.push("v");
		palindromo.push("o");
				
		
		pilha.mostraPalindromo(pilha.verificaPalindromo(palindromo));		
		Pilha p1 = new Pilha();
		Pilha p2 = new Pilha();		
		p1.push(50);		
		pilha.mostraBinario(p1,p2);
		
	
		
		//String[] exp={"2","*","2","+","(","2","*","2",")"};
		String[] exp = new String[7];
		exp[0]="30";
		exp[1]="+";
		exp[2]="10";
		exp[3]="+";		
		exp[4]="5";
		exp[5]="*";
		exp[6]="5";
		
		
		Pilha p = new Pilha();
//		pilha.postfixCalculator(p, pilha.infixaparaposfixa(p, exp));
		
		/*int i=0;
		while(pilha.infixaparaposfixa(p, exp33)[i]!=null){
			System.err.println(pilha.infixaparaposfixa(p, exp33)[i]);
			i++;
		}*/
		
		pilha.mostraExp(pilha.postfixCalculator(p, pilha.infixaparaposfixa(p, exp)));
		

	}

}
