package com.optional;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SimpleServer {

    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public List<User> users;

    public SimpleServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                // Execute the client's request in a new thread
                new ClientThread(socket, serverSocket).start();

                System.out.println("A client has connected!");
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }

    public void addUser(String name) {
        users.add(new User(name));
    }
}
