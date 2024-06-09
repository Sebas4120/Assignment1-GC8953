package ca.georgiancollege.assignment1gc8953;

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

}
