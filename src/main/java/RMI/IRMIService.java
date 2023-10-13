package RMI;
import java.rmi.*;

public interface IRMIService extends Remote {
    public String uploadFile(String path, byte[] fileData) throws RemoteException;
    public byte[] downloadFile(String path) throws RemoteException;
    public boolean createDirectory(String path) throws RemoteException;
    public boolean removeDirectoryOrFile(String path) throws RemoteException;
    public boolean changeFilePath(String path, String newName) throws RemoteException;
}

