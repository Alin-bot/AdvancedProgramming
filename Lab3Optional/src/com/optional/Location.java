package com.optional;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location>, Visitable { // all locations are visitable because they have an timetable

    private String name;
    private Map<Location, Integer> cost = new HashMap<>();
    protected LocalTime openingTime, closingTime;

    public Location() {
        openingTime = makeDefaultOpeningTime();
        closingTime = makeDefaultClosingTime(); // we assign the default opening and closing hours to every new location that we make
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Location other) {
        return this.openingTime.compareTo(other.openingTime);
    } // using compare to so we can sort our locations by opening time

    @Override
    public String toString() {
        return name;
    }
}
