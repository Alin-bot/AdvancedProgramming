package com.optional;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws InvalidCatalogException {
        Catalog catalog = new Catalog("Album", ".\\copy.txt");
        var song = new Song("1", "Neon_Decapod", ".\\Neon Decapod.mp3" );
        var image = new Image("2", "requirement", ".\\requirement.png" );
        catalog.add(song);
        catalog.add(image);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() {
        Catalog catalog = CatalogUtil.load(".\\copy.txt");
        CatalogUtil.view(catalog.findById("1"));
    }
}