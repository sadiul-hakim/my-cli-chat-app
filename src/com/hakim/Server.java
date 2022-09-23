package com.hakim;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2222);
        HashMap<String, NC> list = new HashMap<>();
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();

            NC nc = new NC(socket);
            Thread cClient = new Thread(new CreateClient(list, nc));
            cClient.setName("Creates client");
            cClient.start();

            try {
                cClient.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
