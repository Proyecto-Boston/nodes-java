package RMI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIService extends UnicastRemoteObject implements IRMIService, Serializable {
    
    private String appPath;
    
    public RMIService(String appPath) throws RemoteException {
        this.appPath = appPath;
    }
    @Override
    public String uploadFile(String userPath, byte[] fileData) throws RemoteException {
        try {
            File pathFile = new File(userPath);
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
    public byte[] downloadFile(String userPath) throws RemoteException {
        byte [] mydata;

        File serverpathfile = new File(userPath);
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
    public boolean createDirectory(String userPath) throws RemoteException {
        File newFolder = new File(userPath);
        return newFolder.mkdir();
    }

    @Override
    public boolean removeDirectoryOrFile(String userPath) throws RemoteException {
        File deleteFolder = new File(userPath);
        return deleteFolder.delete();
    }

    @Override
    // * This method is also used for changing the name of the file
    public boolean changeFilePath(String userPath, String newPath) throws RemoteException {
        File currentFile = new File(userPath);
        File fileRelocated = new File(newPath);

        return  currentFile.renameTo(fileRelocated);
    }
}
