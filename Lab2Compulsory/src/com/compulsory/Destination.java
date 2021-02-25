package com.compulsory;

public class Destination {
    int commodity;
    String name;

    public int getCommodity() {
        return commodity;
    }

    public void setCommodity(int commodity) {
        this.commodity = commodity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination(int commodity, String name) {
        this.commodity = commodity;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println(name + " " + commodity);
    }
}
