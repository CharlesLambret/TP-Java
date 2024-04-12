package org.charleslambret.operateur;

import org.charleslambret.operateur.processfichier.FileReader;
import org.charleslambret.operateur.processfichier.FileWriter;
import org.charleslambret.operateur.processfichier.ImplementationFileReader;
import org.charleslambret.operateur.processfichier.ImplementationFileWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String implementation = System.getProperty("reader.implementation", "FILE");
        try {
            FileReader fileReader = new ImplementationFileReader(); 
            FileWriter fileWriter = new ImplementationFileWriter(); 
            ProcesseurFichiers processor = new ProcesseurFichiers(fileReader, fileWriter);

            if (implementation.equals("JDBC")) {
                DatabaseManager dbManager = new DatabaseManager();
                List<OperationData> operations = dbManager.fetchOperationData();
                String outputDirectory = System.getProperty("user.dir");
                for (OperationData operation : operations) {
                    Path outputPath = Paths.get(outputDirectory, operation.getFileName());
                    processor.processFile(outputPath); // Adjust to match the new method signature
                }
            } else {
                String dirPath = args.length == 1 ? args[0] : System.getProperty("user.dir");
                Paths.get(dirPath).toFile().listFiles(file -> {
                    if (file.isFile() && file.getName().endsWith(".op")) {
                        try {
                            processor.processFile(file.toPath());
                        } catch (IOException e) {
                            System.err.println("Error processing file: " + file.getAbsolutePath());
                        }
                    }
                    return false;
                });
            }
        } catch (SQLException | IOException e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
