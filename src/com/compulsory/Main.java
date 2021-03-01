package com.compulsory;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9, 30)); //9:30
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        m.setRank(8.75);

        Church c = new Church();
        c.setOpeningTime(LocalTime.of(7, 0));
        c.setClosingTime(LocalTime.MIDNIGHT);

        Hotel v1 = new Hotel();
        Museum v2 = new Museum();
        Museum v3 = new Museum();
        Church v4 = new Church();
        Restaurant v6 = new Restaurant();

        Visitable[] arr = {m, c};
    }
}
