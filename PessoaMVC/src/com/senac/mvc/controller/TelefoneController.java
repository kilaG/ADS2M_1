package com.senac.mvc.controller;

import java.util.Random;

import com.senac.mvc.model.Pessoa;
import com.senac.mvc.model.Telefone;
import com.senac.mvc.view.ExtendView;

public class TelefoneController {
	
	private ExtendView view = new ExtendView();
	
	private Telefone t;
	
	private String[] tipo ={"Casa","Trabalho","Celular"};
	
	public Telefone gerarFone(){
		
		Random ger = new Random();
		
		String fone = ger.nextInt(99)+"-"+(ger.nextInt(99)*10)+"-"+(ger.nextInt(99)*10)+ger.nextInt(10);
		
		t = new Telefone();
		t.setFone(fone);
		t.setTipo(tipo[ger.nextInt(tipo.length-1)]);
		return t;
		
	}

	
	public void mostraTelefone(){
		view.imprimeTelefone(t.getTipo(),t.getFone());
	}
}
