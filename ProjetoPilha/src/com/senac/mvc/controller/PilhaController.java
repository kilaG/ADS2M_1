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
			System.err.println("\ntam da bagaca"+p.size());
			System.err.println(exp[i]);
			
			
			if(ehNumero(exp[i])){
				posfix+=exp[i];		
				
			}else if(isOperator(exp[i])){
				
				if(p.isEmpty()){
					p.push(exp[i]);
					
				}else{
					int ii=p.size();
					for(int iii=0;iii<ii;iii++){
						System.out.println("tam pilha: "+ii);
						System.out.println("iterecao da pilha"+iii);
						
					if(prioridade(p.top().toString().toCharArray())>prioridade(exp[i])){
						
						if(p.top().toString().equals("(")){
							p.push(exp[i]);							
						}else{
						
						System.out.println("caiu no if 1, p.top="+p.top().toString());
						System.out.println("caiu no if 1, exp="+exp[i]);
						posfix+=p.pop().toString();
						p.push(exp[i]);
						}
						
					}else if(prioridade(p.top().toString().toCharArray())<prioridade(exp[i])){
						System.out.println("caiu no if 2, exp="+exp[i]);
						System.out.println("caiu no if 2, p.top="+p.top().toString());
						
						p.push(exp[i]);
						
					}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
						
						
						
						System.out.println("caiu no if 3, exp="+exp[i]);
						System.out.println("caiu no if 3, p.top="+p.top().toString());
						posfix+=p.pop().toString();
						
						int d=p.size();
						
						if(d==0){
							p.push(exp[i]);
						}else{
							
						}
						while(d>0){
							
							
							if(prioridade(p.top().toString().toCharArray())<prioridade(exp[i])){
								p.push(exp[i]);
							}else if(prioridade(p.top().toString().toCharArray())>prioridade(exp[i])){
								if(p.top().toString().equals("(")){
									p.push(exp[i]);							
								}else{
								
								System.out.println("caiu no if 1, p.top="+p.top().toString());
								System.out.println("caiu no if 1, exp="+exp[i]);
								posfix+=p.pop().toString();
								p.push(exp[i]);
								}
							}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
								posfix+=p.pop();
							}
							
							d--;
						}
						
						
					
						
			
					}
					
					
					
					
					
												}
					
					
				}
				
			}else if(isParenFecha(exp[i])){
				System.out.println("��");
				int aa=p.size();
				System.out.println("\n\ntam da pilhaaaa: "+aa);
				
				for(int a=0;a<aa;a++){
			//	
				//if(aux[0]!=')'){
					if(!p.top().toString().equals("(")){
						
						System.err.println("�--"+p.top().toString());
						char aux[]=p.pop().toString().toCharArray();
						//System.err.println(aux[0]);
					    posfix+=aux[0];
					
				}else{					
					p.pop();					
					
				}
				
				}
				
				
				
			}else if(ehAbre(exp[i])){
				p.push(exp[i]);				
				
				
						
			}
			
			
		}
		
		
	
				
		
	/*	int a=p.size();
		while(a!=0){
			System.err.println(p.top().toString());
			if(!p.top().toString().equals("(")||p.top().toString().equals(")")){
				System.out.println(p.top().toString());
			posfix+=p.pop().toString();
			}
			a--;
		}*/
		
		
		
		return posfix;
	
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
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='$'){
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
