import rmi.RMIService;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server implements Serializable{

    public static void main(String[] args) {

        try{

            int portnumber = 1099;
            RMIService  rmiService = new RMIService("/home/java-admin/storage");
            Registry registry = LocateRegistry.createRegistry(portnumber);
            registry.rebind("node", rmiService);

           // Naming.rebind("rmi://localhost:1099/node", rmiService);

            //System.out.println("CAmbiosss");
            System.out.println("Node in port:" + portnumber);
        }
        catch(Exception e){
            System.out.println("Server failed: " + e);
        }
    }
}
