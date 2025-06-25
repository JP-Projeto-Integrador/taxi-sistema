package com.view;

import java.util.Scanner;

import com.controller.ClienteController;

public class ClienteView {
    private ClienteController controller = new ClienteController();

    public void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        
        System.out.print("RG: ");
        String rg = sc.nextLine();
        
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
      

        sc.close();
        controller.salvarCliente(nome, telefone, endereco, rg, cpf);
    }
}