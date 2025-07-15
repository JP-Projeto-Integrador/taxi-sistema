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
		String sql = "INSERT INTO chamado (origem, destino, tipo, km_inicial, km_final, hora_inicial, hora_final, valor_total, idcliente, idmotorista, idveiculo) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, chamado.getOrigem());
			stmt.setString(2, chamado.getDestino());
			stmt.setString(3, chamado.getTipoChamado().name());
			stmt.setDouble(4, chamado.getKmInicial());
			stmt.setDouble(5, chamado.getKmFinal());
			stmt.setTimestamp(6, chamado.getHoraInicial());
			stmt.setTimestamp(7, chamado.getHoraFinal());
			stmt.setDouble(8, chamado.getValorTotal());
			// chamando os dados das classes (chaves estrangeiras)
			stmt.setInt(9, chamado.getCliente().getIdCliente());
			stmt.setInt(10, chamado.getMotorista().getIdMotorista());
			stmt.setInt(11, chamado.getVeiculo().getIdVeiculo());
			stmt.executeUpdate();
		}
	}

	public List<Chamado> selecionarTodos() throws SQLException {
		List<Chamado> chamados = new ArrayList<>();
		String sql = "SELECT ch.IDCHAMADO, ch.ORIGEM, ch.DESTINO, ch.TIPO, ch.KM_INICIAL, ch.KM_FINAL,\r\n"
				+ "       ch.HORA_INICIAL, ch.HORA_FINAL, ch.VALOR_TOTAL,\r\n"
				+ "       c.IDCLIENTE AS cliente_id, c.NOME AS cliente_nome, c.ENDERECO AS cliente_endereco, c.TELEFONE AS cliente_telefone,\r\n"
				+ "       c.CPF AS cliente_cpf, c.RG AS cliente_rg,\r\n"
				+ "       m.IDMOTORISTA AS motorista_id, m.NOME AS motorista_nome, m.ENDERECO AS motorista_endereco, m.TELEFONE AS motorista_telefone,\r\n"
				+ "       m.CNH AS motorista_cnh,\r\n"
				+ "       v.IDVEICULO AS veiculo_id, v.PLACA AS veiculo_placa, v.MODELO AS veiculo_modelo, v.ANO AS veiculo_ano,\r\n"
				+ "       v.COR AS veiculo_cor, v.MARCA AS veiculo_marca\r\n" + "FROM CHAMADO ch\r\n"
				+ "JOIN CLIENTE c ON ch.IDCLIENTE = c.IDCLIENTE\r\n"
				+ "JOIN MOTORISTA m ON ch.IDMOTORISTA = m.IDMOTORISTA\r\n"
				+ "JOIN VEICULO v ON ch.IDVEICULO = v.IDVEICULO";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int IdChamado = rs.getInt("IDCHAMADO");
				String origem = rs.getString("ORIGEM");
				String destino = rs.getString("DESTINO");
				TipoChamado tipoChamado = TipoChamado.valueOf(rs.getString("TIPO"));
				double kmInicial = rs.getDouble("KM_INICIAL");
				double kmFinal = rs.getDouble("KM_FINAL");
				Timestamp horaInicial = rs.getTimestamp("HORA_INICIAL");
				Timestamp horaFinal = rs.getTimestamp("HORA_FINAL");
				double valorTotal = rs.getDouble("VALOR_TOTAL");

				Cliente cliente = new Cliente(rs.getInt("cliente_id"), rs.getString("cliente_nome"),
						rs.getString("cliente_endereco"), rs.getString("cliente_telefone"), rs.getString("cliente_cpf"),
						rs.getString("cliente_rg"));

				Motorista motorista = new Motorista(rs.getInt("motorista_id"), rs.getString("motorista_nome"),
						rs.getString("motorista_endereco"), rs.getString("motorista_telefone"),
						rs.getString("motorista_cnh"));

				Veiculo veiculo = new Veiculo(rs.getInt("veiculo_id"), rs.getString("veiculo_placa"),
						rs.getString("veiculo_modelo"), rs.getInt("veiculo_ano"), rs.getString("veiculo_cor"),
						rs.getString("veiculo_marca"), rs.getInt("veiculo_idmotorista"));

				Chamado chamado = new Chamado(IdChamado, origem, destino, tipoChamado, kmInicial, kmFinal, horaInicial,
						horaFinal, valorTotal, cliente, motorista, veiculo);

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
