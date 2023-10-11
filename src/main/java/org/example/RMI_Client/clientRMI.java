package org.example.RMI_Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class clientRMI {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            // Obtener el registro RMI
            Registry registry = LocateRegistry.getRegistry("192.168.1.14", 1082);

            // Buscar el servidor en el registro RMI
            iRMI server = (iRMI) registry.lookup("iRMI");

            // Proporcionar la ruta del archivo que se desea y obtenerlo en bytes
            String filePath = scanner.nextLine(); // Incluir el nombre del archivo con la extension
            byte[] fileData = server.getFileInBytes(filePath);

            System.out.println("Ingrese la ruta para guardar el archivo");
            String fileSaveString = scanner.nextLine(); // Incluir el nombre del archivo con la extension

            // Opcional: Guardar el archivo en el sistema local del cliente
            Files.write(Paths.get(fileSaveString), fileData);

            System.out.println("Archivo descargado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
