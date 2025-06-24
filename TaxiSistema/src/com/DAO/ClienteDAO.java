package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conexao.ConnectionFactory;
import com.heranca.Cliente;

public class ClienteDAO {
	public void inserir(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente (nome, endereco, telefone, cpf, rg) VALUES " + "(?,?,?,?,?)";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getRg());
			stmt.executeUpdate();
		}
	}
}