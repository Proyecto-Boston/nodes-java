package rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIService extends UnicastRemoteObject implements IRMIService, Serializable {
    
    private final String appPath = "/home/nodo/storage";
    //no sé pero está en lo nuestro
    public RMIService() throws RemoteException {
        super();
    }
    @Override
    public int uploadFile(String nameWithExt, String userPath, byte[] fileData) throws RemoteException {
        System.out.println("Solicitud para subir!");
        try {
            File filePath = new File(appPath + "/" + userPath);

            if(!filePath.exists()){
                if(!filePath.mkdir()) return 500;
            }
            FileOutputStream out = new FileOutputStream(filePath+ "/" + nameWithExt);

            out.write(fileData);
            out.flush();
            out.close();

            return 200;

        } catch (IOException e) {
            e.printStackTrace();
            return 500;
        }

    }
    @Override
    public void printMessage(String msg) throws RemoteException {
        System.out.println("Message from client: " + msg);
    }

    @Override
    public byte[] downloadFile(String filePath) throws RemoteException {
        byte [] mydata;

        File serverpathfile = new File(appPath + "/" + filePath);
        mydata=new byte[(int) serverpathfile.length()];
        if(mydata.length == 0) return null;

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
        File newFolder = new File(appPath + "/" + userPath);
        return newFolder.mkdir();
    }

    @Override
    public boolean removeFile(String filePath) throws RemoteException {
        System.out.println(appPath + "/" + filePath);
        File deleteFolder = new File(appPath + "/" + filePath);
        return deleteFolder.delete();
    }

    public boolean removeFolder(String folderPath) throws RemoteException {
        File folder = new File(appPath + "/" + folderPath);

        return recursiveDelete(folder);
    }

    private boolean recursiveDelete(File folder){
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    recursiveDelete(file);
                }
            }
        }
        return folder.delete();
    }

    @Override
    // * This method is also used for changing the name of the file
    public boolean changeFilePath(String userPath, String newPath) throws RemoteException {
        File currentFile = new File(appPath + "/" + userPath);
        File fileRelocated = new File(appPath + "/" + newPath);

        return  currentFile.renameTo(fileRelocated);
    }
}
