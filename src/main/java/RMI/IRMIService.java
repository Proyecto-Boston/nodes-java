package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIService extends Remote {
    public String uploadFile(String nameWithExt, String userPath, byte[] fileData) throws RemoteException;
    public byte[] downloadFile(String path) throws RemoteException;
    public boolean createDirectory(String path) throws RemoteException;
    public boolean removeDirectoryOrFile(String path) throws RemoteException;
    public boolean changeFilePath(String path, String newName) throws RemoteException;
}

