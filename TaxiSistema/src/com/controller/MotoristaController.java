package com.controller;

import java.sql.SQLException;
import java.util.List;

import com.DAO.MotoristaDAO;
import com.heranca.Motorista;

public class MotoristaController {
	private MotoristaDAO motoristaDAO = new MotoristaDAO();
	
	public void salvarMotorista (String nome, String endereco, String telefone, String cnh) {
		try {
			Motorista motorista = new Motorista (nome, endereco, telefone, cnh);
			motoristaDAO.inserir(motorista);
			System.out.println("Motorista cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar motorista: " + e.getMessage());
		}
	}
	
	public void listarMotoristas() {
		try {
			List<Motorista> motoristas = motoristaDAO.selecionarTodos();
			System.out.println("Motoristas cadastrados no banco de dados: ");
			for (Motorista motorista : motoristas) {
				System.out.println ("---------------------------");
				motorista.exibirDados();
			}
		} catch (Exception e) {
			System.out.print("Erro ao buscar motoristas: " + e.getMessage());
		}
	}
	
	public void atualizarMotorista (String nome, String endereco, String telefone, String cnh) {
		try {
			Motorista motorista = new Motorista(nome, endereco, telefone, cnh);
			motoristaDAO.atualizar(motorista);
			System.out.println("Motorista atualizado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar motorista: " +e.getMessage());
		}
	}
	
	public void excluirMotorista(String cnh) {
		try {
			motoristaDAO.excluir(cnh);
			System.out.println ("Motorista excluído com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao excluir motorista: " +e.getMessage());
		}
	}
}
