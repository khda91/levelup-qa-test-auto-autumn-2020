package ru.levelup.qa.at.database;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {

    private Connection connection;

    @BeforeMethod
    public void setUp() {
        connection = PostgresqlDatabaseConnection.getInstance().getConnection();
    }

    @Test
    public void testGetDataFromDatabase() {
        final String SELECT_SQL = "SELECT * FROM \"PHONE_BOOK\"";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_SQL);
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("first_name: " + resultSet.getString(2));
                System.out.println("last_name: " + resultSet.getString("last_name"));
                System.out.println("email: " + resultSet.getString(4));
                System.out.println("phone: " + resultSet.getInt(5));
                System.out.println("=======");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCreateDataInDatabase() {
        final String INSERT_SQL = "INSERT INTO \"PHONE_BOOK\" (first_name, last_name, email) VALUES (?, ?, ?)";
        final String SELECT_SQL = "SELECT * FROM \"PHONE_BOOK\"";

        PreparedStatement insertStatement = null;
        Statement selectStatement = null;
        try {
            insertStatement = connection.prepareStatement(INSERT_SQL);
            insertStatement.setString(1, "Петя");
            insertStatement.setString(2, "Васечкин");
            insertStatement.setString(3, "vasechkin@pupkin.io");
            insertStatement.execute();

            selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(SELECT_SQL);
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("first_name: " + resultSet.getString(2));
                System.out.println("last_name: " + resultSet.getString("last_name"));
                System.out.println("email: " + resultSet.getString(4));
                System.out.println("phone: " + (resultSet.getObject(5) == null ? null : resultSet.getInt(5)));
                System.out.println("=======");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (insertStatement != null) {
                try {
                    insertStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
