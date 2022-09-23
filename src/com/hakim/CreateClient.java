package com.hakim;

import java.util.HashMap;

/**
 *
 * @author Hakim
 */
public class CreateClient implements Runnable{
    private final HashMap<String, NC> list;
    private final NC nc;//server

    public CreateClient(HashMap<String, NC> list, NC nc) {
        this.list = list;
        this.nc = nc;
    }

    @Override
    public void run() {
        
        String name=nc.reader();
        list.put(name, nc);
        System.out.println("Client "+ name +" connected\n");
        
        nc.writer("You can chat now : \n");
        
        new Thread(new Chatting(list,nc)).start();
    }
    
    
}
