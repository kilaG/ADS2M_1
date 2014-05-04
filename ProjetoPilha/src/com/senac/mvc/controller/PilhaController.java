package com.senac.mvc.controller;

import com.senac.mvc.model.Pilha;
import com.senac.mvc.view.ExtendView;

public class PilhaController {
	
	private ExtendView view = new ExtendView();
	
	
	private Pilha p;
	
	
/*	public static void calculaInfixa(Pilha p,Pilha p2){
		String[] vetor = new String[20];
		int indice=0;
		
		while(!p.isEmpty()){			
			
			if(p.pop().equals("+")||p.pop().equals("-")||p.pop().equals("*")||p.pop().equals("/")){
				if(!p.pop().equals("+")||!p.pop().equals("-")){
					vetor[indice]=p.pop().toString();
					p2.push(vetor[indice]);
					indice++;
				}else if(!p.pop().equals("*")||!p.pop().equals("/")){
					vetor[indice]=p.pop().toString();
					p2.push(vetor[indice]);
					indice++;
				}
			}
			if(p.pop().equals("(")){
				p2.push(p.pop());
			}
			if(p.pop().equals(")")){
				while(!(p.pop().equals("+")||p.pop().equals("-")||p.pop().equals("*")||p.pop().equals("/"))){
					
				}
			}
		}
	}*/
	
	public void infix2posfix(Pilha p, String expresion){
		
		char[] exp= new char[expresion.length()-1];
		exp=expresion.toCharArray();				
		char[] postfix= new char[expresion.length()-1];
		
		int indiceposfix=0;
		for(int i=0;i<exp.length;i++){
			if(!isOperator(exp[i])){
				postfix[indiceposfix]=exp[i];
				indiceposfix++;
			}else if(isOperator(exp[i])){
				if(p.isEmpty()){
					p.push(exp[i]);	
				}else{
					char[] aux=p.top().toString().toCharArray();
					if(prioridade(aux[0])>=prioridade(exp[i])){
						postfix[indiceposfix]=aux[0];
						p.pop();
						p.push(exp[i]);
					}else{
						p.push(exp[i]);
						
					}
				}
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public boolean isOperator(char c){
		if(c=='+'||c=='-'||c=='*'||c=='/'){
			return true;			
		}else{
			return false;
		}
	}
	
	public int prioridade(char c){
		if(c=='+'||c=='-'){
				return 1;		
		}else if(c=='*'||c=='/'){
			return 2;
		}else{
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	public static boolean verificaPalindromo(Pilha p){
		boolean status=false;
		int indice=0;
		char[] vetorDesempilhados=new char[p.getPonteiro()+2];
		
		while(!p.isEmpty()){		
			vetorDesempilhados[indice]=p.pop().toString().toCharArray()[0];
			indice++;
		}
		
		int a=vetorDesempilhados.length-2;
		
		for(int i=0;i<vetorDesempilhados.length-1;i++){
			if(vetorDesempilhados[i]==vetorDesempilhados[a]){		;			
			status=true;
			}else{
				status=false;
				break;
			}
			a--;			
		}		
		
		return status;
	}
	
	
	public static Pilha conversaoBinaria(Pilha p, Pilha binario){
		int num=0;
		
		while(!p.isEmpty()){
			num=Integer.parseInt(p.pop().toString());
			while(num/2>0){				
				binario.push(num%2);			
				num=num/2;			
			}
			if(num!=0){
				binario.push(1);
			}else{
				binario.push(0);
			}
		}
		
		/*while(!binario.isEmpty()){
			System.out.println(binario.pop());
		}*/
		return binario;
		
	}
	
	public void mostraBinario(Pilha p1, Pilha p2){
		//view.imprimePalindromo(b);		
		view.imprimeBinario(conversaoBinaria(p1, p2));
		System.out.println("\n");
	}
	
	public void mostraPalindromo(boolean p){
		view.imprimePalindromo(p);		
		System.out.println("\n");
	}
	
		
	
	

}
