package com.compulsory;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String catalogName;
    private transient List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public Catalog(String catalogName) {
        this.catalogName = catalogName;
    }

    public void add(Item entry) {
        itemList.add(entry);
    }

    public void list() {
        System.out.print("The catalog " + catalogName + " has the items: ");
        for (Item t : itemList) {
            System.out.print(t.getName() + "; ");
        }
        System.out.println();
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

    public void save(Catalog catalog) throws IOException {
        FileOutputStream fos = new FileOutputStream("copy.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(catalog);
        oos.flush();
        fos.close();
        System.out.println("Saved successfully!");
        System.out.println();
    }

    public void load(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Catalog catalog = (Catalog)ois.readObject();
        this.catalogName = catalog.catalogName;
        this.itemList = catalog.itemList;
        fis.close();
        System.out.println("Loaded successfully!");
        System.out.println();
    }
}
