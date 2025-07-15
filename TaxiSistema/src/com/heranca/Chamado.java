package com.heranca;


import java.sql.Timestamp;



public class Chamado {

	private int chamadoId;
    private String origem;
    private String destino;
    private TipoChamado tipoChamado;
    private double kmInicial;
    private double kmFinal;
    private Timestamp horaInicial;
    private Timestamp horaFinal;
    private double valorTotal;



    private Cliente cliente;
    private Motorista motorista;
    private Veiculo veiculo;


    public Chamado(String origem, String destino, TipoChamado tipoChamado, double kmInicial, double kmFinal,
                   Timestamp horaInicial, Timestamp horaFinal, double valorTotal, Cliente cliente, Motorista motorista, Veiculo veiculo) {
        this.origem = origem;
        this.destino = destino;
        this.tipoChamado = tipoChamado;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.motorista = motorista;
        this.veiculo = veiculo;
    }


    public void exibirDados() {
    	System.out.println("Chamado:");
    	System.out.println("ID:" + getChamadoId());
        System.out.println("Origem: " + getOrigem());
        System.out.println("Destino: " + getDestino());
        System.out.println("Tipo de Chamado: " + getTipoChamado());
        System.out.println("Hora Inicial: " + getHoraInicial());
        System.out.println("Hora Final: " + getHoraFinal());
        System.out.println("Valor Total: " + getValorTotal());
    	System.out.println("\nChamado - Dados do Cliente:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("\nChamado - Dados do Motorista:");
        System.out.println("Nome: " + motorista.getNome());
        System.out.println("\nChamado - Dados do Veículo:");
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Cor: " + veiculo.getCor());
        System.out.println("Marca: " + veiculo.getMarca());
    }


	public int getChamadoId() {
		return chamadoId;
	}


	public void setChamadoId(int chamadoId) {
		this.chamadoId = chamadoId;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public TipoChamado getTipoChamado() {
		return tipoChamado;
	}


	public void setTipoChamado(TipoChamado tipoChamado) {
		this.tipoChamado = tipoChamado;
	}


	public double getKmInicial() {
		return kmInicial;
	}


	public void setKmInicial(double kmInicial) {
		this.kmInicial = kmInicial;
	}


	public double getKmFinal() {
		return kmFinal;
	}


	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}


	public Timestamp getHoraInicial() {
		return horaInicial;
	}


	public void setHoraInicial(Timestamp horaInicial) {
		this.horaInicial = horaInicial;
	}


	public Timestamp getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(Timestamp horaFinal) {
		this.horaFinal = horaFinal;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Motorista getMotorista() {
		return motorista;
	}


	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}



}
