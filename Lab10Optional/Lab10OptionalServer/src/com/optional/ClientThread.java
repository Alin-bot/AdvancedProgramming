package com.optional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

class ClientThread extends Thread {

    private Socket socket = null ;
    public ServerSocket serverSocket;
    private User user = null;
    public List<User> socialNetwork;

    public ClientThread (Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
    }

    public void run () {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())){

            String request = in.readLine(); // read the request

            if (request.equals("stop")) {
                out.println("Server stopped!");
                out.flush();
                System.out.println("The server will stop!");
                serverSocket.close();
            }

            String arr[] = request.split(" ", 2); // to see the command

            if (arr[0].equals("register")) {
                user = new User(arr[1]);
                for (User people : socialNetwork) {
                    if (people.getName().equals(user.getName())) {
                        out.println("Not connected!");
                        out.flush();
                        socket.close();
                    }
                }
                socialNetwork.add(user);
                out.println("Connected!");
                out.flush();

            } else if (arr[0].equals("login")) {
                user = new User(arr[1]);
                int ok = 1;

                for (User people : socialNetwork) {
                    if (people.getName().equals(user.getName())){
                        out.println("Connected!");
                        out.flush();
                        ok = 0;
                        break;
                    }
                }
                if (ok == 1) {
                    out.println("Not connected!");
                    out.flush();
                    socket.close();
                }
            } else {
                out.println("Not connected!");
                out.flush();
                socket.close();
            }

            // get commands from client
            while(true) {
                request = in.readLine();

                if (request.equals("exit")) {
                    System.out.println("A client has disconnected!");
                    break;
                }

                out.println("Server received the request ... ");
                out.flush();

                if(request.equals("read")) {
                    if (user != null) {
                        // TODO: read messages
                        out.println();
                    }
                } else {
                    String newRequest[] = request.split(" ", 2);

                    if (newRequest[0].equals("friend")) {
                        // TODO: add friends
                    } else if (newRequest[0].equals("send")) {
                        // TODO: send message
                    }
                }
            }
            socket.close();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
