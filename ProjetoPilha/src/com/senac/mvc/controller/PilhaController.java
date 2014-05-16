package com.senac.mvc.controller;

import com.senac.mvc.model.Pilha;
import com.senac.mvc.view.ExtendView;

public class PilhaController {
	
	private ExtendView view = new ExtendView();
	
	
	private Pilha p;	

	
	// transforma uma expressao infixa para a forma posfixa
	public String infixaparaposfixa(Pilha p,String expre){
		
		
		char[] exp = expre.toCharArray();		
		String posfix = "";
		boolean isover=false;
		
		
		//percorre a expressao
		for(int i =0 ; i < exp.length;i++){
			
			if(ehNumero(exp[i])){
				posfix+=exp[i];		
				
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
						
						if(isover){
							break;
						}else{
							
						}						
					if(prioridade(p.top().toString().toCharArray())>prioridade(exp[i])){
						
						if(p.top().toString().equals("(")){							
							p.push(exp[i]);								
							break;
						}else{						
						posfix+=p.pop().toString();
						p.push(exp[i]);
											
						}
						
					}else if(prioridade(p.top().toString().toCharArray())<prioridade(exp[i])){
						
						if(ehFecha(exp[i])){						
							
							while(!p.isEmpty()){
								if(p.top().toString().equals("(")){
									p.pop();
									isover=true;
									break;
								}else{
									posfix+=p.pop();
								}
							}
							
						}else{					
						
						p.push(exp[i]);
						
						
						
						}
					}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
						
						if(p.size()==1){
							posfix+=p.pop();
							p.push(exp[i]);							
						}else if(p.size()>1){
							posfix+=p.pop().toString();
							
							
						}						
						if(iii== (expre.length()-1)){
							while(!p.isEmpty()){
								posfix+=p.pop();
							}
						}
						
					}else if(isParenFecha(exp[i])){
						int aa=p.size();
						
						for(int a=0;a<aa;a++){
					
							if(!p.top().toString().equals("(")){
							char aux[]=p.pop().toString().toCharArray();
							posfix+=aux[0];
							
						}else{					
							p.pop();
							
							
						}
						
						}
						
						
						
					}
					
					
					
												}
					
					
					
				}
				
			}
			
			if(isover){
				break;
			}
			
			
		}
		
		while(!p.isEmpty()){
			posfix+=p.pop();
		}
		
		return posfix;
	
	}
	
	
	
	//calcula expressao posfixa
	public Pilha postfixCalculator(Pilha p,String pos){
		char[] exp=pos.toCharArray();
		
		for(int i=0;i<exp.length;i++){
			
			
			if(ehNumero(exp[i])){	
				
				p.push(exp[i]);
				
			}else if (isOperator(exp[i])){
				String aux1=p.pop().toString();
				
				String aux2=p.pop().toString();
				
				p.push(calculadora(Integer.parseInt(aux1), Integer.parseInt(aux2), exp[i]));
			}
			
			
			
		}
		
		return  p;
		
		
	}
	
	public int calculadora(int a, int b, char c){
		if(c=='*'){
			return a*b;
		}else if(c=='/'){
			return b/a;
		}else if(c=='-'){
			return a-b;
		}else if(c=='+'){
			return a+b;
		}else{
			return 0;
		}
	}
	
	
	
	
	
	
		
	
	
	
	public void metodoAux(Pilha p, String posfix, char[] exp, int i){
		if(!p.isEmpty()){
			int v=p.size();
			for(int x=0;x<v;x++){
				if(prioridade(p.top().toString().toCharArray())>prioridade(exp[i])){
					posfix+=p.top().toString();
				}else if(prioridade(p.top().toString().toCharArray())<prioridade(exp[i])){
					p.push(exp[i]);
				}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
					
				}
			}
		}
	}
	
	
	public boolean isOperator(char c){
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='$'||c=='('||c==')'){
			return true;			
		}else{
			return false;
		}
	}
	
	public boolean isParenFecha(char c){
		if(c==')'){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean ehNumero(Object c){
		try{
		String a=c.toString();
		if(Integer.parseInt(a)>=0||Integer.parseInt(a)<=0){
			return true;
		}else{
			return false;
		}
	}catch(NumberFormatException n){
		
	}
		return false;
		
		
	}
	
	public boolean ehAbre(char c){
		if(c=='('){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean ehFecha(char c){
		if(c==')'){
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
		}else if(c=='('){
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
