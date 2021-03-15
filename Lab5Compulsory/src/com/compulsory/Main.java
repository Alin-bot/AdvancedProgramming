package com.compulsory;

public class Main {

    public static void main(String[] args) {

        Catalog c = new Catalog("Album");
        Item t = new Item("SuperSong", "Songs");
        Item y = new Item("Another song", "Songs");
        c.add(t);
        c.list();
        c.add(y);
        c.list();

        c.play(t);
    }
}
