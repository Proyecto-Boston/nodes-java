package org.example.RMI_Server;

import java.rmi.server.UnicastRemoteObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.io.IOException;

public class impRMI extends UnicastRemoteObject implements iRMI {
    protected impRMI() throws RemoteException {
        super();
    }

    @Override
    public byte[] getFileInBytes(String filePath) throws RemoteException {
        try {
            // Convertir el archivo a bytes y devolverlo
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            throw new RemoteException("Error al leer el archivo", e);
        }
    }
}

