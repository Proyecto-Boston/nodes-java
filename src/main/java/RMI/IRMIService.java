package RMI;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.*;
import java.rmi.registry.*;

public interface IRMIService extends Remote {
    public void uploadFile(byte[] mybyte, String serverpath, int length) throws RemoteException;
    public byte[] downloadFile(String servername) throws RemoteException;
    public String[] listFiles(String serverpath) throws RemoteException;
    public boolean createDirectory(String serverpath) throws RemoteException;
    public boolean removeDirectoryOrFile(String serverpath) throws RemoteException;
}

