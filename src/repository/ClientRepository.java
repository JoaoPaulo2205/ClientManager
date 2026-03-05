package repository;

import model.Client;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepository {

    public void salvar(Client client) throws SQLException{
        String query = "INSERT INTO client (name, email, cellphone, cpf) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString (1, client.getName());
            preparedStatement.setString (2, client.getEmail());
            preparedStatement.setString (3, client.getCellphoneNumber());
            preparedStatement.setString (4, client.getCpf());
            preparedStatement.execute();
        }

    }
}
