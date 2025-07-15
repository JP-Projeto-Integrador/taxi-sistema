package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.VeiculoController;
import com.heranca.Validacao;
import com.heranca.Veiculo;

public class VeiculoView {

	private VeiculoController controller = new VeiculoController();
	Scanner sc = new Scanner(System.in);

	public void cadastrarVeiculo(int IdMotorista) {
		System.out.print("Placa: ");
		String placa = sc.nextLine();
		if (!Validacao.campoNaoVazio(placa) || !Validacao.validarPlaca(placa)) {
			System.out.println("Erro: placa inválida!");
			return;
		}

		System.out.print("Modelo: ");
		String modelo = sc.nextLine();
		if (!Validacao.campoNaoVazio(modelo)) {
			System.out.println("Erro: o modelo não pode ser vazio!");
			return;
		}

		System.out.print("Ano: ");
		int ano = 0;
		try {
			ano = Integer.parseInt(sc.nextLine());
			if (ano < 1886 || ano > 2100) {
				System.out.println("Erro: ano inválido!");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Erro: ano deve ser numérico!");
			return;
		}

		System.out.print("Cor: ");
		String cor = sc.nextLine();
		if (!Validacao.campoNaoVazio(cor)) {
			System.out.println("Erro: a cor não pode ser vazia!");
			return;
		}

		System.out.print("Marca: ");
		String marca = sc.nextLine();
		if (!Validacao.campoNaoVazio(marca)) {
			System.out.println("Erro: a marca não pode ser vazia!");
			return;
		}

		controller.salvarVeiculo(placa, modelo, ano, cor, marca, IdMotorista);
	}

	public void listarVeiculos(int IdMotorista) {
		try {
			controller.listarVeiculos(IdMotorista);
		} catch (Exception e) {
			System.out.println("Erro ao listar veículos: " + e.getMessage());
		}
	}

	public void listarTodosVeiculos() {
		try {
			List<Veiculo> veiculos = controller.obterVeiculosSemIdMotorista();
			if (veiculos.isEmpty()) {
				System.out.println("Nenhum veículo cadastrado no banco de dados.");
			} else {
				System.out.println("Veículos cadastrados no banco de dados: ");
				for (Veiculo veiculo : veiculos) {
					System.out.println("---------------------------");
					veiculo.exibirDados();
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar veículos: " + e.getMessage());
		}
	}

	public void atualizarVeiculo() {
		System.out.println("\n--- Atualização de Veículo ---");

		System.out.print("ID do veículo a ser atualizado: ");
		int idVeiculo = 0;
		try {
			idVeiculo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("ID inválido!");
			return;
		}

		System.out.print("Placa do veículo: ");
		String placa = sc.nextLine();

		System.out.print("Novo modelo: ");
		String modelo = sc.nextLine();

		System.out.print("Novo ano: ");
		int ano = 0;
		try {
			ano = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Ano inválido!");
			return;
		}

		System.out.print("Nova cor: ");
		String cor = sc.nextLine();

		System.out.print("Nova marca: ");
		String marca = sc.nextLine();

		System.out.print("ID do Motorista: ");
		int idMotorista = 0;
		try {
			idMotorista = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("ID do motorista inválido!");
			return;
		}

		controller.atualizarVeiculo(idVeiculo, placa, modelo, ano, cor, marca, idMotorista);

	}

	public void excluirVeiculo() {
		System.out.println("\n***** Exclusão de Veículo *****");

		System.out.print("ID do veículo a ser excluído: ");
		int IdVeiculo = sc.nextInt();

		controller.excluirVeiculo(IdVeiculo);
	}
}