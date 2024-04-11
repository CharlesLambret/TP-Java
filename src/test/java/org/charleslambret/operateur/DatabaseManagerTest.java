package org.charleslambret.operateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class DatabaseManagerTest {

    @Test
    public void testConnect() {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            Assertions.assertNotNull(dbManager.connect());
        } catch (SQLException e) {
            Assertions.fail("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    @Test
    public void testFetchOperationData() {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            Assertions.assertNotNull(dbManager.fetchOperationData());
        } catch (SQLException e) {
            Assertions.fail("Erreur lors de la récupération des données : " + e.getMessage());
        }
    }
}
