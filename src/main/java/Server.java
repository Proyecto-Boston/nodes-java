import RMI.RMIService;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server implements Serializable{

    public static void main(String[] args) {

        try{

            int portnumber = 1099;
            Registry registry = LocateRegistry.createRegistry(portnumber);
            RMIService  rmiService = new RMIService("C:/Users/Jhon/Documents/PruebaRMI");

            registry.bind("Node1", rmiService);
            Naming.rebind("/node1", rmiService);


            System.out.println("Node in port:" + portnumber);
        }
        catch(Exception e){
            System.out.println("Server failed: " + e);
        }
    }
}
