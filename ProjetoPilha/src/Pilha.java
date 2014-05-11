
public class Pilha {

	/*isEmpty verifica se a pilha esta vazia
	size retorna o tamnho da pilha
	pop desempilha
	push(valor) empilha
	top visualizar ultimo item empilhado*/
	
	int ponteiro;
	public Object[] vetor;
	
	public Pilha(){
		this.ponteiro=-1;
		this.vetor = new Object[30];
	}
	
	public boolean isEmpty(){
		if(this.ponteiro==-1){
			return true;
		}else{
			return false;
		}
	}
	
	public int size(){
		if(this.isEmpty()){
			return 0;
		}else{
			return this.ponteiro+1;
		}
	}
	
	public Object top(){
		if(this.isEmpty()){
			return null;
		}else{
			return vetor[ponteiro];
		}
	}
	
	public Object pop(){
		if(isEmpty()){
			return null;
		}else{
			return this.vetor[this.ponteiro--];
		}
	}
	
	public void push(Object valor){
		
		if(this.ponteiro<this.vetor.length-1){
			this.vetor[++ponteiro]=valor;
			/*if(ponteiro==-1){
				vetor=null;
			}*/
		}
	}
	
	
}
