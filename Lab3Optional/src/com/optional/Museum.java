package com.optional;

//has a rank and is visitable because you can enter it, and payable because it requires money to enter
public class Museum extends Location implements Payable, Classifiable {

    private double ticketPrice;
    private double rank;

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
