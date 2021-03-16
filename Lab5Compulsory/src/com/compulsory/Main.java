package com.compulsory;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Catalog c = new Catalog("Album");

        Song s = new Song("Neon_Decapod", Paths.get(".\\Neon Decapod.mp3"));
        c.add(s);
        c.list();
        Image m = new Image("requirement", Paths.get(".\\requirement.png"));
        c.add(m);
        c.list();

        //c.play("Neon_Decapod");
        //c.play("requirement");

        Catalog nou = new Catalog("NewAlbum");
        System.out.println("Name of the new catalog: " + nou.getCatalogName());
        nou.load("copy.txt");
        System.out.println("Name of the new catalog after upload: " + nou.getCatalogName());
        System.out.println("The list of the new catalog: " + nou.getItemList());

    }
}
