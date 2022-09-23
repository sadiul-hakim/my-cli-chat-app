
package com.hakim;

import java.util.Scanner;

/**
 *
 * @author Hakim
 */
public class ClinetWriter implements Runnable{
    private final NC nc;

    public ClinetWriter(NC nc) {
        this.nc = nc;
    }

    @Override
    public void run() {
        while(true){
            Scanner input=new Scanner(System.in);
            String text=input.nextLine();
            
            nc.writer(text);
        }
    }
    
    
}
