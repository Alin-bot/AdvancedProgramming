package com.compulsory;

import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) {
        try (var fos = new FileOutputStream(catalog.getPath());
             var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(catalog);
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } finally {
            System.out.println("Saved successfully!");
            System.out.println();
        }
    }

    public static Catalog load(String file) {
        Catalog catalog = null;
        try (var fis = new FileInputStream(file);
             var ois = new ObjectInputStream(fis)) {
            catalog = (Catalog)ois.readObject();
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Problem with the catalog class!");
        } finally {
            System.out.println("Loaded successfully!");
            System.out.println();
        }
        return catalog;
    }
}

