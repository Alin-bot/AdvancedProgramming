package com.optional;

//has a rank and is visitable because you can enter it
public class Restaurant extends Location implements Classifiable {

    public double rank;

    @Override
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
