package com.view;

import java.util.Scanner;

import com.controller.MotoristaController;


public class MorotistaView {

	public class MotoristaView {

		private MotoristaController controller = new MotoristaController();
		Scanner sc = new Scanner(System.in);

		public void cadastrarMotorista() {

			System.out.println("Nome: ");
			String nome = sc.nextLine();

			System.out.println("Telefone: ");
			String telefone = sc.nextLine();

			System.out.println("Endereço: ");
			String endereco = sc.nextLine();
			
			System.out.print("CNH: ");
		    String cnh = sc.nextLine();

			sc.close();

			controller.salvarMotorista(nome, telefone, endereco, cnh);

		}

		public void listarMotoristas() {
			try {
				controller.listarMotoristas();
				;
			} catch (Exception e) {
				System.out.println("Erro ao listar motoristas: " + e.getMessage());
			}
		}
		
		public void atualizarMotorista() {
	        System.out.println("\n***** Atualização de Motorista *****");
	        System.out.print("CNH do motorista a ser atualizado: ");
	        String cnh = sc.nextLine();

	        System.out.print("Novo nome: ");
	        String nome = sc.nextLine();

	        System.out.print("Novo telefone: ");
	        String telefone = sc.nextLine();

	        System.out.print("Novo endereço: ");
	        String endereco = sc.nextLine();

	        controller.atualizarMotorista(nome, telefone, endereco, cnh);
	    }
		
		public void excluirMotorista() {
	        System.out.println("\n***** Exclusão de Motorista *****");
	        System.out.print("CNH do motorista a ser excluído: ");
	        String cnh = sc.nextLine();

	        controller.excluirMotorista(cnh);
	    }
		
	}

}
