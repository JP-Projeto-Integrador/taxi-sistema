package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.VeiculoDAO;
import com.heranca.Veiculo;

public class VeiculoController {
	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	
	public List<Veiculo> obterVeiculos(int idMotorista) {
	    try {
	        return veiculoDAO.selecionarTodos(idMotorista);
	    } catch (SQLException e) {
	        System.out.println("Erro ao obter veículos: " + e.getMessage());
	        return new ArrayList<Veiculo>();
	    }
	}
	
	public List<Veiculo> obterVeiculosSemIdMotorista() {
	    try {
	        return veiculoDAO.selecionarTodosSemIdMotorista();
	    } catch (SQLException e) {
	        System.out.println("Erro ao obter veículos: " + e.getMessage());
	        return new ArrayList<Veiculo>();
	    }
	}

	public void salvarVeiculo(String placa, String modelo, int ano, String cor, String marca, int IdMotorista) {
		try {
			Veiculo veiculo = new Veiculo(placa, modelo, ano, cor, marca, IdMotorista);
			veiculoDAO.inserir(veiculo);
			System.out.println("Veículo salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao salvar veículo: " + e.getMessage());
		}
	}

	public void listarVeiculos(int idMotorista) {
	    try {
	        List<Veiculo> veiculos = veiculoDAO.selecionarTodos(idMotorista);
	        System.out.println("Veículos cadastrados no banco de dados: ");
	        for (Veiculo veiculo : veiculos) {
	            System.out.println("---------------------------");
	            veiculo.exibirDados();
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao buscar veículos: " + e.getMessage());
	    }
	}

	public void atualizarVeiculo(int IdVeiculo, String placa, String modelo, int ano, String cor, String marca, int idMotorista) {
	    try {
	        // usa o construtor com ID
	        Veiculo veiculo = new Veiculo(IdVeiculo, placa, modelo, ano, cor, marca, idMotorista);
	        veiculoDAO.atualizar(veiculo);
	        System.out.println("Veículo atualizado com sucesso!");
	    } catch (SQLException e) {
	        System.out.println("Erro ao atualizar veículo: " + e.getMessage());
	    }
	}

	public void excluirVeiculo(int IdVeiculo) {
		try {
			veiculoDAO.excluir(IdVeiculo);
			System.out.println("Veículo excluído com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao excluir veículo: " + e.getMessage());
		}
	}
	
	public Veiculo buscarPorId(int idVeiculo) {
	    try {
	        return veiculoDAO.buscarPorId(idVeiculo);
	    } catch (SQLException e) {
	        System.out.println("Erro ao buscar veículo por ID: " + e.getMessage());
	        return null;
	    }
	}
}