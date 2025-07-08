package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MotoristaController;
import com.heranca.Cliente;
import com.heranca.Motorista;

public class MorotistaView {

	public class MotoristaView {

		private MotoristaController controller = new MotoristaController();
		Scanner sc = new Scanner(System.in);

		public void cadastrarMotorista(String tipo) {

			String cnh = "";

			if (tipo == "atualizar") {
				System.out.println("***** Atualizar Motorista *****");
				System.out.println("CNH do Motorista: ");
				cnh = sc.nextLine();
			}

			System.out.println("Nome: ");
			String nome = sc.nextLine();

			System.out.println("Telefone: ");
			String telefone = sc.nextLine();

			System.out.println("Endereço: ");
			String endereco = sc.nextLine();

			sc.close();

			controller.salvarMotorista(nome, telefone, endereco, cnh);

		}
		
		public void listarMotoristas() {
			List<Motorista> motoristas = controller.listarMotoristas();
			
			if (motoristas.isEmpty()) {
				System.out.println ("Nenhum motorista cadastrado!");
			} else {
				System.out.println("***** Lista de Motoristas *****");
				for (Motorista motorista : motoristas) {
				System.out.println("Nome: " + motorista.getNome());
				System.out.println("Telefone: " + motorista.getTelefone());
				System.out.println("Endereço: " + motorista.getEndereco());
				System.out.println("CNH: " + motorista.getCnh());
			}
		}

	}
}
