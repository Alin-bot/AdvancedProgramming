package com.compulsory;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main{

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {

        Class clazz = null;

        File file = new File("C:\\");

        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        ClassLoader cl = new URLClassLoader(urls);

        Class  cls = cl.loadClass("com.compulsory.MyTest");

        try {
            clazz = Class.forName("com.compulsory.MyTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("The " + clazz.getPackage());
        for (Method m : clazz.getMethods()) {
            System.out.println(m.getName());
        }
    }
}
