package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Motorista> selecionarTodos() throws SQLException {
		List<Motorista> motoristas = new ArrayList<Motorista>();
		String sql = "SELECT * FROM motorista";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Motorista motorista = new Motorista(rs.getNString("nome"), rs.getString("endereco"),
						rs.getString("telefone"), rs.getString("cnh"));
				motoristas.add(motorista);
			}
		}
		return motoristas;
	}

	public void atualizar(Motorista motorista) throws SQLException {
		String sql = "UPDATE motorista SET nome = ?, endereco = ?, telefone = ? WHERE cnh = ?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getEndereco());
			stmt.setString(3, motorista.getTelefone());
			stmt.setString(4, motorista.getCnh());
			stmt.executeUpdate();
		}
	}
	
	public void excluir(String cnh) throws SQLException {
		String sql = "DELETE FROM motorista WHERE cnh = ?";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cnh);
			stmt.executeUpdate();
		}
	}
}