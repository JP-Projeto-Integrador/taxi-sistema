package com.heranca;

public class Validacao {
	public static boolean validarCPF (String cpf) {

		if (cpf == null) return false; 

		//^\\d significa: Corresponde a uma string que 	

		cpf = cpf.replaceAll ("[^\\d]", "");

		//diferente de 11

		if (cpf.length() != 11) return false;

		//o regex (\\d)\\1{10} procura uma sequência de 

		if (cpf.matches("(\\d)\\1{10}")) return false;

		//logica do algoritmo de validacao de CPF

		int soma = 0, peso = 10;

		for(int i = 0; i< 9; i++) soma += (cpf.charAt(i) - '0') * peso--;

		int primeiroDigito = 11 - (soma % 11);

		if (primeiroDigito >= 10) primeiroDigito = 0;

		soma = 0; peso = 11;

		for (int i = 0; i < 10; i++) soma += (cpf.charAt(i) - '0') * peso--;

		int segundoDigito = 11 - (soma % 11);

		if (segundoDigito >=10 ) segundoDigito =0;

		return cpf.charAt(9) - '0' == primeiroDigito && cpf.charAt(10) - '0' == segundoDigito;

	}
	
	public static boolean validarRG(String rg) {
        if (rg == null) return false;

        // Remove todos os caracteres não numéricos
        rg = rg.replaceAll("[^\\d]", "");

        // RG deve ter 9 dígitos 
        if (rg.length() != 9) return false;

        // Verifica se todos os dígitos são iguais (caso inválido)
        if (rg.matches("(\\d)\\1{8}")) return false;
        
        return true;
        }
	
	public static boolean validarCNH(String cnh) {
        if (cnh == null) return false;

        // Remove todos os caracteres não numéricos
        cnh = cnh.replaceAll("[^\\d]", "");

        // CNH deve ter exatamente 9 dígitos
        if (cnh.length() != 9) return false;

        // Verifica se todos os dígitos são iguais (caso inválido)
        if (cnh.matches("(\\d)\\1{8}")) return false;

        // Retorna true pois o formato está correto
 
        return true;
    }
	
	public static boolean validarTelefone (String telefone) {

		if (telefone == null) return false;

		telefone = telefone.replaceAll("[^\\d]", "");

		return telefone.matches("\\d{10,11}");

	}
	
	public static boolean validarPlaca(String placa) {
        if (placa == null) return false;

        // Remove todos os caracteres não numéricos
        placa = placa.replaceAll("[^\\d]", "");

        // CNH deve ter exatamente 7 dígitos
        if (placa.length() != 7) return false;

        // Retorna true pois o formato está correto
 
        return true;
    }

}
