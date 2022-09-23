package com.hakim;

import java.util.HashMap;

/**
 *
 * @author Hakim
 */
public class Chatting implements Runnable {

    private final HashMap<String, NC> list;
    private final NC nc;//server

    public Chatting(HashMap<String, NC> list, NC nc) {
        this.list = list;
        this.nc = nc;
    }

    @Override
    public void run() {
        while (true) {
            String msg = nc.reader();
            /*
             1.Sender
             2.Receiver
             3.Key(List,Send)
             4.Msg(Msg/null)
             */

            if (msg.toLowerCase().contains("list")) {
                StringBuilder sb = new StringBuilder();
                sb.append("List of Clients : \n");
                int i=1;
                for (String name:list.keySet()) {
                    sb.append(i);
                    sb.append(name);
                    sb.append("\n");
                    i++;
                }
                
                nc.writer(sb.toString());
            }else if(msg.toLowerCase().contains("send")){
                String[] texts=Util.split(msg);
                String sender=texts[0];
                String receiver=texts[1];
                String message=texts[3];
                
                String text=sender+" says "+message;
                
                NC receiverNc=list.get(receiver);
                receiverNc.writer(text);
            }
        }
    }
}
