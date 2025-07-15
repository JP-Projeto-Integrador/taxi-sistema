package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.ClienteDAO;
import com.heranca.Cliente;


public class ClienteController {
	private ClienteDAO clienteDAO = new ClienteDAO();

	public void salvarCliente(String nome, String endereco, String telefone, String cpf, String rg) {
		try {
			Cliente cliente = new Cliente(nome, endereco, telefone, cpf, rg);
			clienteDAO.inserir(cliente);
			System.out.println("Cliente salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao salvar cliente: " + e.getMessage());
		}
	}

	public void listarClientes() {
		try {
			List<Cliente> clientes = clienteDAO.selecionarTodos();
			System.out.println("Clientes cadastrados no banco de dados: ");
			for (Cliente cliente : clientes) {
				System.out.println("---------------------------");
				cliente.exibirDados();
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar clientes: " + e.getMessage());
		}
	}
	
	public List<Cliente> obterClientes() {
	    try {
	        return clienteDAO.selecionarTodos();
	    } catch (Exception e) {
	        System.out.println("Erro ao buscar clientes: " + e.getMessage());
	        return new ArrayList<Cliente>(); // ou null, se preferir
	    }
	}

	public void atualizarCliente(String nome, String endereco, String telefone, String cpf, String rg) {
	    try {
	        Cliente cliente = new Cliente(nome, endereco, telefone, cpf, rg);
	        cliente.setCpf(cpf);

	        clienteDAO.atualizar(cliente);
	        System.out.println("Cliente atualizado com sucesso!");
	    } catch (SQLException e) {
	        System.out.println("Erro ao atualizar cliente: " + e.getMessage());
	    }
	}

	public void excluirCliente(String cpf) {
	    try {
	        clienteDAO.excluir(cpf);     
	        System.out.println("Cliente deletado com sucesso!");
	    } catch (SQLException e) {
	        System.out.println("Erro ao deletar cliente: " + e.getMessage());
	    }
	}
}