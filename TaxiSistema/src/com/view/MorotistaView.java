package com.view;

import java.util.Scanner;

import com.controller.MotoristaController;

public class MorotistaView {

	public class VeiculoView {

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

	}
}
