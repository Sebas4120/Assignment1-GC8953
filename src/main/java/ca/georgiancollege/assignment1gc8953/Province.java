package ca.georgiancollege.assignment1gc8953;

public class Province {

    private String year;
    private int population;

    public Province() {}

    public Province(String year, int population) {
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

}
