package org.example.RMI_Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class server {
    public static void main(String[] args){
        try {
            System.setProperty("java.rmi.server.hostname", "IP" );
            iRMI server = new impRMI();
            LocateRegistry.createRegistry(1802);
            Naming.rebind("RMI", server);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }
}
