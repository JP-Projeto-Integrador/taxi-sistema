package com.view;

import java.util.Scanner;

import com.controller.VeiculoController;

public class VeiculoView {
	
	private VeiculoController controller = new VeiculoController();
	
	public void cadastrarVeiculo() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Placa: ");
		String placa = sc.nextLine();
		
		System.out.println("Modelo: ");
		String modelo = sc.nextLine();
		
		System.out.println("Ano: ");
		int ano = sc.nextInt();
		
		System.out.println("Cor: ");
		String cor = sc.nextLine();
		
		System.out.println("Marca: ");
		String marca = sc.nextLine();
		
		sc.close();
		
		controller.salvarVeiculo(placa, modelo, ano, cor, marca);
	}

}
