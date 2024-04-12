package org.charleslambret.operateur;

import java.util.List;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String implementation = System.getProperty("reader.implementation", "FILE"); // Default to FILE
        try {
            if (implementation.equals("JDBC")) {
                DatabaseManager dbManager = new DatabaseManager();
                List<OperationData> operations = dbManager.fetchOperationData();
                String outputDirectory = System.getProperty("user.dir");
                ProcesseurFichiers.processOperations(operations, outputDirectory);
            } else {
                String dirPath = args.length == 1 ? args[0] : System.getProperty("user.dir");
                ProcesseurFichiers.processDirectory(dirPath);
            }
        } catch (SQLException | IOException e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
