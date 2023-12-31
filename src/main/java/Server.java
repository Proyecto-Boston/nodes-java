import rmi.IRMIService;
import rmi.RMIService;
import java.io.Serializable;
//import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server implements Serializable{

    public static void main(String[] args) {

        try{
            
            int portnumber = Integer.parseInt(args[0]);
            RMIService  rmiService = new RMIService(args [1]);
            IRMIService service = (IRMIService) rmiService;
            //System.setProperty("java.rmi.server.hostname","192.168.1.18");
            Registry registry = LocateRegistry.createRegistry(portnumber);
            registry.rebind("node", service);
           // Naming.rebind("rmi://localhost:1099/node", rmiService);

            System.out.println("Node in port:" + portnumber);
        }
        catch(Exception e){
            System.out.println("Server failed: " + e);
        }
    }
}
