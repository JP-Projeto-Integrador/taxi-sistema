package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.ConnectionFactory;
import com.heranca.Cliente;

public class ClienteDAO {
	public void inserir(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente (nome, endereco, telefone, cpf, rg) VALUES " + "(?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getRg());
			stmt.executeUpdate();
		}
	}

	public List<Cliente> selecionarTodos() throws SQLException {
	    List<Cliente> clientes = new ArrayList<>();
	    String sql = "SELECT IDCLIENTE, NOME, ENDERECO, TELEFONE, CPF, RG FROM CLIENTE";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Cliente cliente = new Cliente(
	                rs.getInt("IDCLIENTE"),     // pegar o id do banco
	                rs.getString("NOME"),
	                rs.getString("ENDERECO"),
	                rs.getString("TELEFONE"),
	                rs.getString("CPF"),
	                rs.getString("RG")
	            );
	            clientes.add(cliente);
	        }
	    }
	    return clientes;
	}

	public void atualizar(Cliente cliente) throws SQLException {
		String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ?, rg = ? WHERE cpf = ?";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getRg());
			stmt.setString(5, cliente.getCpf());
			stmt.executeUpdate();
		}
	}

	public void excluir(String cpf) throws SQLException {
		String sql = "DELETE FROM cliente WHERE cpf = ?";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			stmt.executeUpdate();
		}
	}
	
	public Cliente buscarPorId(int idCliente) throws SQLException {
	    String sql = "SELECT * FROM CLIENTE WHERE IDCLIENTE = ?";
	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, idCliente);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                // cria um cliente com id
	                Cliente cliente = new Cliente(
	                    rs.getInt("IDCLIENTE"),
	                    rs.getString("NOME"),
	                    rs.getString("ENDERECO"),
	                    rs.getString("TELEFONE"),
	                    rs.getString("CPF"),
	                    rs.getString("RG")
	                );
	                return cliente;
	            }
	        }
	    }
	    return null; // não encontrado
	}
}