package model;

public class Client {
    private int id;
    private String name;
    private String email;
    private String contactNumber;
    private String cpf;

    public Client() {
    }

    public Client(int id, String name, String email, String contactNumber, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.cpf = cpf;
    }

    public Client(String cpf, String name, int id) {
        this.cpf = cpf;
        this.name = name;
        this.id = id;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nome=" + name + ", cpf=" + cpf + "}";
    }
}
