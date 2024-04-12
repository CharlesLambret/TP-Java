package org.charleslambret.operateur;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            String implementation = System.getProperty("reader.implementation", "FILE");
            if (implementation.equals("JDBC")) {
                DatabaseManager dbManager = context.getBean("databaseManager", DatabaseManager.class);
                List<OperationData> operations = dbManager.fetchOperationData();
                String outputDirectory = System.getProperty("user.dir");
                ProcesseurFichiers processeur = context.getBean("processeurFichiers", ProcesseurFichiers.class);
                processeur.processOperations(operations, outputDirectory);
            } else {
                String dirPath = args.length == 1 ? args[0] : System.getProperty("user.dir");
                ProcesseurFichiers processeur = context.getBean("processeurFichiers", ProcesseurFichiers.class);
                processeur.processDirectory(dirPath);
            }
        } catch (SQLException | IOException e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }
}
