package com.senac.mvc.controller;

import java.util.Random;

import com.senac.mvc.model.Pessoa;

public class PessoaController {
	
	Pessoa p;
	
	 String[] nomes ={"Rogerio",
			 "Ronaldo",
			 "Guilherme",
			 "Fabiane",
			 "Sabrina",
			 "Julia",
			 "Arnold",
			 "Neymar",
			 "Romario",
			 "Walter",
			 "Maria",
			 "Gustavo"};
	 
	 String[] sobrenomes ={"da Silva",
			 "Junior",
			 "Kila",
			 "Lima",
			 "Schwarzenegger",
			 "Sato",
			 "Robertz",
			 "Santos",
			 "de Jeseus",
			 "Nazario",
			 "da Rocha",
			 "Dias"};
	 
	 String[] enderecos ={"Rua Dona Eugenia",
			 "Rua de Copacabana",
			 "Rua Felipe de Oliveira",
			 "Rua Lima e Silva",
			 "Rua das pipas",
			 "Rua dos milagres",
			 "Rua Santo Efigenio",
			 "Rua do Futebol",
			 "Rua Antonio de Carvalho",
			 "Rua de Nazare",
			 "Rua Alcides Cruz",
			 "Rua da Redencao"};
	
	 void gerarDados(){
		 Random ger = new Random();
		 
		 String nome = nomes[(ger.nextInt(nomes.length-1))]+" "+sobrenomes[(ger.nextInt(sobrenomes.length-1))];
		 String endereco = enderecos[(ger.nextInt(enderecos.length-1))];
		 
		 p=new Pessoa();
		 p.setNome(nome);
		 p.setEndereco(endereco);
		 
	 }
}
