package com.heranca;

import java.util.Scanner;

import com.view.ClienteView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteView view = new ClienteView();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n---MENU---");
			System.out.println(" 1. Adicionar Clente");
			System.out.println(" 4 Sair.");
			System.out.println("Ecolha uma opção:");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			  case 1:
				  try {
					  view.cadastrarCliente();
				  } catch (IllegalArgumentException e) {	
					  System.out.println(" Errp ao icluir usuario");
					  
				  }
				  
				  break;
				  
			  case 4:
				  System.out.println("Encerrado sistema...");
				  scanner.close();
				  return;
				  
			}
			
		
		}
		
		
	}

}
