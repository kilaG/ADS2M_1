package com.senac.mvc.controller;

import com.senac.mvc.model.Pilha;
import com.senac.mvc.view.ExtendView;

public class PilhaController {
	
	private ExtendView view = new ExtendView();
	
	
	private Pilha p;	

	
	
	public String infixaparaposfixa(Pilha p,String expre){
		
		
		char[] exp = expre.toCharArray();		
		String posfix = "";
		
		for(int i =0 ; i < exp.length;i++){
			//System.out.println("iterecao do sistema:"+i);
			
			if(ehNumero(exp[i])){
				posfix+=exp[i];		
				
			}else if(isOperator(exp[i])){
				
				if(p.isEmpty()){
					p.push(exp[i]);
					
				}else{
					int ii=p.size();
					for(int iii=0;iii<ii;iii++){	
						System.out.println("iterecao da pilha"+iii);
						
					if(prioridade(p.top().toString().toCharArray())>prioridade(exp[i])){
						System.out.println("caiu no if 1, p.top="+p.top().toString());
						System.out.println("caiu no if 1, exp="+exp[i]);
						posfix+=p.pop().toString();
						p.push(exp[i]);
						
					}else if(prioridade(p.top().toString().toCharArray())<prioridade(exp[i])){
						System.out.println("caiu no if 2, exp="+exp[i]);
						System.out.println("caiu no if 2, p.top="+p.top().toString());
						
						p.push(exp[i]);
						
					}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
						posfix+=p.pop().toString();
						p.push(exp[i]);
					}
					
					
					
					
					
												}
					
					
				}
				
			}
			
			
		}
				
		
		while(!p.isEmpty()){
			System.err.println(p.top().toString());
			posfix+=p.pop().toString();
		}
		
		
		
		return posfix;
	
	}
		
	
	
	
	public boolean isOperator(char c){
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')'){
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
		}else{
			return 0;
		}
	}
	
	public int prioridade(char[] c){
		if(c[0]=='+'||(c[0]=='-')){
				return 1;		
		}else if(c[0]=='*'||c[0]=='/'){
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
