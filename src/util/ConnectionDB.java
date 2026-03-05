package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private static final Properties props = carregarProps();

    private static Properties carregarProps() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar config.properties: " + e.getMessage());
        }
        return p;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("DB_URL"),
                props.getProperty("DB_USER"),
                props.getProperty("DB_PASSWORD")
        );
    }

}
