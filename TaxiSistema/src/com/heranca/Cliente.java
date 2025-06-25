package com.heranca;

public class Cliente extends Pessoa {
	private String rg;
	private String cpf;
	
	public Cliente (String nome, String telefone, String endereco, String rg, String cpf) {
		super(nome, telefone, endereco);
		
		if (!Validacao.validarRG(rg)) {

			throw new IllegalArgumentException("RG inválido " + rg);
		}
		
		if (!Validacao.validarCPF(cpf)) {

			throw new IllegalArgumentException("CPF inválido " + cpf);
		}

		this.rg = rg;
		this.cpf = cpf;
	}
	// Getters
    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    // Setters com validação
    public void setRg(String rg) {
        if (!Validacao.validarRG(rg)) {
            throw new IllegalArgumentException("RG inválido: " + rg);
        }
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        if (!Validacao.validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido: " + cpf);
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente |" +
                "Nome ='" + getNome() + '\'' +
                ", Telefone ='" + getTelefone() + '\'' +
                ", Endereco ='" + getEndereco() + '\'' +
                ", RG ='" + rg + '\'' +
                ", CPF ='" + cpf;
    }
    
    public void exibirDados() {
    	System.out.println("Cliente:");
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("RG: " + rg);
        System.out.println("CPF: " + cpf);
    }
	
}

