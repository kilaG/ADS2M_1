package com.senac.mvc.app;

import javax.swing.JOptionPane;

import com.senac.mvc.controller.PessoaController;
import com.senac.mvc.controller.TelefoneController;

public class PessoaApp {

	public static void main(String[] args) {
		
		
		PessoaController controller = new PessoaController();
		TelefoneController fonecontroller = new TelefoneController();
		
		for(int i=0;i<2;i++){
			System.out.println("----------------");
			
		controller.gerarDados(fonecontroller.gerarFone());
		fonecontroller.mostraTelefone();
		controller.mostraPessoa();
		System.out.println("\n");		
		}
		
	}

}