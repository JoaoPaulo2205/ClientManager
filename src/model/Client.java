package model;

public class Client {
    private int id;
    private String name;
    private String email;
    private String cellphoneNumber;
    private String cpf;

    public Client() {
    }

    public Client(String name, String email, String contactNumber, String cpf) {
        this.name = name;
        this.email = email;
        this.cellphoneNumber = contactNumber;
        this.cpf = cpf;
    }

    public Client(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + name + " |  CPF: " + cpf + " | Cellphone Number: " + cellphoneNumber + " | Email: " + email;
    }
}
