package com.hakim;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class Client {

    public static void main(String[] args) {
        try ( Socket socket = new Socket("127.0.0.1", 2222)) {
            System.out.println("Client started");

            NC nc = new NC(socket);

            Scanner input = new Scanner(System.in);
            String name = input.nextLine();

            nc.writer(name);

            Thread writer = new Thread(new ClinetWriter(nc));
            Thread reader = new Thread(new ClientReader(nc));

            writer.setName("Client Writer");
            reader.setName("Client Reader");

            writer.start();
            reader.start();
            //Thread writer=new Thread(new ClinetWriter(nc));

            try {
                writer.join();
                reader.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
