package com.heranca;

public class Veiculo {

	private String placa;
	private String modelo;
	private int ano;
	private String cor;
	private String marca;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Veiculo(String placa, String modelo, int ano, String cor, String marca) {

		if (!Validacao.validarPlaca(placa)) {

			throw new IllegalArgumentException("Placa inválida " + placa);
		}

		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Veiculo [placa =" + placa + ", modelo =" + modelo + ", ano =" + ano + ", cor =" + cor + ", marca ="
				+ marca + "]";
	}

    public void exibirDados() {
    	System.out.println("Veículo:");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("Cor: " + getCor());
        System.out.println("Marca: " + getMarca());
    }

}