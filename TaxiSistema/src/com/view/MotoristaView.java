package com.view;

import java.util.Scanner;
import com.controller.MotoristaController;
import com.heranca.Validacao;

public class MotoristaView {

    private MotoristaController controller = new MotoristaController();

    public void cadastrarMotorista(Scanner sc) {
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
            System.out.println("Erro: telefone inválido!");
            return;
        }

        System.out.print("CNH: ");
        String cnh = sc.nextLine();
        if (!Validacao.campoNaoVazio(cnh) || !Validacao.validarCNH(cnh)) {
            System.out.println("Erro: CNH inválida!");
            return;
        }

        controller.salvarMotorista(nome, endereco, telefone, cnh);
        System.out.println("Motorista cadastrado com sucesso!");
    }

    public void listarMotoristas() {
        try {
            controller.listarMotoristas();
        } catch (Exception e) {
            System.out.println("Erro ao listar motoristas: " + e.getMessage());
        }
    }

    public void atualizarMotorista(Scanner sc) {
        System.out.println("\n***** Atualização de Motorista *****");
        System.out.print("CNH do motorista a ser atualizado: ");
        String cnh = sc.nextLine();

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Novo endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = sc.nextLine();

        controller.atualizarMotorista(nome, endereco, telefone, cnh);
    }

    public void excluirMotorista(Scanner sc) {
        System.out.println("\n***** Exclusão de Motorista *****");
        System.out.print("CNH do motorista a ser excluído: ");
        String cnh = sc.nextLine();

        controller.excluirMotorista(cnh);
    }
}
