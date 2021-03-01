package com.compulsory;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Playable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    private double rank;

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

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int i) {
        this.ticketPrice = i;
    }

    @Override
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
