package com.heranca;

public class Cliente extends Pessoa {
	int IdCliente;
	private String rg;
	private String cpf;
	
	// Construtor para inserção (sem id)
	public Cliente (String nome, String endereco, String telefone,  String cpf, String rg) {
		super(nome, endereco, telefone);

		if (!Validacao.validarRG(rg)) {

			throw new IllegalArgumentException("RG inválido " + rg);
		}

		if (!Validacao.validarCPF(cpf)) {

			throw new IllegalArgumentException("CPF inválido " + cpf);
		}

		this.rg = rg;
		this.cpf = cpf;
	}
	
	// Construtor para recuperação (com id)
    public Cliente(int IdCliente, String nome, String endereco, String telefone, String cpf, String rg) {
    	super(nome, endereco, telefone);
    	if (!Validacao.validarRG(rg)) {

			throw new IllegalArgumentException("RG inválido " + rg);
		}

		if (!Validacao.validarCPF(cpf)) {

			throw new IllegalArgumentException("CPF inválido " + cpf);
		}
		this.IdCliente = IdCliente;
		this.rg = rg;
		this.cpf = cpf;
    }

	// Getters
	public int getIdCliente() {
		return IdCliente;
	}


	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

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
        		"ID =" + getIdCliente() + '\'' +
                "Nome ='" + getNome() + '\'' +
                ", Endereco ='" + getEndereco() + '\'' +
                ", Telefone ='" + getTelefone() + '\'' +
                ", CPF ='" + cpf + '\'' +
                ", RG ='" + rg;
    }

    public void exibirDados() {
    	System.out.println("Cliente:");
    	System.out.println("ID: " + getIdCliente());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("CPF: " + cpf);
        System.out.println("RG: " + rg);

    }

}