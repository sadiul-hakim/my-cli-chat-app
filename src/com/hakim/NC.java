package com.hakim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class NC {
    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public NC(Socket socket) throws IOException {
        this.socket = socket;
        this.out=new PrintWriter(socket.getOutputStream());
        this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public Socket getSocket() {
        return socket;
    }
    
    public String reader(){
        String msg=null;
        try {
            msg=in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(NC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return msg;
    }
    
    public void writer(String text){
        out.println(text);
        out.flush();
    }
}
