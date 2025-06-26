package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.ConnectionFactory;
import com.heranca.Veiculo;

public class VeiculoDAO {
	public void inserir(Veiculo veiculo) throws SQLException {
		String sql = "INSERT INTO veiculo (placa, modelo, ano, cor, marca) VALUES " + "(?,?,?,?,?)";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, veiculo.getPlaca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getCor());
			stmt.setString(5, veiculo.getMarca());
			stmt.executeUpdate();
		}
	}
	
	public List<Veiculo> selecionarTodos() throws SQLException {
		List<Veiculo> veiculos = new ArrayList<>();
		String sql = "SELECT * FROM veiculo";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Veiculo veiculo = new Veiculo (
								rs.getString("placa"),
								rs.getString("modelo"),
								rs.getInt("ano"),
								rs.getString("cor"),
								rs.getString("marca"));
							veiculos.add(veiculo);
					}
				}
		return veiculos;
	}
}