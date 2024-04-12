package org.charleslambret.operateur;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MainDatabaseTests {

    @Test
    void testDatabaseConnection() {
        String url = "jdbc:postgresql://SG-hetic-mt4-java-5275-pgsql-master.servers.mongodirector.com:5432/TP";
        String user = "etudiant";
        String password = "MT4@hetic2324";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            assertNotNull(connection);
        } catch (SQLException e) {
            fail("Should have connected to the database");
        }
    }

    @Test
    void testFetchOperationData() {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            List<OperationData> operations = dbManager.fetchOperationData();
            assertNotNull(operations);
            assertFalse(operations.isEmpty()); 
        } catch (SQLException e) {
            fail("Failed to fetch data from the database");
        }
    }

    @Test
    void testProcessOperations() {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            List<OperationData> operations = dbManager.fetchOperationData();
            assertNotNull(operations);
            String directory = System.getProperty("user.dir");
            
            ProcesseurFichiers processeur = new ProcesseurFichiers();
            processeur.processOperations(operations, directory);

        } catch (SQLException | IOException e) {
            fail("Processing operations failed due to " + e.getMessage());
        }
    }
}
