package com.example.last_team_projects.db;

import java.sql.*;

public class Connector {
    private Connection connection = null;
    private String dbURL = null;
    private String dbUser = null;
    private String dbPassword = null;

    public Connector() {
        this.dbURL = "jdbc:mysql://localhost:3306/last_team_project";
        this.dbUser = "library_db_user";
        this.dbPassword = "12345678";
    }

    private void establishNewConnection() throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    public Connection getConnection() throws  SQLException {
        if (this.connection == null) {
            this.establishNewConnection();
        }
        return this.connection;
    }


    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
        if (this.connection != null) {
            this.connection.close();
            this.connection = null;
        }
    }
}
