package com.optional;

//has a rank and is visitable because you can enter it
public class Hotel extends Location implements Classifiable {

    private double rank;

    @Override
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
