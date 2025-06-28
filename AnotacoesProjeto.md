# 📒 Anotações Importantes sobre o Projeto
---
&nbsp;
&nbsp;
## 1️⃣ Comparando as estruturas do método `selecionarTodos()` das classes `ClienteDAO` e `ChamadoDAO`
### 👩🏽‍💻 Por Albie & ChatGPT

## ✅ Estrutura 1 — **`ClienteDAO` simples**

```java
public List<Cliente> selecionarTodos() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Cliente cliente = new Cliente (
								rs.getString("nome"),
								rs.getString("endereco"),
								rs.getString("telefone"),
								rs.getString("cpf"),
								rs.getString("rg"));
							clientes.add(cliente);
					}
				}
		return clientes;
```

### 💬 O que está acontecendo?

Essa estrutura **consulta só uma tabela** (`CLIENTE`) e **cria objetos simples** da classe `Cliente` com os dados diretamente do `ResultSet`.

---

### 🧠 Em resumo:

| Característica                   | Explicação Simples                           |
| -------------------------------- | -------------------------------------------- |
| Consulta só a tabela `CLIENTE`   | SQL simples: `SELECT * FROM cliente`         |
| Cria um objeto `Cliente` por vez | Só usa os dados da própria tabela.           |
| Código mais curto e direto       | Não precisa se preocupar com outras tabelas. |
| Não há objetos aninhados         | O `Cliente` é um objeto isolado.             |

---

## ✅ Estrutura 2 — **`ChamadoDAO` com `JOIN`**

```java
public List<Chamado> selecionarTodos() throws SQLException {
		List<Chamado> chamados = new ArrayList<>();
		String sql = "SELECT ch.ORIGEM, ch.DESTINO, ch.TIPO, ch.KM_INICIAL, ch.KM_FINAL, " +
	             "ch.HORA_INICIAL, ch.HORA_FINAL, ch.VALOR_TOTAL, " +
	             "c.NOME AS cliente_nome, c.ENDERECO AS cliente_endereco, c.TELEFONE AS cliente_telefone, " +
	             "c.CPF AS cliente_cpf, c.RG AS cliente_rg, " +
	             "m.NOME AS motorista_nome, m.ENDERECO AS motorista_endereco, m.TELEFONE AS motorista_telefone, " +
	             "m.CNH AS motorista_cnh, " +
	             "v.PLACA AS veiculo_placa, v.MODELO AS veiculo_modelo, v.ANO AS veiculo_ano, " +
	             "v.COR AS veiculo_cor, v.MARCA AS veiculo_marca " +
	             "FROM CHAMADO ch " +
	             "JOIN CLIENTE c ON ch.IDCLIENTE = c.IDCLIENTE " +
	             "JOIN MOTORISTA m ON ch.IDMOTORISTA = m.IDMOTORISTA " +
	             "JOIN VEICULO v ON ch.IDVEICULO = v.IDVEICULO";
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
                                                      //Dados do chamado
							String origem = rs.getString("origem");
							String destino = rs.getString("destino");
							TipoChamado tipoChamado = TipoChamado.valueOf(rs.getString("tipoChamado"));
							double kmInicial = rs.getDouble("kmInicial");
							double kmFinal = rs.getDouble("kmFinal");
							Timestamp horaInicial = rs.getTimestamp("horaInicial");
							Timestamp horaFinal = rs.getTimestamp("horaFinal");
							double valorTotal = rs.getDouble("valorTotal");

                                                        //Dados do cliente
							Cliente cliente = new Cliente(
									rs.getString("nome"),
									rs.getString("endereco"),
									rs.getString("telefone"),
									rs.getString("cpf"),
									rs.getString("rg")
							);
							
                                                        //Dados do motorista
							Motorista motorista = new Motorista(
									rs.getString("nome"),
									rs.getString("telefone"),
									rs.getString("endereco"),
									rs.getString("cnh")
							);
							
                                                        //Dados do veiculo
							Veiculo veiculo = new Veiculo(
									rs.getString("placa"),
									rs.getString("modelo"),
									rs.getInt("ano"),
									rs.getString("cor"),
									rs.getString("marca")
							);
                                                        //Cria o objeto chamado
							Chamado chamado = new Chamado(
									origem, destino, tipoChamado,
									kmInicial, kmFinal, horaInicial, horaFinal, valorTotal,
									cliente, motorista, veiculo
								);
							chamados.add(chamado);
					}
				}
		return chamados;
```

### 💬 O que está acontecendo?

Essa estrutura busca **dados de múltiplas tabelas ao mesmo tempo** (`CHAMADO`, `CLIENTE`, `MOTORISTA`, `VEICULO`) usando **`JOIN` no SQL**. A ideia é **trazer tudo em uma única consulta** para montar um objeto completo `Chamado`, que **contém outros objetos dentro dele** (cliente, motorista e veículo).

---

### 🧠 Em resumo:

| Característica                         | Explicação Simples                                                     |
| -------------------------------------- | ---------------------------------------------------------------------- |
| Usa `JOIN`                             | Junta várias tabelas numa só consulta.                                 |
| Monta objetos complexos                | O `Chamado` contém `Cliente`, `Motorista` e `Veiculo`.                 |
| SQL mais longo                         | Porque precisa trazer todos os dados de todas as tabelas relacionadas. |
| Evita chamadas separadas para cada DAO | Porque já traz tudo de uma vez.                                        |

---

## 🧩 Comparando os dois:

| Item                     | `ChamadoDAO`                                                     | `ClienteDAO`                         |
| ------------------------ | ---------------------------------------------------------------- | ------------------------------------ |
| SQL                      | Complexo, com `JOINs`                                            | Simples, só `SELECT * FROM`          |
| Quantas tabelas acessa?  | 4 (chamado + cliente + motorista + veiculo)                      | 1 (cliente)                          |
| Tipo de objeto retornado | `Chamado` (com objetos `Cliente`, `Motorista`, `Veiculo` dentro) | `Cliente`                            |
| Usado quando...          | Você precisa montar objetos com **vários dados relacionados**    | Você quer apenas a lista de clientes |

---

## ✅ Por que usamos `JOIN` no `ChamadoDAO`?

Porque o `Chamado` **tem atributos que são outros objetos**:

```java
private Cliente cliente;
private Motorista motorista;
private Veiculo veiculo;
```

Ou seja: você não pode montar um `Chamado` completo só com a tabela `CHAMADO`. Você **precisa consultar os dados do cliente, do motorista e do veículo** também. Em vez de fazer 3 consultas separadas (o que seria lento), usamos um `JOIN` para **trazer tudo junto de uma vez**.

---

