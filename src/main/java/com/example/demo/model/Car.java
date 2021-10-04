package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private int id;
    private String name;
    private int year;
    private String color;

    public Car(int id, String name, int year, String color) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
    }

    public Car() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
