# ClientManager

Aplicação de linha de comando para gerenciamento de clientes, desenvolvida em Java puro com conexão direta ao banco de dados PostgreSQL via JDBC.

---

## 📋 Funcionalidades

- Cadastrar novo cliente
- Listar todos os clientes
- Buscar cliente por ID
- Atualizar informações do cliente (nome, email, CPF ou telefone)
- Remover cliente

---

## 🛠️ Tecnologias utilizadas

- Java (sem frameworks)
- PostgreSQL
- JDBC puro

---

## 📁 Estrutura do projeto

```
src/
├── Main.java
├── model/
│   └── Client.java
├── repository/
│   └── ClientRepository.java
├── service/
│   └── ClientService.java
└── util/
    └── ConnectionDB.java
```

---

## ⚙️ Como configurar e executar

### Pré-requisitos

- Java JDK 17 ou superior
- PostgreSQL instalado e rodando
- Driver JDBC do PostgreSQL (.jar)

### 1. Clone o repositório

```bash
git clone https://github.com/JoaoPaulo2205/ClientManager.git
cd ClientManager
```

### 2. Configure o banco de dados

Crie o banco e a tabela no PostgreSQL:

```sql
CREATE DATABASE connect_client;

CREATE TABLE client (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    cellphone CHAR(15),
    cpf CHAR(11) UNIQUE NOT NULL
);
```

### 3. Configure as credenciais

Crie um arquivo `config.properties` na raiz do projeto baseado no `config.properties.example`:

```properties
DB_URL=jdbc:postgresql://localhost:5432/connect_client?sslmode=disable
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```

> ⚠️ O arquivo `config.properties` está no `.gitignore` e nunca será enviado ao GitHub.

### 4. Adicione o driver JDBC

Baixe o driver em [jdbc.postgresql.org/download](https://jdbc.postgresql.org/download/) e adicione o `.jar` ao classpath do projeto na sua IDE.

### 5. Execute

Rode a classe `Main.java` pela sua IDE.

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

- **Model** — representa a entidade `Client`
- **Repository** — executa as queries SQL diretamente no banco
- **Service** — contém as regras de negócio e validações
- **Util** — gerencia a conexão com o banco de dados

---

## 👨‍💻 Autor

João Paulo — [github.com/JoaoPaulo2205](https://github.com/JoaoPaulo2205)
