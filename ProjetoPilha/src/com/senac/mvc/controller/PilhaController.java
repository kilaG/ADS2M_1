package com.senac.mvc.controller;

import com.senac.mvc.model.Pilha;
import com.senac.mvc.view.ExtendView;

public class PilhaController {
	
	private ExtendView view = new ExtendView();
	
	
	private Pilha p;
	
	
	public static void calculaInfixa(Pilha p,Pilha p2){
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
					sadsa
				}
			}
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
