package ru.levelup.qa.at.database;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostgresqlDatabaseConnectionTest {

    @Test
    public void testName() {
        Connection connection = PostgresqlDatabaseConnection.getInstance().getConnection();
        try {
            System.out.println("Connection closed: " + connection.isClosed());
            assertThat(connection.isClosed(), equalTo(false));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        Connection connection = PostgresqlDatabaseConnection.getInstance().getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
