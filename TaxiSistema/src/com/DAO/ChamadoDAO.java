package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conexao.ConnectionFactory;
import com.heranca.Chamado;

public class ChamadoDAO {
	public void inserir(Chamado chamado) throws SQLException {
		String sql = "INSERT INTO chamado (origem, destino, tipo, km_inicial, km_final, hora_inicial, hora_final, valor_total) VALUES " + "(?,?,?,?,?,?,?,?)";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, chamado.getOrigem());
			stmt.setString(2, chamado.getDestino());
			stmt.setString(3, chamado.getTipoChamado().name());
			stmt.setDouble(4, chamado.getKmInicial());
			stmt.setDouble(5, chamado.getKmFinal());
			stmt.setTimestamp(6, chamado.getHoraInicial());
			stmt.setTimestamp(7, chamado.getHoraFinal());
			stmt.setDouble(8, chamado.getValorTotal());
			stmt.executeUpdate();
		}
	}
}