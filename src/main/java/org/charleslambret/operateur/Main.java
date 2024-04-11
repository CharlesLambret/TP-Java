package org.charleslambret.operateur;
import java.util.List; 
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            List<OperationData> operations = dbManager.fetchOperations();
            String outputDirectory = System.getProperty("user.dir"); // Use current directory as output directory
            ProcesseurFichiers.processOperations(operations, outputDirectory);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des données : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur I/O : " + e.getMessage());
        } catch (OperationException e) {
            System.err.println("Erreur d'opération : " + e.getMessage());
        }
    }
}
