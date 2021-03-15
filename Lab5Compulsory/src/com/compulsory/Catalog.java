package com.compulsory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private final String catalogName;
    private final List<Item> itemList = new ArrayList<>();

    public Catalog(String catalogName) {
        this.catalogName = catalogName;
    }

    public void add(Item entry) {
        itemList.add(entry);
    }

    public void list() {
        System.out.print("The catalog " + catalogName + " has the items: ");
        for (Item t : itemList) {
            System.out.print(t.getName() + " ");
        }
        System.out.println();
    }

    public void play(Item entry) {
        File f = null;
        for (int i = 0; i < itemList.size(); i ++){
            if (itemList.get(i) == entry){
                f = new File(entry.getPath());
            }
        }
        try {
            if (f.exists()) {
                Desktop.getDesktop().open(f);
            }
        } catch (IOException e) {
            System.out.println("Error at playing!");
            e.printStackTrace();
        }
    }
}
