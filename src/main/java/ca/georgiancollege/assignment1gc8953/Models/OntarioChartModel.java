package ca.georgiancollege.assignment1gc8953.Models;

import ca.georgiancollege.assignment1gc8953.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OntarioChartModel {

    private String year;
    private int population,id;

    public OntarioChartModel() {}

    public OntarioChartModel(int id, String year, int population) {
        this.id = id;
        this.year = year;
        this.population = population;
    }

    public OntarioChartModel(String year, int population) {
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

    public static List<OntarioChartModel> getOntarioData(){
        List<OntarioChartModel> ontarioChartModels = new ArrayList<>();

        String query = "SELECT Year, Population FROM ONTARIO";

        try{
            ResultSet resultSet = db.queryResult(query);

            while (resultSet.next()){
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("Population");
                OntarioChartModel ontarioChartModel = new OntarioChartModel(year, population);
                // Assuming id is not used
                ontarioChartModels.add(ontarioChartModel);
            }

            resultSet.close();
        }catch(SQLException e){
            System.err.println(e);
        }

        return ontarioChartModels;
    }

    public static List<OntarioChartModel> getOntarioData2(){
        List<OntarioChartModel> ontarioChartModels = new ArrayList<>();

        String query = "SELECT * FROM ONTARIO";

        try{
            ResultSet resultSet = db.queryResult(query);

            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("Population");
                OntarioChartModel ontarioChartModel = new OntarioChartModel(id,year, population);
                // Assuming id is not used
                ontarioChartModels.add(ontarioChartModel);
            }

            resultSet.close();
        }catch(SQLException e){
            System.err.println(e);
        }

        return ontarioChartModels;
    }

}
