package ca.georgiancollege.assignment1gc8953.Models;

import ca.georgiancollege.assignment1gc8953.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OntarioModel {

    private String year;
    private int population,id;

    public OntarioModel() {}

    public OntarioModel(int id, String year, int population) {
        this.id = id;
        this.year = year;
        this.population = population;
    }

    public OntarioModel(String year, int population) {
        this.year = year;
        this.population = population;
    }

    public String getYear() {
        return year;
    }

    public int getPopulation() {
        return population;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    private static DBUtil db = new DBUtil("COMP1011");

    public static List<OntarioModel> getOntarioData(){
        List<OntarioModel> ontarioModels = new ArrayList<>();

        String query = "SELECT Year, Population FROM ONTARIO";

        try{
            ResultSet resultSet = db.queryResult(query);

            while (resultSet.next()){
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("Population");
                OntarioModel ontarioModel = new OntarioModel(year, population);
                // Assuming id is not used
                ontarioModels.add(ontarioModel);
            }

            resultSet.close();
        }catch(SQLException e){
            System.err.println(e);
        }

        return ontarioModels;
    }

    public static List<OntarioModel> getOntarioData2(){
        List<OntarioModel> ontarioModels = new ArrayList<>();

        String query = "SELECT * FROM ONTARIO";

        try{
            ResultSet resultSet = db.queryResult(query);

            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("Population");
                OntarioModel ontarioModel = new OntarioModel(id,year, population);
                // Assuming id is not used
                ontarioModels.add(ontarioModel);
            }

            resultSet.close();
        }catch(SQLException e){
            System.err.println(e);
        }

        return ontarioModels;
    }

}
