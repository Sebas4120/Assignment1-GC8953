package ca.georgiancollege.assignment1gc8953;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Province {

    private String year;
    private int population,id;

    public Province() {}

    public Province(int id, String year, int population) {
        this.id = id;
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

    public static List<Province> getOntarioData(){
        List<Province> provinces = new ArrayList<>();

        String query = "SELECT Year, Population FROM ONTARIO";

        try{
            ResultSet resultSet = db.queryResult(query);

            while (resultSet.next()){
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("Population");
                Province province = new Province(0, year, population);  // Assuming id is not used
                provinces.add(province);
            }

            resultSet.close();
        }catch(SQLException e){
            System.err.println(e);
        }

        return provinces;
    }

}
