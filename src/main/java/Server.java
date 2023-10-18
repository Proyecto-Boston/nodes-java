import RMI.RMIService;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server implements Serializable{

    public static void main(String[] args) {

        try{

            int portnumber = 1099;
            //System.setProperty("java.rmi.server.hostname","192.168.1.4");
            Registry registry = LocateRegistry.createRegistry(portnumber);
            RMIService  rmiService = new RMIService("/home/java-admin/storage");
            registry.rebind("node", rmiService);
            //Naming.rebind("rmi://192.168.1.4:1099/nodo", rmiService);

            //System.out.println("CAmbiosss");
            System.out.println("Node in port:" + portnumber);
        }
        catch(Exception e){
            System.out.println("Server failed: " + e);
        }
    }
}
