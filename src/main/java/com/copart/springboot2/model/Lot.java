package com.copart.springboot2.model;

public class Lot {

    private String make;

    private String model;

    private int year;

    private String description;

    public Lot(String make, String model, int year, String description) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.description = description;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
