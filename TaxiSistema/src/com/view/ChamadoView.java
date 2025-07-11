package com.view;

import java.sql.Timestamp;
import java.util.Scanner;

import com.controller.ChamadoController;
import com.heranca.TipoChamado;

public class ChamadoView {
	private ChamadoController controller = new ChamadoController();
	private Scanner sc = new Scanner(System.in);
	
	
	private Timestamp Timestamp(long timeMillis) {
		// TODO Auto-generated method stub
		return null;
	}
		
	Timestamp horaInicial = Timestamp(System.currentTimeMillis());
		
	public void cadastrarChamado() {
        System.out.print("Origem: ");
        String origem = sc.nextLine();

        System.out.print("Destino: ");
        String destino = sc.nextLine();

        System.out.print("Tipo de chamado (BASIC, COMFORT, PRIORITY): ");
        String tipoChamado = sc.nextLine();
        
        double kmInicial = 0.0;
        
        System.out.print("Km Final: ");
        double kmFinal = sc.nextDouble();
         
        // método p chamar ValorTotal

        controller.salvarChamado(origem, destino, null, kmInicial, kmFinal, kmFinal, null, null, null);
    }
	
	public void listarChamados() {
        try {
            controller.listarChamado();
        } catch (Exception e) {
        	System.out.println("Erro ao listar chamados: " + e.getMessage());
            } 
    }
	
	public void encerrarChamado() {
        System.out.print("Digite o ID do chamado a encerrar: ");
        int chamadoId = sc.nextInt();

        controller.encerrarChamado(chamadoId);;
    }
	
}
