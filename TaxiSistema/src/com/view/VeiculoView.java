package com.view;

import java.util.Scanner;

import com.controller.VeiculoController;

public class VeiculoView {

	private VeiculoController controller = new VeiculoController();
	Scanner sc = new Scanner(System.in);

	public void cadastrarVeiculo() {

		System.out.println("Placa: ");
		String placa = sc.nextLine();

		System.out.println("Modelo: ");
		String modelo = sc.nextLine();

		System.out.println("Ano: ");
		int ano = sc.nextInt();
		sc.nextLine();

		System.out.println("Cor: ");
		String cor = sc.nextLine();

		System.out.println("Marca: ");
		String marca = sc.nextLine();

		controller.salvarVeiculo(placa, modelo, ano, cor, marca);
	}

	public void listarVeiculos() {
		try {
			controller.listarVeiculos();;
			;
		} catch (Exception e) {
			System.out.println("Erro ao listar veículos: " + e.getMessage());
		}
	}

	public void atualizarVeiculo() {
        System.out.println("\n--- Atualização de Veículo ---");

        System.out.print("Placa do veículo a ser atualizado: ");
        String placa = sc.nextLine();

        System.out.print("Novo modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Novo ano: ");
        int ano = sc.nextInt();
        sc.nextLine(); // Precisa para não pular a próxima entrada de info

        System.out.print("Nova cor: ");
        String cor = sc.nextLine();

        System.out.print("Nova marca: ");
        String marca = sc.nextLine();

        controller.atualizarVeiculo(placa, modelo, ano, cor, marca);
    }

    public void excluirVeiculo() {
        System.out.println("\n***** Exclusão de Veículo *****");

        System.out.print("Placa do veículo a ser excluído: ");
        String placa = sc.nextLine();

        controller.excluirVeiculo(placa);
    }
}