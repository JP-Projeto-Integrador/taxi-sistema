package com.controller;

import java.sql.SQLException;

import com.DAO.MotoristaDAO;
import com.heranca.Motorista;

public class MotoristaController {
	private MotoristaDAO motoristaDAO = new MotoristaDAO();
	
	public void salvarMotorista (String nome, String telefone, String endereco, String cnh) {
		try {
			Motorista motorista = new Motorista (nome, telefone, endereco, cnh);
			motoristaDAO.inserir(motorista);
			System.out.println("Motorista cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar motorista: " + e.getMessage());
		}
	}
}
