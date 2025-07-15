package com.heranca;

public class Motorista extends Pessoa {
	int IdMotorista;
	private String cnh;

	public Motorista(String nome, String endereco, String telefone, String cnh) {
		super(nome, endereco, telefone);

		if (!Validacao.validarCNH(cnh)) {

			throw new IllegalArgumentException("CNH inválido " + cnh);
		}

		this.cnh = cnh;
	}
	
	// Construtor para recuperação (com id)
    public Motorista(int IdMotorista, String nome, String endereco, String telefone, String cnh) {
		super(nome, endereco, telefone);

		if (!Validacao.validarCNH(cnh)) {

			throw new IllegalArgumentException("CNH inválido " + cnh);
		}
		
		this.IdMotorista = IdMotorista;
		this.cnh = cnh;
    }
	
	public int getIdMotorista() {
		return IdMotorista;
	}



	public void setIdMotorista(int idMotorista) {
		IdMotorista = idMotorista;
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
		return "Motorista | " + "Nome ='" + getNome() + '\'' + ", Endereco ='"
				+ getEndereco() + ", Telefone ='" + getTelefone() + '\''  + '\'' + ", CNH =" + cnh;

	}

	public void exibirDados() {
		System.out.println("Motorista:");
		System.out.println("ID: " + getIdMotorista());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("CNH: " + cnh);
	}
}