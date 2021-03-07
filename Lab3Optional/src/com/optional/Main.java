package com.optional;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        City c = new City("Iasi"); // making the city

        // making the locations that we want
        Hotel v1 = new Hotel();
        v1.setRank(8.5);    //rank 8.5
        v1.setOpeningTime(LocalTime.of(6, 0));
        v1.setClosingTime(LocalTime.MIDNIGHT);
        v1.setName("Hotel");

        Museum v2 = new Museum();
        v2.setOpeningTime(LocalTime.of(8, 30));
        v2.setClosingTime(LocalTime.of(20,0));
        v2.setTicketPrice(20);
        v2.setRank(9);
        v2.setName("Museum A");

        Museum v3 = new Museum();
        v3.setOpeningTime(LocalTime.of(8, 30));
        v3.setClosingTime(LocalTime.of(21,0));
        v3.setTicketPrice(25);
        v3.setRank(9.1);
        v3.setName("Museum B");

        Church v4 = new Church();
        v4.setOpeningTime(LocalTime.of(6, 30));
        v4.setClosingTime(LocalTime.of(19,0));
        v4.setName("Church A");

        Church v5 = new Church();
        v5.setOpeningTime(LocalTime.of(6, 0));
        v5.setClosingTime(LocalTime.of(18,0));
        v5.setName("Church B");

        Restaurant v6 = new Restaurant(); // for 'Restaurant' we will let the default method to assign the opening and closing hours
        v6.setRank(9.4);
        v6.setName("Restaurant");

        c.addLocation(v1); // adding the locations to our city
        c.addLocation(v2);
        c.addLocation(v3);
        c.addLocation(v4);
        c.addLocation(v5);
        c.addLocation(v6);

        v1.setCost(v2, 10); // setting the costs
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v4, 30);
        v5.setCost(v6, 20);

        c.isFreeToVisit(); // checking what locations are visitable and not payable

        System.out.println("The location 'Restaurant' has the default time of: " + v6.openingTime + " - " + v6.closingTime);
        System.out.println("The location 'Restaurant' is opened during a day for: " + Visitable.getVisitedDuration(v6));

        TravelPlan t = new TravelPlan(c);
    }
}
