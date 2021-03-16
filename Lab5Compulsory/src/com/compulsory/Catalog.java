package com.compulsory;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String catalogName;
    private String path;
    private List<Item> itemList;

    public Catalog(String catalogName, String path) throws InvalidCatalogException {
        this.itemList = new ArrayList<>();

        if (catalogName == null || catalogName.replaceAll("\\s", "").isEmpty())
            throw new InvalidCatalogException("Error: the catalog's name is empty!");
        this.catalogName = catalogName;

        if (path == null || path.replaceAll("\\s", "").isEmpty())
            throw new InvalidCatalogException("Error: the catalog's path is empty!");
        this.path = path;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getPath() {
        return path;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public void list() {
        System.out.println("The catalog " + catalogName + " has: ");
        for (Item t : itemList) {
            System.out.println("- the " + t.getClass().getSimpleName() + ": " + t.getName() + ";");
        }
        System.out.println();
    }

    public void play(String name) {
        File f = null;
        for (Item item : itemList) {
            if (item.getName().equals(name)) {
                f = new File(String.valueOf(item.getPath()));
            }
        }
        try {
            if (f.exists()) {
                Desktop.getDesktop().open(f);
            }
        } catch (IOException e) {
            System.out.println("The music does not exists!");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return catalogName;
    }
}