package org.charleslambret.operateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://SG-hetic-mt4-java-5275-pgsql-master.servers.mongodirector.com:5432/TP";
    private static final String USER = "etudiant";
    private static final String PASSWORD = "MT4@hetic2324";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<OperationData> fetchOperations() throws SQLException {
        List<OperationData> operations = new ArrayList<>();
        String sql = "SELECT f.nom, l.param1, l.param2, l.operateur FROM fichier f JOIN ligne l ON f.id = l.fichier_id WHERE f.type = 'OP'";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                operations.add(new OperationData(rs.getString("nom"), rs.getDouble("param1"), rs.getDouble("param2"), rs.getString("operateur")));
            }
        }
        return operations;
    }
}
