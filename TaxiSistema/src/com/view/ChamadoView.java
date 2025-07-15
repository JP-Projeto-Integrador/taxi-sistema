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
		
		clienteController.listarClientes();
		
		System.out.print("Digite o ID do cliente: ");
		int idCliente = sc.nextInt();
		sc.nextLine();

		Cliente cliente = clienteController.buscarPorId(idCliente);
		if (cliente == null) {
		    System.out.println("Cliente não encontrado!");
		    return;
		}
		
		motoristaController.listarMotoristas();
		System.out.print("Digite o ID do motorista: ");
		int idMotorista = sc.nextInt();
		sc.nextLine();

		Motorista motorista = motoristaController.buscarPorId(idMotorista);
		if (motorista == null) {
		    System.out.println("Motorista não encontrado!");
		    return;
		}

	 // Primeiro listar todos os veículos
		List<Veiculo> veiculos = veiculoController.obterVeiculos(idMotorista);
		for (Veiculo v : veiculos) {
		    v.exibirDados();
		}

	    // Pedir para o usuário escolher pelo ID
	    System.out.print("Digite o ID do veículo: ");
	    int idVeiculo = sc.nextInt();
	    sc.nextLine();

	    // Buscar o veículo selecionado
	    Veiculo veiculo = veiculoController.buscarPorId(idVeiculo);
	    if (veiculo == null) {
	        System.out.println("Veículo não encontrado!");
	        return;
	    }
	    System.out.println("Veículo selecionado: " + veiculo.getPlaca() + " (" + veiculo.getModelo() + ")");

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
	    sc.nextLine(); // consumir quebra de linha

	    Timestamp horaInicial = new Timestamp(System.currentTimeMillis());
	    Timestamp horaFinal = null;
	    double valorTotal = 0;
	    
	    controller.salvarChamado(origem, destino, tipoChamadoN,
	        kmInicial, kmFinal, horaInicial, horaFinal,
	        valorTotal, cliente, motorista, veiculo
	    );
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


	private Veiculo selecionarVeiculo(int idMotorista) {
	    System.out.println("Selecione um veículo:");

	    // chama o controller passando o idMotorista que já deve estar definido
	    List<Veiculo> veiculos = veiculoController.obterVeiculos(idMotorista);

	    // lista todos os veículos encontrados
	    for (Veiculo v : veiculos) {
	        System.out.println("ID: " + v.getIdVeiculo() + " - Placa: " + v.getPlaca() + " - Modelo: " + v.getModelo());
	    }

	    System.out.print("Digite o ID do veículo: ");
	    int idEscolhido = sc.nextInt();
	    sc.nextLine(); // consumir a quebra de linha

	    // procura o veículo com o ID escolhido
	    for (Veiculo v : veiculos) {
	        if (v.getIdVeiculo() == idEscolhido) {
	            return v;
	        }
	    }

	    System.out.println("Veículo não encontrado!");
	    return null;
	}
}