package org.example;

import java.sql.*;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "enterPassword";
    public static final String nameSchema = "juniorlesson4";
    public static final String nameTable = "person_table";

    public static void connectionSQL() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();

            //createSchemaDB(statement);

            //createTableDB(statement);

            fillData(statement);

            fillArrayData(connection);

            printDB(statement);

            printSchemaDB(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // создаем schema
    public static void createSchemaDB(Statement statement) throws SQLException {
        statement.execute("DROP SCHEMA " + nameSchema); // удаляем если есть
        String sql = "CREATE SCHEMA " + nameSchema;  // создаем schema
        statement.executeUpdate(sql);
    }

    // создаем таблицу
    public static void createTableDB(Statement statement) throws SQLException {
        String sqlCreateTable = "CREATE TABLE " + nameSchema + "." + nameTable + " ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "firstname VARCHAR(45),"
                + "lastname VARCHAR(45),"
                + "PRIMARY KEY(id)"
                + ");";
        statement.execute(sqlCreateTable);
    }

    // заполняем данными
    public static void fillData(Statement statement) throws SQLException {
        String insertDataQuery = "INSERT INTO " + nameSchema + "." + nameTable +
                " (id, firstname, lastname) VALUES (3, 'Ivan', 'Ivanov')";
        statement.execute(insertDataQuery);
    }

    // заполняем несколькими данными
    public static void fillArrayData(Connection connection) throws SQLException {
        String insertDataQuery = "INSERT INTO " + nameSchema + "." + nameTable +
                " (id, firstname, lastname) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);
        // Первая запись
        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, "John");
        preparedStatement.setString(3, "Doe");
        preparedStatement.executeUpdate();
        // Вторая запись
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Jane");
        preparedStatement.setString(3, "Smith");
        preparedStatement.executeUpdate();
    }

    public static void printDB(Statement statement) throws SQLException {
        String printAll = "SELECT * FROM " + nameSchema + "." + nameTable + ";";
        ResultSet resultSet = statement.executeQuery(printAll);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)
                    + " " + resultSet.getString(2)
                    + " " + resultSet.getString(3));
        }
    }

    // смотрим все schemas
    public static void printSchemaDB(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet2 = metaData.getCatalogs();
        while (resultSet2.next()) {
            String databaseName = resultSet2.getString("TABLE_CAT");
            System.out.println("Database name: " + databaseName);
        }
    }

}
