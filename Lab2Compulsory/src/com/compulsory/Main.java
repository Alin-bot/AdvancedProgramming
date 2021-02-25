package com.compulsory;

public class Main {


    public static void main(String[] args) {

        Source S1 = new Source(10, "S1", Source.SourceType.FACTORY);
        Source S2 = new Source(35, "S2", Source.SourceType.WAREHOUSE);
        Source S3 = new Source(25, "S3", Source.SourceType.WAREHOUSE);

        Destination D1 = new Destination(20, "D1");
        Destination D2 = new Destination(25, "D2");
        Destination D3 = new Destination(25, "D3");

        D1.displayInfo();
        D2.displayInfo();
        D3.displayInfo();

        S1.displayInfo();
        S2.displayInfo();
        S3.displayInfo();

        Problem P1 = new Problem(3);
        new Problem(0, 0, 2);
        new Problem(0, 1, 3);
        new Problem(0, 2, 1);
        new Problem(1, 0, 5);
        new Problem(1, 1, 4);
        new Problem(1, 2, 8);
        new Problem(2, 0, 5);
        new Problem(2, 1, 6);
        new Problem(2, 2, 8);
        P1.displayMatrix();

    }
}
