package RMI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIService extends UnicastRemoteObject implements IRMIService, Serializable {

    protected RMIService(String path) throws RemoteException {
        File storageDir = new File(path);
        storageDir.mkdir();
    }
    @Override
    public String uploadFile(byte[] fileData, String path, int length) throws RemoteException {
        try {
            File pathFile = new File(path);
            FileOutputStream out = new FileOutputStream(pathFile);

            out.write(fileData);
            out.flush();
            out.close();

            return "Archivo subido exitosamente!";

        } catch (IOException e) {
            e.printStackTrace();
            return "Error al subir el archivo.";
        }

    }

    @Override
    public byte[] downloadFile(String path) throws RemoteException {
        byte [] mydata;

        File serverpathfile = new File(path);
        mydata=new byte[(int) serverpathfile.length()];
        FileInputStream in;
        try {
            in = new FileInputStream(serverpathfile);
            try {
                in.read(mydata, 0, mydata.length);
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        return mydata;
    }

    @Override
    public String[] listFiles(String path) throws RemoteException {
        return new String[0];
    }

    @Override
    public boolean createDirectory(String path) throws RemoteException {
        return false;
    }

    @Override
    public boolean removeDirectoryOrFile(String path) throws RemoteException {
        return false;
    }
}
