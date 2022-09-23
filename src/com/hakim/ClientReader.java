package com.hakim;

/**
 *
 * @author Hakim
 */
public class ClientReader implements Runnable{

    private final NC nc;

    public ClientReader(NC nc) {
        this.nc = nc;
    }
    
    @Override
    public void run() {
        while(true){
            String msg=nc.reader();
            
            System.out.println("Received : "+msg);
        }
    }
    
}
