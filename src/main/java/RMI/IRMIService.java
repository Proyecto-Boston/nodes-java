package RMI;
import java.rmi.*;

public interface IRMIService extends Remote {
    public void uploadFile(byte[] mybyte, String path, int length) throws RemoteException;
    public byte[] downloadFile(String servername) throws RemoteException;
    public String[] listFiles(String path) throws RemoteException;
    public boolean createDirectory(String path) throws RemoteException;
    public boolean removeDirectoryOrFile(String path) throws RemoteException;
}

