package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.conexao.ConnectionFactory;
import com.heranca.Chamado;
import com.heranca.Cliente;
import com.heranca.Motorista;
import com.heranca.TipoChamado;
import com.heranca.Veiculo;

public class ChamadoDAO {
	public void inserir(Chamado chamado) throws SQLException {
		String sql = "INSERT INTO chamado (origem, destino, tipo, km_inicial, km_final, hora_inicial, hora_final, valor_total) VALUES "
				+ "(?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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

	public List<Chamado> selecionarTodos() throws SQLException {
		List<Chamado> chamados = new ArrayList<>();
		String sql = "SELECT ch.ORIGEM, ch.DESTINO, ch.TIPO, ch.KM_INICIAL, ch.KM_FINAL, "
				+ "ch.HORA_INICIAL, ch.HORA_FINAL, ch.VALOR_TOTAL, "
				+ "c.NOME AS cliente_nome, c.ENDERECO AS cliente_endereco, c.TELEFONE AS cliente_telefone, "
				+ "c.CPF AS cliente_cpf, c.RG AS cliente_rg, "
				+ "m.NOME AS motorista_nome, m.ENDERECO AS motorista_endereco, m.TELEFONE AS motorista_telefone, "
				+ "m.CNH AS motorista_cnh, "
				+ "v.PLACA AS veiculo_placa, v.MODELO AS veiculo_modelo, v.ANO AS veiculo_ano, "
				+ "v.COR AS veiculo_cor, v.MARCA AS veiculo_marca " + "FROM CHAMADO ch "
				+ "JOIN CLIENTE c ON ch.IDCLIENTE = c.IDCLIENTE "
				+ "JOIN MOTORISTA m ON ch.IDMOTORISTA = m.IDMOTORISTA "
				+ "JOIN VEICULO v ON ch.IDVEICULO = v.IDVEICULO";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				String origem = rs.getString("origem");
				String destino = rs.getString("destino");
				TipoChamado tipoChamado = TipoChamado.valueOf(rs.getString("tipoChamado"));
				double kmInicial = rs.getDouble("kmInicial");
				double kmFinal = rs.getDouble("kmFinal");
				Timestamp horaInicial = rs.getTimestamp("horaInicial");
				Timestamp horaFinal = rs.getTimestamp("horaFinal");
				double valorTotal = rs.getDouble("valorTotal");

				Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"),
						rs.getString("cpf"), rs.getString("rg"));

				Motorista motorista = new Motorista(rs.getString("nome"), rs.getString("telefone"),
						rs.getString("endereco"), rs.getString("cnh"));

				Veiculo veiculo = new Veiculo(rs.getString("placa"), rs.getString("modelo"), rs.getInt("ano"),
						rs.getString("cor"), rs.getString("marca"));

				Chamado chamado = new Chamado(origem, destino, tipoChamado, kmInicial, kmFinal, horaInicial, horaFinal,
						valorTotal, cliente, motorista, veiculo);
				chamados.add(chamado);
			}
		}
		return chamados;
	}

	public void encerrarChamado(int IdChamado) throws SQLException {

		String sql = "UPDATE chamado SET hora_final = ? WHERE idchamado = ?";
		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			stmt.setInt(2, IdChamado);
			stmt.executeUpdate();

		}
	}

}
