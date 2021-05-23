package com.bonus;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // get number of nodes
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number of nodes: ");
        int nodes = scan.nextInt();

        // random root
        Random rand = new Random();
        int root = rand.nextInt(nodes);
        System.out.println("The root: " + root);

        // array of sons
        String[] array = new String[nodes];
        Arrays.fill(array, "no");
        array[root] = "root";

        int[] availableRoots = new int[nodes];
        int roots = 0;
        availableRoots[roots] = root;

        // give dads to nodes if they are not roots
        for (int i = 0; i < nodes; i++) {
            if (array[i].equals("no")) {
                array[i] = String.valueOf(availableRoots[rand.nextInt((roots + 1))]);
                availableRoots[++roots] = i;
            }
        }

        displayTree(array, root, "");
    }
    public static void displayTree(String[] array, int root, String space){
        System.out.println(space + "+node" + root);
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(String.valueOf(root))) {
                space += "  ";
                displayTree(array, i, space);
            }
        }
    }
}