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
    
    private final String appPath;
    
    public RMIService(String appPath) throws RemoteException {
        this.appPath = appPath;
    }
    @Override
    public String uploadFile(String nameWithExt, String userPath, byte[] fileData) throws RemoteException {
        System.out.println("Path: "+appPath + "/"+ userPath);
        try {
            File filePath = new File(appPath + "/" + userPath);

            if(!filePath.exists()){
                if(!filePath.mkdir()) return "Error al crear la carpeta";
            }
            FileOutputStream out = new FileOutputStream(filePath+ "/" + nameWithExt);

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

        File serverpathfile = new File(appPath + userPath);
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
        File newFolder = new File(appPath + userPath);
        return newFolder.mkdir();
    }

    @Override
    public boolean removeDirectoryOrFile(String userPath) throws RemoteException {
        File deleteFolder = new File(appPath + userPath);
        return deleteFolder.delete();
    }

    @Override
    // * This method is also used for changing the name of the file
    public boolean changeFilePath(String userPath, String newPath) throws RemoteException {
        File currentFile = new File(appPath + userPath);
        File fileRelocated = new File(newPath);

        return  currentFile.renameTo(fileRelocated);
    }
}
