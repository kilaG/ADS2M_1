
public class App {
	
	public static boolean verificaPalindromo(Pilha p){
		boolean status=false;
		int indice=0;
		char[] vetorDesempilhados=new char[p.ponteiro+2];
		
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
			}
			a--;			
		}		
		
		return status;
	}
	
	public static void conversaoBinaria(Pilha p, Pilha binario){
		int num=0;
		;
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
		
		while(!binario.isEmpty()){
			System.out.println(binario.pop());
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		
		/*Pilha p = new Pilha();
		p.push("r");
		p.push("o");
		p.push("d");
		p.push("a");
		p.push("d");
		p.push("o");
		p.push("r");
				
		if(App.verificaPalindromo(p)){
			System.out.println("eh palindromo");
		}else{
			System.out.println("NO!");
			}*/
	
		
		
		
		Pilha binario = new Pilha();
		Pilha p2 = new Pilha();
		p2.push(1);
		
		App.conversaoBinaria(p2,binario);
		
		
		
	}

}
