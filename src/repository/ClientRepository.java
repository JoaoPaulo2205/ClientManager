package repository;

import model.Client;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public void save(Client client) throws SQLException{
        String query = "INSERT INTO client (name, email, cellphone, cpf) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString (1, client.getName());
            preparedStatement.setString (2, client.getEmail());
            preparedStatement.setString (3, client.getCellphoneNumber());
            preparedStatement.setString (4, client.getCpf());
            preparedStatement.executeUpdate();
        }

    }

    public List<Client> searchClients() throws SQLException {
        String query = "SELECT * FROM client ORDER BY id ASC";
        List<Client> clients = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client c = new Client();
                c.setId(resultSet.getInt("id"));
                c.setName(resultSet.getString("name"));
                c.setCpf(resultSet.getString("cpf"));
                c.setEmail(resultSet.getString("email"));
                c.setCellphoneNumber(resultSet.getString("cellphone"));
                clients.add(c);
            }
        }
        return clients;
    }

    public Client searchClientsById(int id) throws SQLException {
        String query = "SELECT * FROM client WHERE id = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setInt(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                Client c = new Client();
                c.setId(resultSet.getInt("id"));
                c.setName(resultSet.getString("name"));
                c.setEmail(resultSet.getString("email"));
                c.setCellphoneNumber(resultSet.getString("cellphone"));
                c.setCpf(resultSet.getString("cpf"));
                return c;
             }
        }
        return null;
    }

    public void deleteClient(int id) throws SQLException {
        String query = "DELETE FROM client WHERE id = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
                 preparedStatement.setInt(1, id);
                 preparedStatement.execute();
        }
    }

    public void updateClient(Client client) throws SQLException {
        String query = "UPDATE client SET name = ?, email = ? , cellphone = ?, cpf = ? where id = ?";
        try (Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString (1, client.getName());
            preparedStatement.setString (2, client.getEmail());
            preparedStatement.setString (3, client.getCellphoneNumber());
            preparedStatement.setString (4, client.getCpf());
            preparedStatement.setInt(5, client.getId());
            preparedStatement.executeUpdate();
        }
    }
}
