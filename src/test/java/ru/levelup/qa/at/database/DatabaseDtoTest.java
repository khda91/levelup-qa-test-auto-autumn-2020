package ru.levelup.qa.at.database;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.database.model.PhoneBookDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDtoTest {

    private Connection connection;

    @BeforeMethod
    public void setUp() {
        connection = PostgresqlDatabaseConnection.getInstance().getConnection();
    }

    @Test
    public void testGetDataFromDatabase() {
        List<PhoneBookDto> list = new ArrayList<>();
        final String SELECT_SQL = "SELECT * FROM \"PHONE_BOOK\"";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_SQL);
            while (resultSet.next()) {
                PhoneBookDto dto = new PhoneBookDto();
                dto.setId(resultSet.getInt("id"));
                dto.setFirstName(resultSet.getString(2));
                dto.setLastName(resultSet.getString("last_name"));
                dto.setEmail(resultSet.getString(4));
                dto.setPhone(resultSet.getObject(5) == null ? null : resultSet.getInt(5));
                list.add(dto);
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
        System.out.println(list);
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
