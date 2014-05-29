package com.senac.mvc.controller;

import java.util.Scanner;

import com.senac.mvc.model.Pilha;
import com.senac.mvc.view.ExtendView;

public class PilhaController {
	
	private ExtendView view = new ExtendView();
	private Scanner scan = new Scanner(System.in);
	private Pilha p;	

		
	
	// transforma uma expressao infixa para a forma posfixa
	public String[] infixaparaposfixa(Pilha p,String[] expre){
		
		String[] exp = expre;		
		String[] posfix = new String[20];
		
		int indicePosfix=0;
		
		
		//percorre a expressao
		for(int i =0 ; i < exp.length;i++){
			
			if(ehNumero(exp[i])){
				//System.out.println("EHNUMERO EXP I="+exp[i]);
				posfix[indicePosfix]=exp[i];	
				indicePosfix++;
				
			}else if(isOperator(exp[i])){
				
				if(p.isEmpty()){
					p.push(exp[i]);
					
				}else if(ehAbre(exp[i])){
					p.push(exp[i]);					
					
					
				}else{
					
					int ii=p.size();
					boolean vdd=false;
					//percorre a pilha enquanto existir elementos nela
					for(int iii=0;iii<ii;iii++){
					if(prioridade(p.top().toString().toCharArray())
							>prioridade(exp[i])){
						
						if(p.top().toString().equals("(")){							
							p.push(exp[i]);								
							break;
						}else{						
							posfix[indicePosfix]=p.pop().toString();
							indicePosfix++;
						p.push(exp[i]);
											
						}
						
					}else if(prioridade(p.top().toString().toCharArray())
							<prioridade(exp[i])){
						
						if(ehFecha(exp[i])){						
							
							while(!p.isEmpty()){
								if(p.top().toString().equals("(")){
									p.pop();
									break;
								}else{
									posfix[indicePosfix]+=p.pop();
									indicePosfix++;
								}
							}
							
						}else{					
						
						p.push(exp[i]);
						
						
						
						}
					}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
						
						if(p.size()==1){
							posfix[indicePosfix]=p.pop().toString();
							indicePosfix++;
							p.push(exp[i]);							
						}else if(p.size()>1){
							posfix[indicePosfix]=p.pop().toString();
							indicePosfix++;
							
							
						}						
						if(iii== (expre.length-1)){
							while(!p.isEmpty()){
								posfix[indicePosfix]=p.pop().toString();
								indicePosfix++;
							}
						}
						
					}else if(isParenFecha(exp[i])){
						int aa=p.size();
						
						for(int a=0;a<aa;a++){
					
							if(!p.top().toString().equals("(")){
							String aux=p.pop().toString();
							
							posfix[indicePosfix]=aux;
							indicePosfix++;
							
						}else{					
							p.pop();
							
							
						}
						
						}
						
						
						
					}
					
					
					
												}
					
					
					
				}
				
			}
			
		}
		
		while(!p.isEmpty()){
			posfix[indicePosfix]=p.pop().toString();
			indicePosfix++;
		}
		
		return posfix;
	
	}
	
	
	
	//calcula expressao posfixa
	public Pilha postfixCalculator(Pilha p,String[] exp1){
	
		String[] exp=exp1;
		
		for(int i=0;i<exp.length;i++){
			if(exp[i]==null){
				break;
			}else{
			//quando acha um numero empilha
			if(ehNumero(exp[i])){	
				
				p.push(exp[i]);
				//quando acha um operador desempilha dois numeros e faz o calculo depois empilha o resultado
			}else if (isOperator(exp[i])){
				String aux1=p.pop().toString();
				
				String aux2=p.pop().toString();
				
				p.push(calculadora(Integer.parseInt(aux1), Integer.parseInt(aux2), exp[i]));
			}
			
		}	
			
		}
		
		return  p;
		
		
	}
	
	public int calculadora(int a, int b, String exp){
		if(exp.equals("*")){
			return a*b;
		}else if(exp.equals("/")){
			return b/a;
		}else if(exp.equals("-")){
			return a-b;
		}else if(exp.equals("+")){
			return a+b;
		}else{
			return 0;
		}
	}
	
	
	
	
	public boolean isOperator(String exp){
		if(exp.equals("+")||exp.equals("-")||exp.equals("*")||exp.equals("/")||exp.equals("$")||exp.equals("(")||exp.equals(")")){
			return true;			
		}else{
			return false;
		}
	}
	
	public boolean isParenFecha(String exp){
		if(exp.equals(")")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean ehNumero(String c){
		try{
			String a ="";
			a=c;
		if(Integer.parseInt(a)>=0||Integer.parseInt(a)<=0){
			return true;
		}else{
			return false;
		}
	}catch(NumberFormatException n){
		
	}
		return false;
		
		
	}
	
	public boolean ehAbre(String exp){
		if(exp.equals("(")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean ehFecha(String exp){
		if(exp.equals(")")){
			return true;
		}else{
			return false;
		}
	}
	
	public int prioridade(String exp){
		if(exp.equals("+")||exp.equals("-")){
				return 1;		
		}else if(exp.equals("*")||exp.equals("/")){
			return 2;
		}else if(exp.equals("(")){
			return 4;
		}else{
			return 3;
		}
	}
	
	public int prioridade(char[] c){
		if(c[0]=='+'||(c[0]=='-')){
				return 1;		
		}else if(c[0]=='*'||c[0]=='/'){
			return 2;
		}else if(c[0]=='('){
			return 4;
		}else{
			return 3;
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
		
		
		return binario;
		
	}
	
	public void mostraBinario(Pilha p1, Pilha p2){
				
		view.imprimeBinario(conversaoBinaria(p1, p2));
		System.out.println("\n");
	}
	
	public void mostraPalindromo(boolean p){
		view.imprimePalindromo(p);		
		System.out.println("\n");
	}
	
	public void mostraExp(Pilha pp){
		view.imprimeExp(pp);
	}
	

}
