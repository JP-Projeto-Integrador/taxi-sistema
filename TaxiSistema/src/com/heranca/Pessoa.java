package com.heranca;

public class Pessoa {
	private String nome;
	private String endereco;
	private String telefone;

	
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

	public Pessoa(String nome, String endereco, String telefone) {
		
		if (!Validacao.validarTelefone(telefone)) {

			throw new IllegalArgumentException("Telefone inválido " + telefone);

		}

		this.nome = nome;
		
		this.endereco = endereco;

		this.telefone = telefone;


	}
	
	
	
}