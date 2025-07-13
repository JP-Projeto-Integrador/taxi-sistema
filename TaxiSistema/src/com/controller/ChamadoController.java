package com.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.DAO.ChamadoDAO;
import com.heranca.Chamado;
import com.heranca.Cliente;
import com.heranca.Motorista;
import com.heranca.TipoChamado;
import com.heranca.Veiculo;

public class ChamadoController {
	private ChamadoDAO chamadoDAO = new ChamadoDAO();

	public void salvarChamado(String origem, String destino, TipoChamado tipoChamado, double kmInicial, double kmFinal,
			double valorTotal, Cliente cliente, Motorista motorista, Veiculo veiculo) {
		try {
			Timestamp horaInicial = new Timestamp(System.currentTimeMillis());
			Timestamp horaFinal = null;

			Chamado chamado = new Chamado(origem, destino, tipoChamado, kmInicial, kmFinal, null, null, valorTotal,
					cliente, motorista, veiculo);

			chamadoDAO.inserir(chamado);
			System.out.println("Chamado inserido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao salvar Chamado: " + e.getMessage());

		}
	}
   
	public void listarChamado() {
		try {
			List<Chamado> chamados = chamadoDAO.selecionarTodos();
			System.out.println("Chamados cadastrados no banco de dados: ");
			for (Chamado chamado : chamados) {
				System.out.println("---------------------------");
				chamado.exibirDados();
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar chamados: " + e.getMessage());
		}
	}
	
	
	public void encerrarChamado(int chamadoId) {
	    try {
	        Chamado chamado = new Chamado(null, null, null, chamadoId, chamadoId, null, null, chamadoId, null, null, null); // cria o objeto chamado
	        chamado.getChamadoId();            
	        chamadoDAO.encerrarChamado(chamadoId);    
	        System.out.println("Chamado encerrado com sucesso!");
	    } catch (SQLException e) {
	        System.out.println("Erro ao encerrar chamado: " + e.getMessage());
	    }
	}
}
