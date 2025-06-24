package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conexao.ConnectionFactory;
import com.heranca.Motorista;

public class MotoristaDAO {
	public void inserir(Motorista motorista) throws SQLException {
		String sql = "INSERT INTO motorista (nome, endereco, telefone, cnh) VALUES " + "(?,?,?,?)";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getEndereco());
			stmt.setString(3, motorista.getTelefone());
			stmt.setString(4, motorista.getCnh());
			stmt.executeUpdate();
		}
	}
}