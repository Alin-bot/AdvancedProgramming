package com.compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {

    private Socket socket = null ;
    public ServerSocket serverSocket;

    public ClientThread (Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
    }

    public void run () {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())){

            // get commands from client
            while(true) {
                String request = in.readLine();

                if (request.equals("stop")) {
                    out.println("Server stopped!");
                    out.flush();
                    System.out.println("The server will stop!");
                    serverSocket.close();
                    break;
                }

                out.println("Server received the request ... ");

                if (request.equals("exit")) {
                    out.println("exit");
                    out.flush();
                    System.out.println("A client has disconnected!");
                    break;
                }
                out.flush();
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
