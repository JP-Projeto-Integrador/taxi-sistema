package com.heranca;

public class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Pessoa(String nome, String telefone, String endereco) {
		
		if (!Validacao.validarTelefone(telefone)) {

			throw new IllegalArgumentException("Telefone inválido " + telefone);

		}

		this.nome = nome;

		this.telefone = telefone;

		this.endereco = endereco;

	}
	
	
	
}