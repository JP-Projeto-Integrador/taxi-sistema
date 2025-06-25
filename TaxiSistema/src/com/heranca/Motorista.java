package com.heranca;

public class Motorista extends Pessoa {
	private String cnh;

	public Motorista(String nome, String telefone, String endereco, String cnh) {
		super(nome, telefone, endereco);

		if (!Validacao.validarCNH(cnh)) {

			throw new IllegalArgumentException("CNH inválido " + cnh);
		}

		this.cnh = cnh;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		if (!Validacao.validarCNH(cnh)) {
			throw new IllegalArgumentException("CNH inválida: " + cnh);
		}
		this.cnh = cnh;
	}

	@Override
	public String toString() {
		return "Motorista | " + "Nome ='" + getNome() + '\'' + ", Telefone ='" + getTelefone() + '\'' + ", Endereco ='"
				+ getEndereco() + '\'' + ", CNH =" + cnh;

	}
	
	public void exibirDados() {
		System.out.println("Motorista:");
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("CNH: " + cnh);
	}
}