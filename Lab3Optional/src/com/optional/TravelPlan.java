package com.optional;

import java.util.ArrayList;
import java.util.Scanner;

public class TravelPlan {

    private City city;
    private ArrayList<Integer> preferences;

    public TravelPlan(City city) {
        this.city = new City();
        this.city = city;
        this.preferences = new ArrayList<Integer>();

        Scanner keyboard = new Scanner(System.in);
        for (Location i : city.getNodes()) {
            System.out.print("The location '" + i.getName() + "' will have the preference: ");
            this.preferences.add(keyboard.nextInt());
        }
    }

    public ArrayList<Integer> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Integer> preferences) {
        this.preferences = preferences;
    }

}
