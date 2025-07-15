package com.view;

import java.sql.Timestamp;
import java.util.Scanner;
import java.util.List;

import com.controller.ChamadoController;
import com.controller.ClienteController;
import com.controller.MotoristaController;
import com.controller.VeiculoController;
import com.heranca.Cliente;
import com.heranca.Motorista;
import com.heranca.TipoChamado;
import com.heranca.Veiculo;

public class ChamadoView {
	private ClienteController clienteController = new ClienteController();
	private MotoristaController motoristaController = new MotoristaController();
	private VeiculoController veiculoController = new VeiculoController();
	private ChamadoController controller = new ChamadoController();
	private Cliente cliente;
	private Motorista motorista;
	private Veiculo veiculo;
	private Scanner sc = new Scanner(System.in);	
	

	public void cadastrarChamado() {
        System.out.print("Origem: ");
        String origem = sc.nextLine();

        System.out.print("Destino: ");
        String destino = sc.nextLine();

        System.out.print("Tipo de chamado (BASIC, COMFORT, PRIORITY): ");
        String tipoChamado = sc.nextLine();
        TipoChamado tipoChamadoN = null;

        try {
            tipoChamadoN = TipoChamado.valueOf(tipoChamado.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de chamado inválido. Usando BASIC como padrão.");
            tipoChamadoN = TipoChamado.BASIC;
        }
        

        double kmInicial = 0.0;

        System.out.print("Km Final: ");
        double kmFinal = sc.nextDouble();
        
        Timestamp horaInicial = new Timestamp(System.currentTimeMillis());
    	Timestamp horaFinal = null;
    	double valorTotal = 0;
    	
    	// ATENÇÃO: cliente, motorista e veiculo devem estar inicializados antes
        if (cliente == null || motorista == null || veiculo == null) {
            System.out.println("Cliente, motorista ou veículo não estão definidos. Não é possível cadastrar chamado.");
            return;
        }

        // método p chamar ValorTotal

        controller.salvarChamado(origem, destino, tipoChamadoN, kmInicial, kmFinal, horaInicial, horaFinal, valorTotal, cliente, motorista, veiculo );
    }

	public void listarChamados() {
        try {
            controller.listarChamado();
        } catch (Exception e) {
        	System.out.println("Erro ao listar chamados: " + e.getMessage());
            } 
    }

	public void encerrarChamado() {
        System.out.print("Digite o ID do chamado a encerrar: ");
        int chamadoId = sc.nextInt();

        controller.encerrarChamado(chamadoId);;
    }
	
	private Cliente selecionarCliente() {
	    System.out.println("Selecione um cliente:");
	    List<Cliente> clientes = clienteController.obterClientes(); // Deve retornar List<Cliente>
	    for (Cliente c : clientes) {
	        System.out.println("CPF: " + c.getCpf() + " - Nome: " + c.getNome());
	    }
	    System.out.print("Digite o CPF do cliente: ");
	    String cpf = sc.nextLine();

	    for (Cliente c : clientes) {
	        if (c.getCpf().equals(cpf)) {
	            return c;
	        }
	    }

	    System.out.println("Cliente não encontrado.");
	    return null;
	}

	private Motorista selecionarMotorista() {
	    System.out.println("Selecione um motorista:");
	    List<Motorista> motoristas = motoristaController.obterMotoristas(); // Use obterMotoristas()
	    for (Motorista m : motoristas) {
	        System.out.println("CNH: " + m.getCnh() + " - Nome: " + m.getNome());
	    }
	    System.out.print("Digite o CNH do motorista: ");
	    String cnh = sc.nextLine();

	    for (Motorista m : motoristas) {
	        if (m.getCnh().equals(cnh)) {
	            return m;
	        }
	    }

	    System.out.println("Motorista não encontrado.");
	    return null;
	}


	private Veiculo selecionarVeiculo() {
	    System.out.println("Selecione um veículo:");
	    List<Veiculo> veiculos = veiculoController.obterVeiculos(); // Deve retornar List<Veiculo>
	    for (Veiculo v : veiculos) {
	        System.out.println("Placa: " + v.getPlaca() + " - Modelo: " + v.getModelo());
	    }
	    System.out.print("Digite a placa do veículo: ");
	    String placa = sc.nextLine();

	    for (Veiculo v : veiculos) {
	        if (v.getPlaca().equalsIgnoreCase(placa)) {
	            return v;
	        }
	    }

	    System.out.println("Veículo não encontrado.");
	    return null;
	}


}