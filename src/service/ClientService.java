package service;

import model.Client;
import repository.ClientRepository;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    ClientRepository repository = new ClientRepository();

    public void saveNewClient(Client client) throws SQLException {
        if (client.getName().isEmpty()) {
            System.err.println("Error Insert the client name!");
            return;
        } else if (client.getCpf().isEmpty()) {
            System.err.println("Error Insert the client CPF!");
            return;
        } else if (client.getCpf().length() != 11) {
            System.err.println("Error client CPF have an invalid length! (11)");
            return;
        }
        if (client != null){
            repository.save(client);
            System.out.println("Successfully Saved!");
        }
    }

    public List<Client> listClients() throws SQLException {
        List<Client> clients = repository.searchClients();
        if (clients.isEmpty()) {
            throw new SQLException("No records found!");
        }
        return clients;

    }

    public Client searchClientbyId(int id) throws SQLException {
        Client client = repository.searchClientsById(id);
        if (client == null) {
            throw new IllegalArgumentException("Client with id " + id + " does not exist!");
        }
        return client;
    }

    public Client updateClient(Client client)  throws SQLException {
        if (isValid(client)){
            repository.updateClient(client);
            System.out.println("Client with id " + client.getId() + " has been updated!");
            return client;
        }
        return null;
    }

    public void deleteClient(int id) throws SQLException {
        if(repository.searchClientsById(id) != null){
            repository.deleteClient(id);
        }
    }

    public boolean isValid(Client client) {
        if(client.getName() == null){
            System.err.println("Error: Client name is empty!");
            return false;
        }else if(client.getCpf() == null){
            System.err.println("Error: Client CPF is empty!");
            return false;
        }else if(client.getCpf().length() != 11){
            System.err.println("Error: Client CPF have an invalid length! (11)");
            return false;
        }else if(!client.getEmail().contains("@gmail.com") &&
                 !client.getEmail().contains("@yahoo.com") &&
                 !client.getEmail().contains("@hotmail.com")){
            System.err.println("Error: Client email address is not valid!");
            return false;
        }else if(client.getCellphoneNumber().length() > 15){
            System.err.println("Error: Client cellphone number is longer than 15 characters!");
            return false;
        }
        return true;
    }
}
