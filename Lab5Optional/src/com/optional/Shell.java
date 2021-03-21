package com.optional;

import java.io.*;

public class Shell {

    public void getShelled () throws IOException {

        String commandLine;
        BufferedReader console = new BufferedReader
                (new InputStreamReader(System.in));

        while (true) {
            System.out.print("shell>");
            commandLine = console.readLine();

            if (commandLine.equals(""))
                continue;
            if (commandLine.equals("help")) {
                System.out.println("Commands to use:");
                System.out.println("1) help");
                System.out.println("2) exit");
                System.out.println("3) clear");
                System.out.println("4) add");
                System.out.println("5) play");
                System.out.println("6) save");
                System.out.println("7) list");
                System.out.println("8) load");
            }
            if (commandLine.equals("clear")) {
                for (int cls = 0; cls < 20; cls++)
                    System.out.println();
            }
            if (commandLine.equals("exit")) {
                System.out.println("...Exiting...");
                System.exit(0);
            }

            if (commandLine.equals("play")) {
                System.out.print("Type the catalog: ");
                commandLine = console.readLine();

            }
            if (commandLine.equals("list")) {
                System.out.print("Type the name: ");
                commandLine = console.readLine();

            }
            if (commandLine.equals("load")) {
                System.out.print("Type the path: ");
                commandLine = console.readLine();

            }
            if (commandLine.equals("save")) {
                System.out.print("Type the catalog: ");
                commandLine = console.readLine();

            }
            if (commandLine.equals("add")) {
                System.out.print("Type the item: ");
                commandLine = console.readLine();

            }
        }
    }
}
