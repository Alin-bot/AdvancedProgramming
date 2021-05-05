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

            // Send a request to the server
            while (true) {
                System.out.print("Enter a command: ");
                String request = scan.nextLine();

                out.println(request); // sending our command to the server
                String response = in.readLine(); // waiting a response from the server

                // if the server stopped
                if (response.equals("Server stopped!")) {
                    System.out.println("Server stopped!");
                    break;
                }

                System.out.println(response); // out if the server got our request

                if (request.equals("exit")) {
                    response = in.readLine();
                    System.out.println("Goodbye!");
                    break;
                }



            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}