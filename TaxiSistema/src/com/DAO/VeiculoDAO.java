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
	    String sql = "INSERT INTO veiculo (placa, modelo, ano, cor, marca, idmotorista) VALUES (?,?,?,?,?,?)";

	    try (Connection conn = ConnectionFactory.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, veiculo.getPlaca());
	        stmt.setString(2, veiculo.getModelo());
	        stmt.setInt(3, veiculo.getAno());
	        stmt.setString(4, veiculo.getCor());
	        stmt.setString(5, veiculo.getMarca());
	        stmt.setInt(6, veiculo.getIdMotorista()); // aqui passa o id do motorista vinculado
	        stmt.executeUpdate();
	    }
	}

	public List<Veiculo> selecionarTodos(int IdMotorista) throws SQLException {
	    List<Veiculo> veiculos = new ArrayList<>();
	    String sql = "SELECT IDVEICULO, PLACA, MODELO, ANO, COR, MARCA, IDMOTORISTA FROM VEICULO WHERE IDMOTORISTA = ?";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, IdMotorista);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Veiculo veiculo = new Veiculo(
	                    rs.getInt("IDVEICULO"),
	                    rs.getString("PLACA"),
	                    rs.getString("MODELO"),
	                    rs.getInt("ANO"),
	                    rs.getString("COR"),
	                    rs.getString("MARCA"),
	                    rs.getInt("IDMOTORISTA")
	                );
	                veiculos.add(veiculo);
	            }
	        }
	    }
	    return veiculos;
	}
	
	public List<Veiculo> selecionarTodosSemIdMotorista() throws SQLException {
	    List<Veiculo> veiculos = new ArrayList<>();
	    String sql = "SELECT IDVEICULO, PLACA, MODELO, ANO, COR, IDMOTORISTA, MARCA FROM VEICULO";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            int IdVeiculo = rs.getInt("IDVEICULO");
	            String placa = rs.getString("PLACA");
	            String modelo = rs.getString("MODELO");
	            int ano = rs.getInt("ANO");
	            String cor = rs.getString("COR");
	            String marca = rs.getString("MARCA");
	            int IdMotorista = rs.getInt("IDMOTORISTA");

	            Veiculo veiculo = new Veiculo(IdVeiculo, placa, modelo, ano, cor, marca, IdMotorista);
	            veiculos.add(veiculo);
	        }
	    }
	    return veiculos;
	}
	
	public void atualizar(Veiculo veiculo) throws SQLException {
	    String sql = "UPDATE veiculo SET placa = ?, modelo = ?, ano = ?, cor = ?, marca = ?, idmotorista = ? WHERE idveiculo = ?";

	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, veiculo.getPlaca());
	        stmt.setString(2, veiculo.getModelo());
	        stmt.setInt(3, veiculo.getAno());
	        stmt.setString(4, veiculo.getCor());
	        stmt.setString(5, veiculo.getMarca());
	        stmt.setInt(6, veiculo.getIdMotorista());
	        stmt.setInt(7, veiculo.getIdVeiculo()); // usa o ID do veículo!

	        int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas > 0) {
	            System.out.println("Veículo atualizado no banco de dados!");
	        } else {
	            System.out.println("Nenhum veículo encontrado com este ID.");
	        }
	    }
	}
	
	public void excluir(int IdVeiculo) throws SQLException {
		String sql = "DELETE FROM veiculo WHERE idveiculo = ?";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, IdVeiculo);
			stmt.executeUpdate();
		}
	}
	
	public Veiculo buscarPorId(int idVeiculo) throws SQLException {
	    String sql = "SELECT * FROM VEICULO WHERE IDVEICULO = ?";
	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, idVeiculo);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                Veiculo veiculo = new Veiculo(
	                    rs.getInt("IDVEICULO"),
	                    rs.getString("PLACA"),
	                    rs.getString("MODELO"),
	                    rs.getInt("ANO"),
	                    rs.getString("COR"),
	                    rs.getString("MARCA"),
	                    rs.getInt("IDMOTORISTA")
	                );
	                return veiculo;
	            }
	        }
	    }
	    return null; // não encontrado
	}
}
