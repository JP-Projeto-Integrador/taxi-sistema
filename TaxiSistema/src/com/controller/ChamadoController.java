package com.controller;

import java.sql.Timestamp;

import com.DAO.ChamadoDAO;
import com.heranca.Chamado;
import com.heranca.Cliente;
import com.heranca.Motorista;
import com.heranca.TipoChamado;
import com.heranca.Veiculo;

public class ChamadoController {
	private ChamadoDAO chamadoDAO = new ChamadoDAO();
	
	public void salvarChamado(String origem, String destino, TipoChamado tipoChamado, 
			double kmInicial, double kmFinal, double valorTotal, Cliente cliente, Motorista motorista, Veiculo veiculo) {
		try {
			Timestamp horaInicial = new Timestamp(System.currentTimeMillis());
			Timestamp horaFinal = null;
			
			Chamado chamado = new Chamado(origem, destino, tipoChamado, kmInicial, kmFinal, null, null, valorTotal, cliente, motorista, veiculo);
			
			
		
				 
		}
	}

}
