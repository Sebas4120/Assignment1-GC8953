package ca.georgiancollege.assignment1gc8953;

import java.sql.*;
public class TestDb {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://database-1" +
                            ".cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306/COMP1011", "admin",
                    "Narangita412.");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                    "ONTARIO(Year,Population) VALUES(?,?)");

            //this is going to add an aditional row to the table
            preparedStatement.setInt(1, 2024);
            preparedStatement.setInt(2, 16985641);

            preparedStatement.execute();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ONTARIO");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String year = resultSet.getString("Year");
                String population = resultSet.getString("Population");

                System.out.println(id);
                System.out.println(year);
                System.out.println(population);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}