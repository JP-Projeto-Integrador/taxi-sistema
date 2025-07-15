package com.view;

import java.util.Scanner;
import com.controller.MotoristaController;

public class MotoristaView {

    private MotoristaController controller = new MotoristaController();

    public void cadastrarMotorista(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("CNH: ");
        String cnh = sc.nextLine();

        controller.salvarMotorista(nome, endereco, telefone, cnh);
    }

    public void listarMotoristas(Scanner sc) {
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
