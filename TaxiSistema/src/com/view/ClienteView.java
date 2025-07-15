package com.view;

import java.util.Scanner;

import com.controller.ClienteController;
import com.heranca.Validacao;


public class ClienteView {
    private ClienteController controller = new ClienteController();
    private Scanner sc = new Scanner(System.in); 

    public void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        if (!Validacao.campoNaoVazio(nome)) {
            System.out.println("Erro: o nome não pode ser vazio!");
            return;
        }

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        if (!Validacao.campoNaoVazio(endereco)) {
            System.out.println("Erro: o endereço não pode ser vazio!");
            return;
        }

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        if (!Validacao.campoNaoVazio(telefone) || !Validacao.validarTelefone(telefone)) {
            System.out.println("Erro: telfone inválido");
            return;
        }

        System.out.print("RG: ");
        String rg = sc.nextLine();
        if (!Validacao.campoNaoVazio(rg) || !Validacao.validarRG(rg)) {
            System.out.println("Erro: RG inválido!");
            return;
        }

        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        if (!Validacao.campoNaoVazio(cpf) || !Validacao.validarCPF(cpf)) {
            System.out.println("Erro: CPF inválido!");
            return;
        }

        controller.salvarCliente(nome, endereco, telefone, cpf, rg);
        
    }


    public void listarClientes() {
        try {
            controller.listarClientes();
        } catch (Exception e) {
        	System.out.println("Erro ao listar clientes: " + e.getMessage());
            } 
    }

    public void atualizarCliente() {
        System.out.println("Digite os dados do cliente para atualizar:");
        System.out.print("CPF do cliente a atualizar: ");
        String cpf = sc.nextLine();

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Novo endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Novo RG: ");
        String rg = sc.nextLine();

        controller.atualizarCliente(nome, endereco, telefone, cpf, rg);
    }

    public void excluirCliente() {
        System.out.print("Digite o CPF do cliente a excluir: ");
        String cpf = sc.nextLine();

        controller.excluirCliente(cpf);
    }
}