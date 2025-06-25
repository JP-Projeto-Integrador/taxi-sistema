package com.controller;

import java.sql.SQLException;

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
}