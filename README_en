# ClientManager

A command-line application for managing clients, built with pure Java and direct PostgreSQL database connectivity via JDBC.

---

## 📋 Features

- Register a new client
- List all clients
- Search client by ID
- Update client information (name, email, CPF or phone number)
- Remove a client

---

## 🛠️ Technologies

- Java (no frameworks)
- PostgreSQL
- Pure JDBC

---

## 📁 Project structure

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

## ⚙️ Setup and usage

### Requirements

- Java JDK 17 or higher
- PostgreSQL installed and running
- PostgreSQL JDBC driver (.jar)

### 1. Clone the repository

```bash
git clone https://github.com/JoaoPaulo2205/ClientManager.git
cd ClientManager
```

### 2. Set up the database

Create the database and table in PostgreSQL:

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

### 3. Configure credentials

Create a `config.properties` file at the project root based on `config.properties.example`:

```properties
DB_URL=jdbc:postgresql://localhost:5432/connect_client?sslmode=disable
DB_USER=your_user
DB_PASSWORD=your_password
```

> ⚠️ The `config.properties` file is listed in `.gitignore` and will never be pushed to GitHub.

### 4. Add the JDBC driver

Download the driver at [jdbc.postgresql.org/download](https://jdbc.postgresql.org/download/) and add the `.jar` to your project classpath in your IDE.

### 5. Run

Execute the `Main.java` class from your IDE.

---

## 🏗️ Architecture

The project follows a layered architecture:

- **Model** — represents the `Client` entity
- **Repository** — executes SQL queries directly against the database
- **Service** — contains business rules and validations
- **Util** — manages the database connection

---

## 👨‍💻 Author

João Paulo — [github.com/JoaoPaulo2205](https://github.com/JoaoPaulo2205)
