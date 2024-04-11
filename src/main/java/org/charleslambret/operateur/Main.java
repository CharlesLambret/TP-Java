package org.charleslambret.operateur;
import java.util.List; 
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            List<OperationData> operations = dbManager.fetchOperationData();
            String outputDirectory = System.getProperty("user.dir"); 
            ProcesseurFichiers.processOperations(operations, outputDirectory);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des données : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur I/O : " + e.getMessage());
        }
    }
}
