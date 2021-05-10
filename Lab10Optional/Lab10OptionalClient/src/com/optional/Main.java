package com.optional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port

        Scanner scan = new Scanner(System.in); // for client input

        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())) ) {

            System.out.println("Hi! Register or login using proper commands, or stop the server using 'stop'.");
            System.out.print("Enter a command: ");
            String request = scan.nextLine();

            out.println(request); // sending our command to the server
            String response = in.readLine(); // waiting a response from the server

            if (response.equals("Server stopped!")) {
                System.out.println(response);
            }
            if (response.equals("Connected!")) {
                System.out.println(response);

                // client connected
                while (true) {
                    System.out.print("Enter a command: ");
                    request = scan.nextLine();

                    out.println(request); // sending our command to the server

                    // exit command
                    if (request.equals("exit")) {
                        System.out.println("Goodbye!");
                        break;
                    }

                    response = in.readLine(); // waiting a response from the server


                    System.out.println(response); // out if the server got our request
//                    response = in.readLine();



                }
            } else if (response.equals("Not connected!")) {
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}