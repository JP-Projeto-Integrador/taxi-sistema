package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.VeiculoDAO;
import com.heranca.Veiculo;

public class VeiculoController {
	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	
	public List<Veiculo> obterVeiculos() {
	    try {
	        return veiculoDAO.selecionarTodos();
	    } catch (SQLException e) {
	        System.out.println("Erro ao obter veículos: " + e.getMessage());
	        return new ArrayList<Veiculo>();
	    }
	}

	public void salvarVeiculo(String placa, String modelo, int ano, String cor, String marca) {
		try {
			Veiculo veiculo = new Veiculo(placa, modelo, ano, cor, marca);
			veiculoDAO.inserir(veiculo);
			System.out.println("Veículo salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao salvar veículo: " + e.getMessage());
		}
	}

	public void listarVeiculos() {
		try {
			List<Veiculo> veiculos = veiculoDAO.selecionarTodos();
			System.out.println("Veiculos cadastrados no banco de dados: ");
			for (Veiculo veiculo : veiculos) {
				System.out.println("---------------------------");
				veiculo.exibirDados();
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar veículos: " + e.getMessage());
		}
	}

	public void atualizarVeiculo(String placa, String modelo, int ano, String cor, String marca) {
		try {
			Veiculo veiculo = new Veiculo(placa, modelo, ano, cor, marca);
			veiculoDAO.atualizar(veiculo);
			System.out.println("Veículo atualizado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar veículo: " + e.getMessage());
		}
	}

	public void excluirVeiculo(String placa) {
		try {
			veiculoDAO.excluir(placa);
			System.out.println("Veículo excluído com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao excluir veículo: " + e.getMessage());
		}
	}
}