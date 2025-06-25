# 🚖 Sistema de Controle de Chamados de Táxi

Projeto Integrador desenvolvido para o curso de Programação de Sistemas e Programação Web – Senac/SC.

Este sistema tem como objetivo gerenciar chamadas de táxi feitas por clientes, atendidas por motoristas com veículos cadastrados. O projeto abrange cadastro de clientes, motoristas, veículos e o registro completo das corridas realizadas.

---

## 📚 Tecnologias Utilizadas

- **Java 17** (ou versão compatível)
- **MySQL 8.0**
- **JDBC (Java Database Connectivity)**
- **JAR Executável**
- **Git & GitHub**

---

## 🗂️ Funcionalidades

- Cadastro de Clientes (com CPF e RG)
- Cadastro de Motoristas (com CNH)
- Cadastro de Veículos
- Registro de Chamados (corridas), incluindo:
  - Origem e Destino
  - Tipo de chamada (comum, executivo, viagem, etc.)
  - Quilometragem inicial e final
  - Hora de início e fim
  - Valor total da corrida
- Relacionamentos entre entidades:
  - Um cliente pode ter vários chamados
  - Um motorista pode atender vários chamados
  - Um veículo pode ser usado em vários chamados

---
## 🧱 Estrutura de Diretórios

```
📁 TaxiSistema
├── 📁 src
│   ├── 📁 com.view
│   │   └── ChamadoView.java
|   |   ├── ClienteView.java
|   |   ├── MotoristaView.java
|   |   └── VeiculoView.java
│   ├── 📁 com.conexao
│   │   ├── ConnectionFactory.java
│   │   └── TesteConexao.java
│   ├── 📁 com.controller
│   │   └── ChamadoController.java
|   |   ├── ClienteController.java
|   |   ├── MotoristaController.java
|   |   └── VeiculoController.java
│   ├── 📁 com.DAO
│   │   └── ChamadoDAO.java
│   │   ├── ClienteDAO.java
│   │   ├── MotoristaDAO.java     
│   │   └── VeiculoDAO.java
│   ├── 📁 com.heranca
│   │   ├── Chamado.java
│   │   ├── Cliente.java
│   │   ├── Main.java
│   │   ├── Motorista.java
│   │   ├── Pessoa.java
│   │   ├── TiposChamado.java
│   │   ├── Validacao.java
│   │   └── Veiculo.java
│   ├── module-info.java
|   └── 📁 lib
        └── mysql-connector-j-9.1.0 1.jar

```

---
## 🛠️ Como Executar Localmente

### Pré-requisitos:
- Java 17 ou superior
- MySQL instalado e rodando
- Git

### Passos:

1. **Clone o repositório**
```bash
git clone https://github.com/JP-Projeto-Integrador/taxi-sistema.git
cd taxi-sistema
```

2. **Crie o banco de dados no MySQL**
```sql
CREATE DATABASE DBTAXI;
```

3. **Configure a conexão no código**
No arquivo de conexão (ex: `ConnectionFactory.java`), atualize os dados:
```java
String url = "jdbc:mysql://localhost:3306/DBTAXI";
String user = "seu_usuario";
String password = "sua_senha";
```

4. **Compile e gere o `.jar`**
```bash
javac -d bin src/**/*.java
jar cfe sistema-taxi.jar com.TaxiSistema.Main -C bin .
```

5. **Execute o sistema**
```bash
java -jar sistema-taxi.jar
```

---

## 👥 Equipe

- Albertina Rodrigues
- Cristina Campos
- Gabriella Garcia

---

## 📄 Licença

Este projeto é de uso educacional, desenvolvido como parte do Projeto Integrador do primeiro semstre do Programa Jovem Programador SEPROSC & Senac/SC – 2025.
