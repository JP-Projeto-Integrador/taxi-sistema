package com.heranca;

import java.util.Scanner;

import com.view.ClienteView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteView view = new ClienteView();
		
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    try {
                    	view.cadastrarCliente();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao incluir usuario.");
                    }
                    break;      
                case 2:
                    try {
                    	view.ListaClientes();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao listar usuarios.");
                    }
                    break;  
                case 3:
                    try {
                    	view.excluirCliente();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao excluir usuario.");
                    }
                    break;  
                case 4:
                    try {
                    	view.cadastrarCliente("atualizar");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao atualizar usuario.");
                    }
                    break;  
                case 5:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }}}