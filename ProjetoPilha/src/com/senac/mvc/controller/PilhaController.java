package com.senac.mvc.controller;

import java.util.Scanner;

import com.senac.mvc.model.Pilha;
import com.senac.mvc.view.ExtendView;

public class PilhaController {
	
	private ExtendView view = new ExtendView();
	private Scanner scan = new Scanner(System.in);
	
	private Pilha p;	

	
/*	// transforma uma expressao infixa para a forma posfixa
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
	
	}*/
	
	
	public String[] receberInfixa(){
		String[] array = new String[20];
		int a=0;
		int TamArray2=0;
		for(int i=0;i<20;i++){
			System.out.println("digite 1 para adicinar algo na expressao");
			a=scan.nextInt();
			if(a==1){
		//int i=0;
		
		System.out.println("insira algo na expressao...");
		String str="";
		str=scan.nextLine();
		array[i]=str;
		//i++;
			}else{
				break;
			}
		}
		
		for(int ii=0;ii<array.length;ii++){
			if(array[ii]!=null){
				TamArray2++;
			}else{
				break;
			}
		}
		String[] array2 = new String[TamArray2];
		
		for(int aa=0;aa<=TamArray2;aa++){
			array2[aa]=array[aa];
		}
		
		return array2;
	}
	
	
	
	
	// transforma uma expressao infixa para a forma posfixa
	public String[] infixaparaposfixa(Pilha p,String[] expre){
		
		
		String[] exp = expre;		
		//String posfix = "";
		boolean isover=false;
		String[] posfix = new String[20];
		
		int indicePosfix=0;
		
		
		//percorre a expressao
		for(int i =0 ; i < exp.length;i++){
			
			if(ehNumero(exp[i])){
				posfix[indicePosfix]+=exp[i];		
				
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
							posfix[indicePosfix]+=p.pop().toString();
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
									posfix[indicePosfix]+=p.pop();
								}
							}
							
						}else{					
						
						p.push(exp[i]);
						
						
						
						}
					}else if(prioridade(p.top().toString().toCharArray())==prioridade(exp[i])){
						
						if(p.size()==1){
							posfix[indicePosfix]+=p.pop();
							p.push(exp[i]);							
						}else if(p.size()>1){
							posfix[indicePosfix]+=p.pop().toString();
							
							
						}						
						if(iii== (expre.length-1)){
							while(!p.isEmpty()){
								posfix[indicePosfix]+=p.pop();
							}
						}
						
					}else if(isParenFecha(exp[i])){
						int aa=p.size();
						
						for(int a=0;a<aa;a++){
					
							if(!p.top().toString().equals("(")){
							char aux[]=p.pop().toString().toCharArray();
							posfix[indicePosfix]+=aux[0];
							
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
			posfix[indicePosfix]+=p.pop();
		}
		
		return posfix;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//calcula expressao posfixa
	public Pilha postfixCalculator(Pilha p,String[] exp){
	//	char[] exp=pos.toCharArray();
		
		for(int i=0;i<exp.length;i++){
			System.err.println("\n\n"+i);
			
			System.out.println("\n\n\nexp= "+exp[i]);
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
	
	
	
	
	
	
		
	
	
	
/*	public void metodoAux(Pilha p, String posfix, char[] exp, int i){
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
	}*/
	
	
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
	
	public boolean ehNumero(Object c){
		try{
			String a ="";
		/*String*/ 
			System.out.println("objeto ="+c.toString());
			a=c.toString();
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
