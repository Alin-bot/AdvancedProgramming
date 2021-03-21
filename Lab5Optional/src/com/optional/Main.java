package com.optional;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Main app = new Main();
        app.testCreateSave();
        //app.testLoadView();

        Shell c1 = new Shell();
        c1.getShelled();
    }

    private void testCreateSave() throws InvalidCatalogException {
        Catalog catalog = new Catalog("Album", ".\\copy.txt");
        var song = new Song("1", "Neon_Decapod", ".\\Neon Decapod.mp3" );
        var image = new Image("2", "requirement", ".\\requirement.png" );
        catalog.add(song);
        catalog.add(image);
        //catalog.play("Neon_Decapod");
        //catalog.play("requirement");

        CatalogUtil.save(catalog);
    }

    private void testLoadView() {
        Catalog catalog = CatalogUtil.load(".\\copy.txt");
        CatalogUtil.view(catalog.findById("1"));
    }
}