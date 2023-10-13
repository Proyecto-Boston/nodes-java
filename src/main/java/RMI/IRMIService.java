package RMI;
import java.rmi.*;

public interface IRMIService extends Remote {
    public String uploadFile(byte[] fileData, String path, int length) throws RemoteException;
    public byte[] downloadFile(String path) throws RemoteException;
    public boolean createDirectory(String path) throws RemoteException;
    public boolean removeDirectoryOrFile(String path) throws RemoteException;
    public boolean changeFileName(String newName, String path) throws RemoteException;
}

