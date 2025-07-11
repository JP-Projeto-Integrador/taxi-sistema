package com.heranca;
 
import java.util.Scanner;
 
import com.view.ChamadoView;
import com.view.ClienteView;
import com.view.MotoristaView;
import com.view.VeiculoView;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteView clienteView = new ClienteView();
        MotoristaView motoristaView = new MotoristaView();
        VeiculoView veiculoView = new VeiculoView();
        ChamadoView chamadoView = new ChamadoView();
 
        int opcao;
 
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cliente");
            System.out.println("2 - Motorista");
            System.out.println("3 - Veículo");
            System.out.println("4 - Chamado");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
 
            switch (opcao) {
                case 1:
                    menuCliente(clienteView, scanner);
                    break;
                case 2:
                    menuMotorista(motoristaView, scanner);
                    break;
                case 3:
                    menuVeiculo(veiculoView, scanner);
                    break;
                case 4:
                    menuChamado(chamadoView, scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
 
        scanner.close();
    }
 
    private static void menuCliente(ClienteView view, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
 
            switch (opcao) {
                case 1:
                    view.cadastrarCliente();
                    break;
                case 2:
                    view.listarClientes();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
 
    private static void menuMotorista(MotoristaView view, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Motorista ---");
            System.out.println("1 - Cadastrar motorista");
            System.out.println("2 - Listar motoristas");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
 
            switch (opcao) {
                case 1:
                    view.cadastrarMotorista();
                    break;
                case 2:
                    view.listarMotoristas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
 
    private static void menuVeiculo(VeiculoView view, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Veículo ---");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
 
            switch (opcao) {
                case 1:
                    view.cadastrarVeiculo();
                    break;
                case 2:
                    view.listarVeiculos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
 
    private static void menuChamado(ChamadoView view, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Chamado ---");
            System.out.println("1 - Cadastrar chamado");
            System.out.println("2 - Listar chamados");
            System.out.println("3 - Encerrar chamado");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
 
            switch (opcao) {
                case 1:
                    view.cadastrarChamado();
                    break;
                case 2:
                    view.listarChamados();
                    break;
                case 3:
                    view.encerrarChamado();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}