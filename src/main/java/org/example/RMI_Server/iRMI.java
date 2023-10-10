package org.example.RMI_Server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRMI extends Remote {
    byte[] getFileInBytes(String filePath) throws RemoteException;
}
