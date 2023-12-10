package org.example;

import java.sql.*;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306/testgpt2";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    public static final String nameSchema = "juniorlesson4";
    public static final String nameTable = "person_table";

    public static void connectionSQL() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();

            // создаем schema
            statement.execute("DROP SCHEMA " + nameSchema); // удаляем если есть
            String sql = "CREATE SCHEMA " + nameSchema;  // создаем schema
            statement.executeUpdate(sql);

            // создаем таблицу
            String sqlCreateTable = "CREATE TABLE " + nameSchema + "." + nameTable + " ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "firstname VARCHAR(45),"
                    + "lastname VARCHAR(45),"
                    + "PRIMARY KEY(id)"
                    + ");";
            statement.execute(sqlCreateTable);

            // создаем таблицу данными
//            String insertDataQuery = "INSERT INTO " + nameSchema + ".table" +
//                    "(id, firstname, lastname) VALUES (3, 'Ivan', 'Ivanov')";
//            statement.execute(insertDataQuery);
//            String insertDataQuery = "INSERT INTO " + nameSchema + ".table" +
//                    "(id, firstname, lastname) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);
//            // Первая запись
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "John");
//            preparedStatement.setString(3, "Doe");
//            preparedStatement.executeUpdate();
//            // Вторая запись
//            preparedStatement.setInt(1, 2);
//            preparedStatement.setString(2, "Jane");
//            preparedStatement.setString(3, "Smith");
//            preparedStatement.executeUpdate();

            // print all
//            String printAll = "SELECT * FROM " + nameSchema + ".table;";
//            ResultSet resultSet = statement.executeQuery(printAll);
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1)
//                        + " " + resultSet.getString(2)
//                        + " " + resultSet.getString(3));
//            }


            // смотрим все schemas
//            DatabaseMetaData metaData = connection.getMetaData();
//            ResultSet resultSet2 = metaData.getCatalogs();
//            while (resultSet2.next()) {
//                String databaseName = resultSet2.getString("TABLE_CAT");
//                System.out.println("Database name: " + databaseName);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
