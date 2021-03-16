package com.compulsory;

public class Main {

    public static void main(String[] args) throws InvalidCatalogException {


        Catalog catalog = new Catalog("Album",".\\copy.txt");

        Song s = new Song("1","Neon_Decapod",".\\Neon Decapod.mp3");
        catalog.add(s);
        catalog.list();
        Image m = new Image("2","requirement",".\\requirement.png");
        catalog.add(m);
        catalog.list();

        //catalog.play("Neon_Decapod");
        //catalog.play("requirement");

        CatalogUtil.save(catalog);

        Catalog nou = new Catalog("NewAlbum",".\\copy2.txt");
        System.out.println("The old name: " + nou.getCatalogName());
        nou = CatalogUtil.load("copy.txt");
        nou.list();
    }
}
