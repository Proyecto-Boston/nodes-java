import RMI.RMIService;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server implements Serializable{

    public static void main(String[] args) {

        try{

            int portnumber = 1990;
            Registry reg = LocateRegistry.createRegistry(portnumber);   //Creates and exports a Registry instance on the local host that accepts requests
            //on the specified port.
            RMIService  rmiService = new RMIService("");

            System.out.println("Server is ready.");
            System.out.println(portnumber);
        }
        catch(Exception e){
            System.out.println("Server failed: " + e);
        }
    }
}
