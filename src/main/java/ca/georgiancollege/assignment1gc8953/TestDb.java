package ca.georgiancollege.assignment1gc8953;

import java.sql.*;
public class TestDb {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://database-1" +
                            ".cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306/COMP1011", "admin",
                    "Narangita412.");

            //This statements is to add a new row to the table
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
                int year = resultSet.getInt("Year");
                int population = resultSet.getInt("Population");

                System.out.println(id);
                System.out.println(year);
                System.out.println(population);
                System.out.println("*".repeat(20));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}