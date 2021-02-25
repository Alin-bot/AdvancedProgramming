package com.compulsory;

public class Source {
    int capacity;
    String name;
    SourceType type;
    public enum SourceType {
        WAREHOUSE, FACTORY
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Source(int capacity, String name, SourceType type) {
        this.capacity = capacity;
        this.name = name;
        this.type = type;
    }

    public void displayInfo() {
        System.out.println(name + " " + capacity + " " + type);
    }
}
