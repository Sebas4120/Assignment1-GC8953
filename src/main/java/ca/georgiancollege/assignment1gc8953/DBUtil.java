package ca.georgiancollege.assignment1gc8953;

import java.sql.*;

public class DBUtil {
    //DBUtil is the class that will connect to the database



    //Connection String
    //Username
    //password
    //database

    private String connectionString, username , password, database;
    private String table;

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;


    public DBUtil (String database){
        this.database = database;
        connectionString = "jdbc:mysql://database-1.cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306";
        username = "admin";
        password = "Narangita412.";

        try{
            //Trying to connect with the database
            connection = DriverManager.getConnection
                    (connectionString + "/" + database,username,password);
        }catch (Exception e){
            System.err.println(e);
        }
    }

    //Getters and Setters
    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    //Create a Statement and execute the SQL query using statement.execute(sql)
    //This method is used to execute queries that do not return results (INSERT, UPDATE, DELETE).
    public void queryExec(String sql) throws Exception{
        statement = connection.createStatement();
        statement.execute(sql);
    }


    //Creates a PreparedStatement and executes the SQL query using preparedStatement.executeQuery().
    //This method is used to execute queries that return results (SELECT).
    public ResultSet queryResult (String sql) throws SQLException{
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();

    }




}