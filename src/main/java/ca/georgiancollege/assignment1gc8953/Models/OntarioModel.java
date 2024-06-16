package ca.georgiancollege.assignment1gc8953.Models;

import ca.georgiancollege.assignment1gc8953.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OntarioModel {

    //Variables
    private String year;
    private int population,id,male,female;


    //Validation method for year
    public void validationString(String title, String data){
        if(Integer.parseInt(data) >1600 && Integer.parseInt(data) < 2025){
            throw new IllegalArgumentException(title + " is not a valid year. " +
                    "It has to be between 1600 and 2025");        }

    };

    //Validation method for population and Id
    public void validationInteger(String title, int data){
        if(data < 0){
            throw new IllegalArgumentException(title + " is not a valid population. " +
                    "It has to be a positive number");        }

    };


    public OntarioModel() {}

    //Constructor for the Table
    public OntarioModel(int id, String year, int population, int male, int female) {
        this.id = id;
        this.year = year;
        this.population = population;
        this.male=male;
        this.female=female;
    }

    //Constructor for the Chart
    public OntarioModel(String year, int population) {
        this.year = year;
        this.population = population;
    }

    //Getters and Setters
    public String getYear() {
        return year;
    }

    public int getPopulation() {
        return population;
    }

    public void setYear(String year) {
        validationString("Year", year);
        this.year = year;
    }

    public void setPopulation(int population) {
        validationInteger("Population", population);
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        validationInteger("ID", id);
        this.id = id;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        validationInteger("Male", male);
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        validationInteger("Female", female);
        this.female = female;
    }

    private static DBUtil db = new DBUtil("COMP1011");

    //To create the chart of the population TOTAL
    //Objective: get data from DB and save it into a object list 'ontarioModels'
    public static List<OntarioModel> getOntarioData(){
        //Create a list of OntarioModel
        List<OntarioModel> ontarioModels = new ArrayList<>();

        //Query to get data from DB
        String query = "SELECT Year, Population FROM ONTARIO";

        try{
            //Executes the SQL query using a queryResult method that returns a ResultSet.
            //ResultSet is an interface that represents a set of results of a database query.
            ResultSet resultSet = db.queryResult(query);

            //used to iterate over each row of the ResultSet.
            //resultSet.next(): moves the cursor to the next row in the ResultSet and returns false
            // when there are no more rows.
            while (resultSet.next()){
                //gets the value of the YEAR column of the current row as a string.
                String year = resultSet.getString("YEAR");
                //gets the value of the Population column of the current row as an integer.
                int population = resultSet.getInt("Population");
                //creates a new instance of OntarioModel with the obtained data.
                OntarioModel ontarioModel = new OntarioModel(year, population);
                //adds the OntarioModel object to the ontarioModels list.
                ontarioModels.add(ontarioModel);
            }
            //closes the ResultSet to free the resources.
            resultSet.close();

        //catches any SQLException that may occur during the execution of the code.
        }catch(SQLException e){
            System.err.println(e);
        }

        //Returns the ontarioModels list containing all OntarioModel objects
        // created from the data retrieved from the database.
        return ontarioModels;
    }

    //To create the Table of the population
    public static List<OntarioModel> getOntarioData2(){
        //Create a list of OntarioModel
        List<OntarioModel> ontarioModels = new ArrayList<>();

        //Query to get data from DB
        String query = "SELECT * FROM ONTARIO";

        //Same methodology as before
        try{
            ResultSet resultSet = db.queryResult(query);

            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("Population");
                int male = resultSet.getInt("Male");
                int female = resultSet.getInt("Female");
                OntarioModel ontarioModel = new OntarioModel(id,year, population,male,female );
                ontarioModels.add(ontarioModel);
            }

            resultSet.close();

        }catch(SQLException e){
            System.err.println(e);
        }

        return ontarioModels;
    }

}
