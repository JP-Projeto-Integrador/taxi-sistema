package com.conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			if (conn != null && !conn.isClosed()) {
				System.out.println("Conexão estabelecida com sucesso!");
			} else {
				System.out.println("Falha ao estabelecer conexão.");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectar: " + e.getMessage());
		}
	}

}