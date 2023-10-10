package org.example.RMI_Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRMI extends Remote {
    byte[] getFileInBytes(String filePath) throws RemoteException;
}
