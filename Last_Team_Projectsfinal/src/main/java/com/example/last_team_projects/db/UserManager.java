package com.example.last_team_projects.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.last_team_projects.db.models.User;


public class UserManager {
    Connector connector = new Connector();

    public UserManager() {
        this.initTable();
    }

    public void initTable() {
        Connection connection = null;
        String query = "" +
                "CREATE TABLE IF NOT EXISTS users(" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "username VARCHAR(100) UNIQUE, " +
                "phone VARCHAR(20) NOT NULL, " +
                "password VARCHAR(100) NOT NULL " +
                ");";
        try {
            connection = connector.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Failed to initialize users table");
            System.out.println(e.getMessage());
            if (connection != null) {
                connector.closeConnection(connection);
            }
            throw new RuntimeException(e);
        }
    }

    public User getUser(String username, String password) {
        Connection connection = null;
        try {
            connection = connector.getConnection();
            String query = "SELECT id, name, username, phone, password FROM users " +
                    "WHERE username = ? and password = ? LIMIT 1;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet results = statement.executeQuery();
            User user = null;
            while (results.next()) {
                user = new User(
                        results.getInt(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5)
                );
            }
            return user;
        }
        catch (SQLException e) {
            System.out.println("Failed to get user");
            System.out.println(e.getMessage());
        }
        finally {
            if (connection != null) {
                connector.closeConnection(connection);
            }
        }
        return null;
    }

    public User addUser(User user) {

        return user;
    }

}
