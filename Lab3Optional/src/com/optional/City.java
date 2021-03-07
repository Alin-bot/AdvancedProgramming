package com.optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class City {

    String cityName;
    private List<Location> nodes = new ArrayList<>();
    private List<Location> freeLocations = new ArrayList<>();

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public void isFreeToVisit() {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Visitable && !(nodes.get(i) instanceof Payable)){ // if they are visitable and not payable
                freeLocations.add(nodes.get(i));    // add them to a new list so we can sort them
            }
        }
        System.out.println("Locations that are Visitable and not Payable: " + freeLocations);
        Collections.sort(freeLocations);    // sorting by opening hours
        System.out.println("Locations after sorting them by openingTime: " + freeLocations);
    }
}
